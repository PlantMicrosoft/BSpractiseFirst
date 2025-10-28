package org.yiqixue.secomm.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yiqixue.secomm.dto.ApiResponse;
import org.yiqixue.secomm.dto.PageResponse;
import org.yiqixue.secomm.dto.ProductDTO;
import org.yiqixue.secomm.service.ProductService;

/**
 * 商品控制器
 * 提供商品相关的REST API接口
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "商品管理", description = "商品相关的API接口")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    /**
     * 获取所有激活商品（分页）
     *
     * GET /api/products?page=0&size=10&sortBy=name&sortDir=asc
     */
    @GetMapping
    @Operation(summary = "获取所有商品", description = "分页获取所有激活状态的商品")
    public ResponseEntity<ApiResponse<PageResponse<ProductDTO>>> getAllProducts(
            @Parameter(description = "页码，从0开始")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "每页大小")
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "排序字段")
            @RequestParam(defaultValue = "name") String sortBy,

            @Parameter(description = "排序方向：asc或desc")
            @RequestParam(defaultValue = "asc") String sortDir) {

        log.info("API调用 - 获取所有商品: page={}, size={}, sortBy={}, sortDir={}",
                page, size, sortBy, sortDir);

        PageResponse<ProductDTO> products = productService
                .getAllActiveProducts(page, size, sortBy, sortDir);

        return ResponseEntity.ok(ApiResponse.success(products));
    }

    /**
     * 根据分类ID获取商品（分页）
     *
     * GET /api/products/category/1?page=0&size=10
     */
    @GetMapping("/category/{categoryId}")
    @Operation(summary = "按分类获取商品", description = "根据分类ID分页获取商品列表")
    public ResponseEntity<ApiResponse<PageResponse<ProductDTO>>> getProductsByCategory(
            @Parameter(description = "分类ID")
            @PathVariable Long categoryId,

            @Parameter(description = "页码")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "每页大小")
            @RequestParam(defaultValue = "10") int size,

            @Parameter(description = "排序字段")
            @RequestParam(defaultValue = "name") String sortBy,

            @Parameter(description = "排序方向")
            @RequestParam(defaultValue = "asc") String sortDir) {

        log.info("API调用 - 按分类获取商品: categoryId={}, page={}, size={}",
                categoryId, page, size);

        PageResponse<ProductDTO> products = productService
                .getProductsByCategory(categoryId, page, size, sortBy, sortDir);

        return ResponseEntity.ok(ApiResponse.success(products));
    }

    /**
     * 根据商品ID获取商品详情
     *
     * GET /api/products/123
     */
    @GetMapping("/{productId}")
    @Operation(summary = "获取商品详情", description = "根据商品ID获取商品详细信息")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(
            @Parameter(description = "商品ID")
            @PathVariable Long productId) {

        log.info("API调用 - 获取商品详情: productId={}", productId);

        ProductDTO product = productService.getProductById(productId);

        return ResponseEntity.ok(ApiResponse.success(product));
    }

    /**
     * 搜索商品
     *
     * GET /api/products/search?keyword=coffee&page=0&size=10
     */
    @GetMapping("/search")
    @Operation(summary = "搜索商品", description = "根据关键词搜索商品名称或描述")
    public ResponseEntity<ApiResponse<PageResponse<ProductDTO>>> searchProducts(
            @Parameter(description = "搜索关键词")
            @RequestParam String keyword,

            @Parameter(description = "页码")
            @RequestParam(defaultValue = "0") int page,

            @Parameter(description = "每页大小")
            @RequestParam(defaultValue = "10") int size) {

        log.info("API调用 - 搜索商品: keyword={}, page={}, size={}",
                keyword, page, size);

        PageResponse<ProductDTO> products = productService
                .searchProducts(keyword, page, size);

        return ResponseEntity.ok(ApiResponse.success(products));
    }

    /**
     * 根据SKU获取商品
     *
     * GET /api/products/sku/BOOK-001
     */
    @GetMapping("/sku/{sku}")
    @Operation(summary = "根据SKU获取商品", description = "通过商品SKU获取商品信息")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductBySku(
            @Parameter(description = "商品SKU")
            @PathVariable String sku) {

        log.info("API调用 - 根据SKU获取商品: sku={}", sku);

        ProductDTO product = productService.getProductBySku(sku);

        return ResponseEntity.ok(ApiResponse.success(product));
    }
}