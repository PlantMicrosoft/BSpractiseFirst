# BS实训第一次————前后端分离问题协调作业!

    secomm_1 (1)/                  # 项目根目录
    ├── .idea/                     # 根目录IDE配置
    ├── package-lock.json          # npm依赖锁文件
    └── secomm/                    # 核心业务模块
    ├── .idea/                 # 模块IDE配置（含后端Maven配置）
    ├── backend/               # 后端代码（Java + Maven）
    ├── pom.xml                  # Maven核心配置文件：管理依赖、插件、项目信息（如Spring Boot、数据库驱动等）
    ├── src/
    │   ├── main/                # 主程序代码目录
    │   │   ├── java/            # Java源代码根目录（包结构从这里开始）
    │   │   │   └── com/         # 组织/公司域名反转（示例，实际可能是其他包名，如com.secomm）
    │   │   │       └── secomm/  # 项目根包（通常与项目名一致）
    │   │   │           ├── SecommApplication.java  # 后端启动类（Spring Boot入口，带@SpringBootApplication注解）
    │   │   │           ├── controller/             # 控制器层：接收前端请求，返回响应
    │   │   │           ├── service/                # 服务层：处理核心业务逻辑
    │   │   │           │   └── impl/               # 服务实现类：具体实现service接口的逻辑
    │   │   │           ├── mapper/                 # 数据访问层（MyBatis场景）：定义数据库操作接口
    │   │   │           ├── repository/             # 数据访问层（JPA/MyBatis-Plus场景）：数据库交互接口
    │   │   │           ├── entity/                 # 实体类层：映射数据库表结构（与数据库字段一一对应）
    │   │   │           ├── dto/                    # 数据传输对象：用于前后端/服务间数据传输（按需定义，如请求参数、响应结果）
    │   │   │           ├── vo/                     # 视图对象：用于前端展示的数据封装（按需定义，可能与dto重叠）
    │   │   │           ├── config/                 # 配置类：框架配置（如Spring配置、数据库连接池、拦截器等）
    │   │   │           ├── exception/              # 异常处理：自定义异常类、全局异常处理器
    │   │   │           ├── util/                   # 工具类：通用工具方法（如日期处理、加密、校验等）
    │   │   │           └── constant/               # 常量类：定义项目中的常量（如状态码、错误信息、配置键等）
    │   │   └── resources/       # 资源文件目录
    │   │       ├── application.yml                 # 主配置文件：配置端口、数据库连接、日志、框架参数等
    │   │       ├── application-dev.yml             # 开发环境配置（通过spring.profiles.active激活）
    │   │       ├── application-prod.yml            # 生产环境配置
    │   │       ├── mapper/                         # MyBatis映射文件：存放XML形式的SQL语句（与mapper接口对应）
    │   │       ├── static/                         # 静态资源（如后端需要的固定配置文件、模板等，较少用）
    │   │       └── templates/                      # 模板文件（如邮件模板、报表模板等，按需使用）
    │   └── test/                 # 测试代码目录（结构与main/java对应）
    │       └── java/
    │           └── com/
    │               └── secomm/
    │                   ├── controller/             # 控制器测试类（测试接口是否正常响应）
    │                   ├── service/                # 服务层测试类（测试业务逻辑正确性）
    │                   └── mapper/                 # 数据访问层测试类（测试数据库交互）
    └── frontend/              # 前端代码（Vue 3 + Vite）
    ├── .idea/             # 前端模块IDE配置
    ├── src/
    │   ├── assets/        # 静态资源
    │   ├── components/    # 组件（含icons子目录）
    │   ├── router/        # 路由配置
    │   ├── views/         # 页面组件
    │   ├── main.js        # 入口文件
    │   └── App.vue        # 根组件
    ├── index.html         # 入口HTML
    └── 各类配置文件       # package.json、vite.config.js等







This is your README. READMEs are where you can communicate what your project is and how to use it.

Write your name on line 6, save it, and then head back to GitHub Desktop.
