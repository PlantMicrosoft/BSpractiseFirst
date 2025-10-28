<template>
  <div class="min-h-screen bg-gray-50 flex flex-col">
    <header class="bg-white border-b border-gray-200 px-6 py-4">
      <div class="flex items-center justify-between">
        <h1 class="text-2xl font-bold">我的书店</h1>
        <div class="flex items-center gap-4 flex-1 max-w-3xl mx-8">
          <input
            type="search"
            placeholder="search"
            class="flex-1 px-4 py-2 border border-gray-300 rounded-full focus:outline-none focus:ring-2 focus:ring-blue-500"
          />
          <button class="px-6 py-2 border border-gray-900 rounded hover:bg-gray-100">查询</button>
        </div>
        <div class="flex items-center gap-4">
          <div class="flex items-center gap-2 px-3 py-1 border border-gray-900 rounded">
            <span class="font-semibold">￥19.99</span>
            <span class="bg-gray-200 px-2 py-0.5 rounded text-sm">2</span>
          </div>
          <router-link
            :to="{ name: 'shopping-cart' }"
            class="text-2xl hover:opacity-75 transition-opacity"
          >
            🛒
          </router-link>
        </div>
      </div>
    </header>

    <div class="flex flex-1 relative">
      <aside
        :style="{ width: sidebarWidth + 'px' }"
        class="bg-blue-50 border-r border-gray-300 flex-shrink-0 relative"
      >
        <div class="p-6">
          <h2 class="text-lg font-semibold mb-4">按类别购物</h2>
          <!-- 添加调试信息 -->
          <div class="text-xs text-gray-500 mb-2">
            分类数量: {{ categories.length }}
          </div>
          <nav class="space-y-2">
            <a
              href="#"
              @click.prevent="showAllProducts"
              :class="[
                'block hover:underline',
                selectedCategoryId === null ? 'text-blue-800 font-semibold' : 'text-blue-600'
              ]"
            >
              全部商品
            </a>
            <a
              v-for="category in categories"
              :key="category.id"
              href="#"
              @click.prevent="selectCategory(category.id)"
              :class="[
                'block hover:underline',
                selectedCategoryId === category.id ? 'text-blue-800 font-semibold' : 'text-blue-600'
              ]"
            >
              {{ category.categoryName }}
            </a>
          </nav>
        </div>

        <div
          @mousedown="startResize"
          class="absolute top-0 right-0 w-1 h-full cursor-col-resize hover:bg-blue-400 transition-colors group"
        >
          <div
            class="absolute top-1/2 right-0 w-1 h-12 bg-gray-400 group-hover:bg-blue-500 transition-colors"
          ></div>
        </div>
      </aside>

      <main class="flex-1 p-8">
        <div v-if="loading" class="text-center py-8">
          <p>加载中...</p>
        </div>

        <div v-else class="grid grid-cols-5 gap-6 mb-8">
          <router-link
            v-for="product in products"
            :key="product.id"
            :to="{ name: 'product-detail', params: { id: product.id } }"
            class="bg-white border border-gray-200 rounded p-4 hover:shadow-lg transition-shadow cursor-pointer"
          >
            <div class="aspect-square bg-gray-100 mb-3 flex items-center justify-center">
              <svg
                class="w-16 h-16 text-gray-300"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M4 16l4.586-4.586a2 2 0 012.828 0L16 16m-2-2l1.586-1.586a2 2 0 012.828 0L20 14m-6-6h.01M6 20h12a2 2 0 002-2V6a2 2 0 00-2-2H6a2 2 0 00-2 2v12a2 2 0 002 2z"
                />
              </svg>
            </div>
            <h3 class="font-semibold text-sm mb-1">{{ product.name }}</h3>
            <p class="text-gray-600 text-xs mb-2">{{ product.description }}</p>
            <p class="font-bold mb-3">￥{{ product.price }}</p>
            <button
              @click.prevent.stop
              class="w-full px-4 py-2 border border-gray-900 rounded hover:bg-gray-100 text-sm"
            >
              加入购物车
            </button>
          </router-link>
        </div>

        翻页
        <div class="flex items-center justify-end gap-4">
          <div class="flex items-center gap-2">
            <span class="text-sm">每页多少个:</span>
            <select class="border border-gray-300 rounded px-2 py-1">
              <option>10</option>
              <option>20</option>
              <option>50</option>
            </select>
          </div>
          <span class="text-sm">1 - 10 总共 100</span>
          <div class="flex gap-2">
            <button class="p-2 border border-gray-300 rounded hover:bg-gray-100">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M15 19l-7-7 7-7"
                />
              </svg>
            </button>
            <button class="p-2 border border-gray-300 rounded hover:bg-gray-100">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M9 5l7 7-7 7"
                />
              </svg>
            </button>
          </div>
        </div>
      </main>
    </div>

    <footer class="bg-white border-t border-gray-200 py-4">
      <div class="flex justify-center gap-6 text-sm">
        <a href="#" class="hover:underline">关于我们</a>
        <a href="#" class="hover:underline">联系我们</a>
        <a href="#" class="hover:underline">获得帮助</a>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'

const sidebarWidth = ref(200)
const isResizing = ref(false)
const categories = ref([])
const products = ref([])
const selectedCategoryId = ref(null)
const loading = ref(false)

// 获取分类数据
const fetchCategories = async () => {
  try {
    const response = await fetch('http://localhost:8080/api/categories')
    const data = await response.json()
    console.log('分类数据响应:', data) // 添加调试日志
    if (data.status === 200) {  // 修改这里：使用 status 而不是 success
      categories.value = data.data
      console.log('分类数据:', categories.value) // 添加调试日志
    } else {
      console.error('获取分类失败:', data.message)
    }
  } catch (error) {
    console.error('获取分类失败:', error)
  }
}

// 获取产品数据
const fetchProducts = async (categoryId = null) => {
  loading.value = true
  try {
    const url = categoryId
      ? `http://localhost:8080/api/products/category/${categoryId}`
      : 'http://localhost:8080/api/products'

    const response = await fetch(url)
    const data = await response.json()
    console.log('产品数据响应:', data) // 添加调试日志
    if (data.status === 200) {
      products.value = data.data.content || []
      console.log('产品数据:', products.value) // 添加调试日志
    }
  } catch (error) {
    console.error('获取产品失败:', error)
  } finally {
    loading.value = false
  }
}

// 选择分类
const selectCategory = (categoryId) => {
  selectedCategoryId.value = categoryId
  fetchProducts(categoryId)
}

// 显示所有产品
const showAllProducts = () => {
  selectedCategoryId.value = null
  fetchProducts()
}

const startResize = (e) => {
  isResizing.value = true
  document.addEventListener('mousemove', handleResize)
  document.addEventListener('mouseup', stopResize)
  e.preventDefault()
}

const handleResize = (e) => {
  if (isResizing.value) {
    const newWidth = e.clientX
    if (newWidth >= 150 && newWidth <= 400) {
      sidebarWidth.value = newWidth
    }
  }
}

const stopResize = () => {
  isResizing.value = false
  document.removeEventListener('mousemove', handleResize)
  document.removeEventListener('mouseup', stopResize)
}

onMounted(() => {
  fetchCategories()
  fetchProducts()
})

onUnmounted(() => {
  document.removeEventListener('mousemove', handleResize)
  document.removeEventListener('mouseup', stopResize)
})
</script>
