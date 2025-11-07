# BS实训第一次————前后端分离问题协调作业!

    
    secomm_1 (1)/                  # 项目根目录
    ├── .idea/                     # IDE配置文件目录 (如IntelliJ IDEA)
    ├── package-lock.json          # npm依赖锁文件 (记录前端项目的具体依赖版本)
    └── secomm/                    # 核心业务模块
        ├── .idea/                 # 模块IDE配置 (包含后端Maven项目的配置)
        ├── backend/               # 后端代码 (Java + Maven + Spring Boot)
        │   ├── pom.xml            # Maven核心配置文件：管理后端所有依赖、插件和项目信息
        │   └── src/
        │       ├── main/          # 主程序代码目录
        │       │   ├── java/      # Java源代码根目录
        │       │   │   └── com/
        │       │   │       └── secomm/  # 项目根包 (通常与项目名一致)
        │       │   │           ├── SecommApplication.java  # 后端启动类(Spring Boot入口)
        │       │   │           ├── controller/             # 控制器层：接收前端请求，返回响应
        │       │   │           ├── service/                # 服务层接口：定义业务逻辑
        │       │   │           │   └── impl/               # 服务实现层：具体实现业务逻辑
        │       │   │           ├── mapper/                 # 数据访问层(MyBatis)：定义数据库操作接口
        │       │   │           ├── repository/             # 数据访问层(JPA)：定义数据库操作接口
        │       │   │           ├── entity/                 # 实体类：映射数据库表结构
        │       │   │           ├── dto/                    # 数据传输对象：用于前后端数据交互
        │       │   │           ├── vo/                     # 视图对象：用于封装前端展示数据
        │       │   │           ├── config/                 # 配置类：配置Spring Bean、框架行为等
        │       │   │           ├── exception/              # 异常处理：自定义异常和全局异常处理器
        │       │   │           ├── util/                   # 工具类：提供通用功能方法
        │       │   │           └── constant/               # 常量类：定义项目中固定不变的常量
        │       │   └── resources/  # 资源文件目录
        │       │       ├── application.yml                # 主配置文件：配置端口、数据库连接等
        │       │       ├── application-dev.yml            # 开发环境配置
        │       │       ├── application-prod.yml           # 生产环境配置
        │       │       ├── mapper/                        # MyBatis映射文件：存放XML形式的SQL语句
        │       │       ├── static/                        # 静态资源(后端用得较少)
        │       │       └── templates/                     # 模板文件(如邮件模板等)
        │       └── test/           # 测试代码目录
        │           └── java/
        │               └── com/
        │                   └── secomm/
        │                       ├── controller/             # 控制器测试
        │                       ├── service/                # 服务层测试
        │                       └── mapper/                 # 数据访问层测试
        ├── frontend/              # 前端代码 (Vue 3 + Vite)
        │   ├── .idea/             # 前端模块IDE配置
        │   ├── src/
        │   │   ├── assets/        # 静态资源：图片、样式文件等
        │   │   ├── components/    # 可复用UI组件
        │   │   │   └── icons/     # 图标组件
        │   │   ├── router/        # 路由配置：管理页面跳转
        │   │   ├── views/         # 页面组件：各个具体的页面
        │   │   ├── stores/        # 状态管理(Pinia)：管理共享数据
        │   │   ├── services/      # API请求封装：统一调用后端接口
        │   │   ├── utils/         # 工具函数：前端通用工具方法
        │   │   ├── hooks/         # 自定义Hooks：封装可复用的逻辑
        │   │   ├── main.js        # 入口文件：创建Vue实例并挂载
        │   │   └── App.vue        # 根组件：应用入口组件
        │   ├── index.html         # 入口HTML文件
        │   ├── package.json       # 前端项目配置：依赖管理和脚本命令
        │   ├── vite.config.js     # Vite配置文件：构建和开发服务器配置
        │   └── 其他配置文件        # 如ESLint, Tailwind CSS等的配置
        └── pom.xml                # Maven核心配置文件 (可能是父pom，用于管理整个项目)






This is your README. READMEs are where you can communicate what your project is and how to use it.

Write your name on line 6, save it, and then head back to GitHub Desktop.
