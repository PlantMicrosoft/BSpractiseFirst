# BS作业第一次 BS作業第一次



secomm_1 （1）/ # 專案根目錄
secomm_1 (1)/                  # 项目根目录
├── .idea/ # 根目錄IDE配置

├── package-lock.json # npm依賴鎖文件
├── .idea/                     # 根目录IDE配置
└── secomm/ # 核心業務模組

    ├── .idea/ # 模組IDE配置（含後端Maven配置）
├── package-lock.json          # npm依赖锁文件
├── backend/ # 後端代碼（Java + Maven）
├── backend/ # 後端代碼（Java + Maven）
├── backend/ # 後端代碼（Java + Maven）
├── backend/ # 後端代碼（Java + Maven）
├── backend/ # 後端代碼（Java + Maven）
├── backend/ # 後端代碼（Java + Maven）






        ├── pom.xml # Maven核心配置檔：管理依賴、外掛程式、專案資訊（如Spring Boot、資料庫驅動等）
└── secomm/ # 核心業務模組├── 來源/

└── secomm/ # 核心業務模組├── 來源/
└── secomm/ # 核心業務模組├── 來源/


└── secomm/ # 核心業務模組├── 來源/
└── secomm/ # 核心業務模組├── 來源/



└── secomm/                    # 核心业务模块├── 來源/



        │ ├── main/ # 主程式代碼目錄

    ├── .idea/                 # 模块IDE配置（含后端Maven配置）
        │ │ ├── java/ # Java原始程式碼根目錄（包結構從這裡開始）

        │ │ │ └── com/ # 組織/公司域名反轉（示例，實際可能是其他包名，如com.secomm）
    ├── backend/               # 后端代码（Java + Maven）

        ├── pom.xml                  # Maven核心配置文件：管理依赖、插件、项目信息（如Spring Boot、数据库驱动等）

        ├── src/

        │   ├── main/                # 主程序代码目录

        │   │   ├── java/            # Java源代码根目录（包结构从这里开始）

        │   │   │   └── com/         # 组织/公司域名反转（示例，实际可能是其他包名，如com.secomm）

        │   │   │       └── secomm/  # 项目根包（通常与项目名一致）
        │ │ │ └── secomm/ # 專案根包（通常與專案名一致）

        │ │ │ ├── SecommApplication.java # 後端啟動類（Spring Boot入口，帶@SpringBootApplication注解）
        │   │   │           ├── SecommApplication.java  # 后端启动类（Spring Boot入口，带@SpringBootApplication注解）
        │ │ │ ├── controller/ # 控制器層：接收前端請求，返回回應

        │ │ │ ├── service/ # 服務層：處理核心業務邏輯
        │   │   │           ├── controller/             # 控制器层：接收前端请求，返回响应
        │ │ │ │ └── impl/ # 服務實現類：具體實現service介面的邏輯

        │ │ │ ├── mapper/ # 數據存取層（MyBatis場景）：定義資料庫操作介面
        │   │   │           ├── service/                # 服务层：处理核心业务逻辑
        │ │ │ ├── repository/ # 數據存取層（JPA/MyBatis-Plus場景）：資料庫交互介面

        │ │ │ ├── entity/ # 實體類層：映射資料庫表結構（與資料庫欄位一一對應）
        │   │   │           │   └── impl/               # 服务实现类：具体实现service接口的逻辑
        │ │ │ ├── dto/ # 數據傳輸物件：用於前後端/服務間數據傳輸（按需定義，如請求參數、回應結果）

        │ │ │ ├── vo/ # 視圖物件：用於前端展示的數據封裝（按需定義，可能與dto重疊）
        │   │   │           ├── mapper/                 # 数据访问层（MyBatis场景）：定义数据库操作接口
        │ │ │ ├── config/ # 配置類：框架配置（如Spring配置、資料庫連接池、攔截器等）

        │ │ │ ├── exception/ # 異常處理：自定義異常類、全域異常處理器
        │   │   │           ├── repository/             # 数据访问层（JPA/MyBatis-Plus场景）：数据库交互接口
        │ │ │ ├── util/ # 工具類：通用工具方法（如日期處理、加密、校驗等）

        │ │ │ └── constant/ # 常量類：定義專案中的常量（如狀態碼、錯誤資訊、配置鍵等）
        │   │   │           ├── entity/                 # 实体类层：映射数据库表结构（与数据库字段一一对应）
        │ │ └── resources/ # 資源文件目錄

        │ │ ├── application.yml # 主配置檔：配置埠、資料庫連接、日誌、框架參數等
        │   │   │           ├── dto/                    # 数据传输对象：用于前后端/服务间数据传输（按需定义，如请求参数、响应结果）
        │ │ ├── application-dev.yml # 開發環境配置（通過spring.profiles.active啟動）

        │ │ ├── application-prod.yml # 生產環境配置
        │   │   │           ├── vo/                     # 视图对象：用于前端展示的数据封装（按需定义，可能与dto重叠）
        │ │ ├── mapper/ # MyBatis映射檔：存放XML形式的SQL語句（與mapper介面對應）

        │ │ ├── static/ # 靜態資源（如後端需要的固定配置檔、範本等，較少用）
        │   │   │           ├── config/                 # 配置类：框架配置（如Spring配置、数据库连接池、拦截器等）
        │ │ └── templates/ # 範本檔（如郵件範本、報表範本等，按需使用）

        │ └── test/ # 測試代碼目錄（結構與main/java對應）
        │   │   │           ├── exception/              # 异常处理：自定义异常类、全局异常处理器
│ └── java/

│ └── com/
        │   │   │           ├── util/                   # 工具类：通用工具方法（如日期处理、加密、校验等）
│ └── secomm/

        │ ├── controller/ # 控制器測試類（測試介面是否正常回應）
        │   │   │           └── constant/               # 常量类：定义项目中的常量（如状态码、错误信息、配置键等）
        │ ├── service/ # 服務層測試類（測試業務邏輯正確性）

        │ └── mapper/ # 資料存取層測試類（測試資料庫交互）
        │   │   └── resources/       # 资源文件目录
└── frontend/ # 前端代碼（View 3 + Fast）

        ├── .idea/ # 前端模組IDE配置
        │   │       ├── application.yml                 # 主配置文件：配置端口、数据库连接、日志、框架参数等├── 來源/

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
