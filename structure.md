# NutriSport 專案架構說明

## 🏗️ 專案概述

NutriSport 是一個採用 **Kotlin Multiplatform (KMP)** 開發的跨平台營養運動應用程式，支援 Android 和 iOS 平台。

## 📁 模組化架構

### 專案結構

```
📁 NutriSport/
├── 📁 androidApp/          # Android 應用程式入口
├── 📁 iosApp/              # iOS 應用程式入口
├── 📁 shared/              # 共享基礎設施模組
├── 📁 feature/             # 功能模組集合
│   └── 📁 auth/            # 認證功能模組
├── 📁 navigation/          # 導航路由模組
├── 📁 gradle/              # Gradle 配置
│   └── libs.versions.toml  # 版本目錄
└── settings.gradle.kts     # 專案設定
```

## 🎯 模組職責劃分

### 1. **shared** 模組 - 基礎設施

**職責**: 提供所有模組共用的基礎設施和資源

**內容**:

- `Resources.kt` - 圖標和圖片資源管理
- `Color.kt` - 主題顏色定義
- `Font.kt` - 字體樣式定義
- `Alpha.kt` - 透明度常數
- 通用工具類和擴展函數

**依賴項**:

```kotlin
// 核心 Compose Multiplatform
implementation(compose.runtime)
implementation(compose.foundation)
implementation(compose.material3)
implementation(compose.ui)

// 跨平台基礎庫
implementation(libs.kotlinx.coroutines.core)
implementation(libs.kotlinx.serialization)
implementation(libs.koin.core)

// 網路和圖片
implementation(libs.ktor.client.core)
implementation(libs.coil3)

// Firebase 後端服務
implementation(libs.firebase.app)
implementation(libs.firebase.firestore)
implementation(libs.firebase.storage)
```

### 2. **feature/auth** 模組 - 認證功能

**職責**: 處理用戶認證相關的所有業務邏輯

**內容**:

- `AuthScreen.kt` - 認證主畫面
- `GoogleButton.kt` - Google 登入按鈕組件
- 認證流程管理
- 用戶狀態管理

**依賴項**:

```kotlin
// 繼承 shared 模組的基礎功能
implementation(project(":shared"))

// 認證專用依賴
implementation(libs.auth.kmp)
implementation(libs.auth.firebase.kmp)
implementation(libs.messagebar.kmp)

// DI 和狀態管理
implementation(libs.koin.compose)
```

### 3. **navigation** 模組 - 導航管理

**職責**: 管理應用程式的路由和頁面間導航

**內容**:

- 路由定義
- 導航圖配置
- 頁面跳轉邏輯
- 深層連結處理

**依賴項**:

```kotlin
// 導航框架
implementation(libs.compose.navigation)

// 功能模組集成
implementation(project(":feature:auth"))
```

### 4. **androidApp** 模組 - Android 入口

**職責**: Android 平台的應用程式入口點

**內容**:

- `MainActivity.kt` - 主活動
- `AndroidManifest.xml` - 應用程式清單
- Android 特定配置

**依賴項**:

```kotlin
// 引用共享模組
implementation(projects.shared)

// Android 特定依賴
implementation(libs.androidx.activity.compose)
implementation(libs.splash.screen)
implementation(libs.compose.ui.tooling.preview)
```

## 🔧 技術棧

### 核心框架

- **Kotlin Multiplatform 2.1.20** - 跨平台開發
- **Compose Multiplatform 1.8.0** - 跨平台 UI 框架
- **Android Gradle Plugin 8.8.0** - 構建工具

### UI 和設計

- **Material Design 3** - 現代化 UI 組件
- **Compose Navigation** - 聲明式導航
- **資源管理** - 圖標、字體、顏色統一管理

### 後端和網路

- **Firebase** - 後端即服務 (BaaS)
  - Firestore - 雲端資料庫
  - Storage - 檔案存儲
  - Authentication - 用戶認證
- **Ktor 3.0.3** - HTTP 客戶端
- **Kotlinx Serialization** - JSON 序列化

### 圖片和媒體

- **Coil3** - 跨平台圖片載入庫
- **Splash Screen** - 啟動畫面

### 架構和工具

- **Koin** - 輕量級依賴注入
- **Coroutines** - 異步程式設計
- **MessageBar KMP** - 跨平台訊息提示
- **Multiplatform Settings** - 跨平台設定存儲

## ✅ 模組化架構優勢

### 1. **關注點分離**

- 每個模組專注於特定功能
- 清晰的職責劃分
- 易於理解和維護

### 2. **編譯性能**

- **增量編譯**: 只重編譯修改的模組
- **並行編譯**: 多模組同時編譯
- **快速回饋**: 局部修改不影響其他模組

### 3. **依賴管理**

- **精準依賴**: 每個模組只引入需要的依賴
- **版本統一**: 使用 `libs.versions.toml` 統一管理
- **依賴共享**: Gradle 自動優化，相同依賴只下載一次

### 4. **團隊協作**

- **並行開發**: 不同團隊成員可同時開發不同功能模組
- **減少衝突**: 功能隔離減少 Git 合併衝突
- **獨立測試**: 各模組可獨立進行單元測試

### 5. **可擴展性**

- **新功能**: 輕鬆添加新的 feature 模組
- **平台支援**: 容易擴展到新平台 (Desktop、Web)
- **第三方集成**: 模組化設計便於集成外部服務

## 🚀 最佳實踐

### 版本管理

- 所有依賴版本統一在 `gradle/libs.versions.toml` 中管理
- 使用語義化版本控制
- 定期更新依賴項以獲得安全性和性能改進

### 模組設計原則

- **單一職責**: 每個模組只負責一個業務領域
- **低耦合**: 模組間依賴關係簡單明確
- **高內聚**: 相關功能集中在同一模組內

### 程式碼組織

- 使用清晰的包名和命名空間
- 功能相關的類別放在同一個 package 內
- 共享資源和工具類放在 shared 模組

## 📱 開發流程

### 新增功能

1. 在 `feature/` 下創建新模組
2. 在 `settings.gradle.kts` 中註冊模組
3. 配置 `build.gradle.kts` 依賴項
4. 在 `navigation` 模組中添加路由
5. 更新 shared 模組的共享資源（如需要）

### 構建和部署

```bash
# 清理專案
./gradlew clean

# 構建所有模組
./gradlew build

# 運行 Android 應用
./gradlew :androidApp:installDebug

# 構建 iOS Framework
./gradlew :shared:assembleXCFramework
```

## 🎯 結論

這個模組化架構提供了：

- **可維護性**: 清晰的模組劃分便於長期維護
- **可測試性**: 每個模組可獨立測試
- **可擴展性**: 容易添加新功能和平台支援
- **效能優化**: Gradle 依賴共享和增量編譯
- **團隊協作**: 支援多人並行開發

透過這種架構設計，NutriSport 可以快速迭代開發，同時保持程式碼品質和系統穩定性。
