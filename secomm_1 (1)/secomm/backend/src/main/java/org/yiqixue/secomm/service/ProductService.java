package org.yiqixue.secomm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yiqixue.secomm.dto.PageResponse;
import org.yiqixue.secomm.dto.ProductDTO;
import org.yiqixue.secomm.entity.Product;
import org.yiqixue.secomm.exception.ResourceNotFoundException;
import org.yiqixue.secomm.mapper.ProductMapper;
import org.yiqixue.secomm.repository.ProductRepository;

/**
 * 商品服务层
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    /**
     * 获取所有激活状态的商品（分页）
     *
     * @param page 页码（从0开始）
     * @param size 每页大小
     * @param sortBy 排序字段
     * @param sortDir 排序方向（asc/desc）
     * @return 分页商品数据
     */
    public PageResponse<ProductDTO> getAllActiveProducts(
            int page, int size, String sortBy, String sortDir) {

        log.info("获取所有激活商品 - 页码: {}, 大小: {}, 排序: {} {}",
                page, size, sortBy, sortDir);

        // 创建排序对象
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        // 创建分页对象
        Pageable pageable = PageRequest.of(page, size, sort);

        // 查询激活状态的商品
        Page<Product> productPage = productRepository.findByActiveTrue(pageable);

        // 转换为DTO并返回
        return productMapper.toPageResponse(productPage);
    }

    /**
     * 根据分类ID获取商品（分页）
     *
     * @param categoryId 分类ID
     * @param page 页码
     * @param size 每页大小
     * @param sortBy 排序字段
     * @param sortDir 排序方向
     * @return 分页商品数据
     */
    public PageResponse<ProductDTO> getProductsByCategory(
            Long categoryId, int page, int size, String sortBy, String sortDir) {

        log.info("根据分类获取商品 - 分类ID: {}, 页码: {}, 大小: {}",
                categoryId, page, size);

        // 创建排序和分页对象
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        // 查询该分类下的激活商品
        Page<Product> productPage = productRepository
                .findByCategoryIdAndActiveTrue(categoryId, pageable);

        // 如果该分类没有商品，记录日志
        if (productPage.isEmpty()) {
            log.warn("分类ID {} 下没有找到商品", categoryId);
        }

        return productMapper.toPageResponse(productPage);
    }

    /**
     * 根据商品ID获取商品详情
     *
     * @param productId 商品ID
     * @return 商品DTO
     */
    public ProductDTO getProductById(Long productId) {
        log.info("获取商品详情 - 商品ID: {}", productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product", "id", productId));

        return productMapper.toDTO(product);
    }

    /**
     * 搜索商品（根据名称或描述）
     *
     * @param keyword 搜索关键词
     * @param page 页码
     * @param size 每页大小
     * @return 分页商品数据
     */
    public PageResponse<ProductDTO> searchProducts(
            String keyword, int page, int size) {

        log.info("搜索商品 - 关键词: {}, 页码: {}, 大小: {}", keyword, page, size);

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPage = productRepository
                .searchProducts(keyword, pageable);

        return productMapper.toPageResponse(productPage);
    }

    /**
     * 根据SKU获取商品
     *
     * @param sku 商品SKU
     * @return 商品DTO
     */
    public ProductDTO getProductBySku(String sku) {
        log.info("根据SKU获取商品 - SKU: {}", sku);

        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Product", "sku", sku));

        return productMapper.toDTO(product);
    }
}