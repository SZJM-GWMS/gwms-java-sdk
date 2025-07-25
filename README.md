# GWMS Java SDK

[![](https://jitpack.io/v/SZJM-GWMS/gwms-java-sdk.svg)](https://jitpack.io/#SZJM-GWMS/gwms-java-sdk)
[![Java 8+](https://img.shields.io/badge/Java-8%2B-blue.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)

自动生成的 GWMS (仓库管理系统) Java SDK，提供完整的 API 客户端功能。

## 版本信息

- **当前版本**: `1.0.3`
- **生成时间**: `2025-07-25 14:03:50`
- **Java 兼容性**: Java 8+
- **支持的构建工具**: Maven 3.6+, Gradle 6.0+

## 系统要求

- **Java**: 8 或更高版本 (推荐 Java 11 或 17)
- **构建工具**: Maven 3.6+ 或 Gradle 6.0+
- **网络**: 需要访问互联网以下载依赖

## 安装方式

### Maven 安装

在您的 `pom.xml` 文件中添加以下配置：

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.SZJM-GWMS</groupId>
        <artifactId>gwms-java-sdk</artifactId>
        <version>1.0.3</version>
    </dependency>
</dependencies>
```

### Gradle 安装

在您的 `build.gradle` 文件中添加以下配置：

```gradle
repositories {
    maven { url 'https://jitpack.io' }
    mavenCentral()
}

dependencies {
    implementation 'com.github.SZJM-GWMS:gwms-java-sdk:1.0.3'
}
```

### Gradle (Kotlin DSL) 安装

在您的 `build.gradle.kts` 文件中添加：

```kotlin
repositories {
    maven("https://jitpack.io")
    mavenCentral()
}

dependencies {
    implementation("com.github.SZJM-GWMS:gwms-java-sdk:1.0.3")
}
```

## 快速开始

### 1. 基础配置和认证

```java
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.api.AuthApi;
import com.jmalltech.gwms.sdk.model.TokenRequest;
import com.jmalltech.gwms.sdk.model.TokenResponse;
import com.jmalltech.gwms.sdk.invoker.ApiException;

public class WmsApiExample {
    public static void main(String[] args) {
        // 创建 API 客户端实例（默认使用生产环境）
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // 可选：设置其他环境
        // defaultClient.setBasePath("https://api.sandbox.gwms.jmalltech.com"); // 沙箱环境
        // defaultClient.setBasePath("http://localhost:8080"); // 本地开发环境
        
        // 设置连接超时时间
        defaultClient.setConnectTimeout(30000); // 30 秒
        defaultClient.setReadTimeout(60000);    // 60 秒
        
        // 获取访问令牌
        AuthApi authApi = new AuthApi(defaultClient);
        TokenRequest tokenRequest = new TokenRequest()
            .clientId("YOUR_CLIENT_ID")
            .clientSecret("YOUR_CLIENT_SECRET")
            .apiKey("YOUR_API_KEY");

        try {
            TokenResponse tokenResponse = authApi.getAccessToken(tokenRequest);
            String accessToken = tokenResponse.getAccessToken();
            
            // 设置访问令牌用于后续 API 调用
            defaultClient.setBearerToken(accessToken);
            
            System.out.println("认证成功! 访问令牌已设置");
        } catch (ApiException e) {
            System.err.println("认证失败: " + e.getMessage());
            System.err.println("HTTP 状态码: " + e.getCode());
            return;
        }
    }
}
```

### 2. 仓库管理操作

```java
import com.jmalltech.gwms.sdk.api.WarehousesApi;
import com.jmalltech.gwms.sdk.model.WarehouseListResponse;
import com.jmalltech.gwms.sdk.model.CreateWarehouseRequest;
import com.jmalltech.gwms.sdk.model.WarehouseResponse;

// 查询仓库列表
WarehousesApi warehousesApi = new WarehousesApi(defaultClient);

try {
    WarehouseListResponse response = warehousesApi.listWarehouses(
        1,      // 页码
        10,     // 每页数量
        null,   // 仓库名称过滤
        null,   // 仓库代码过滤
        null,   // 状态过滤
        null,   // 类型过滤
        null,   // 排序字段
        null    // 排序方向
    );
    
    System.out.println("找到 " + response.getTotal() + " 个仓库");
    response.getData().forEach(warehouse -> {
        System.out.println("仓库: " + warehouse.getName() + 
                         " (代码: " + warehouse.getCode() + 
                         ", 状态: " + warehouse.getStatus() + ")");
    });
} catch (ApiException e) {
    System.err.println("查询仓库列表失败: " + e.getMessage());
}

// 创建新仓库
CreateWarehouseRequest createRequest = new CreateWarehouseRequest()
    .name("新仓库")
    .code("WH-001")
    .description("这是一个测试仓库")
    .address("北京市朝阳区")
    .contactPerson("张三")
    .contactPhone("13800138000");

try {
    WarehouseResponse newWarehouse = warehousesApi.createWarehouse(createRequest);
    System.out.println("仓库创建成功，ID: " + newWarehouse.getId());
} catch (ApiException e) {
    System.err.println("创建仓库失败: " + e.getMessage());
}
```

### 3. 产品管理操作

```java
import com.jmalltech.gwms.sdk.api.ProductsApi;
import com.jmalltech.gwms.sdk.model.CreateProductRequest;
import com.jmalltech.gwms.sdk.model.ProductResponse;
import com.jmalltech.gwms.sdk.model.ProductListResponse;

ProductsApi productsApi = new ProductsApi(defaultClient);

// 创建产品
CreateProductRequest productRequest = new CreateProductRequest()
    .name("测试产品")
    .code("PROD-001")
    .description("这是一个测试产品")
    .category("电子产品")
    .unit("个")
    .weight(1.5)
    .length(10.0)
    .width(8.0)
    .height(5.0);

try {
    ProductResponse product = productsApi.createProduct(productRequest);
    System.out.println("产品创建成功，ID: " + product.getId());
    System.out.println("产品名称: " + product.getName());
    System.out.println("产品代码: " + product.getCode());
} catch (ApiException e) {
    System.err.println("创建产品失败: " + e.getMessage());
}

// 查询产品列表
try {
    ProductListResponse products = productsApi.listProducts(
        1,      // 页码
        20,     // 每页数量
        null,   // 名称过滤
        null,   // 代码过滤
        null,   // 分类过滤
        "name", // 排序字段
        "asc"   // 排序方向
    );
    
    System.out.println("找到 " + products.getTotal() + " 个产品");
    products.getData().forEach(p -> {
        System.out.println("产品: " + p.getName() + " (" + p.getCode() + ")");
    });
} catch (ApiException e) {
    System.err.println("查询产品列表失败: " + e.getMessage());
}
```

### 4. 库存管理操作

```java
import com.jmalltech.gwms.sdk.api.InventoryApi;
import com.jmalltech.gwms.sdk.model.InventoryListResponse;
import com.jmalltech.gwms.sdk.model.InventoryAdjustmentRequest;

InventoryApi inventoryApi = new InventoryApi(defaultClient);

// 查询库存
try {
    InventoryListResponse inventory = inventoryApi.listInventory(
        1,      // 页码
        50,     // 每页数量
        null,   // 仓库ID过滤
        null,   // 产品ID过滤
        null,   // 批次号过滤
        null    // 库位过滤
    );
    
    System.out.println("找到 " + inventory.getTotal() + " 条库存记录");
    inventory.getData().forEach(item -> {
        System.out.println("产品: " + item.getProductName() + 
                         ", 数量: " + item.getQuantity() + 
                         ", 可用数量: " + item.getAvailableQuantity());
    });
} catch (ApiException e) {
    System.err.println("查询库存失败: " + e.getMessage());
}
```

## 高级配置

### 自定义 HTTP 客户端配置

```java
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;

// 创建自定义的 OkHttpClient
OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(60, TimeUnit.SECONDS)
    .retryOnConnectionFailure(true);

// 应用到 API 客户端
ApiClient customClient = new ApiClient();
customClient.setHttpClient(httpClientBuilder.build());
// customClient.setBasePath("https://api.sandbox.gwms.jmalltech.com"); // 如需使用其他环境
```

### 启用调试模式

```java
// 启用详细的调试日志
ApiClient debugClient = Configuration.getDefaultApiClient();
debugClient.setDebugging(true);

// 设置自定义的日志级别
import java.util.logging.Logger;
import java.util.logging.Level;

Logger.getLogger("com.jmalltech.gwms.sdk").setLevel(Level.FINE);
```

### 设置代理服务器

```java
import java.net.Proxy;
import java.net.InetSocketAddress;

// HTTP 代理配置
Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.company.com", 8080));

OkHttpClient.Builder builder = new OkHttpClient.Builder()
    .proxy(proxy);

ApiClient proxyClient = new ApiClient();
proxyClient.setHttpClient(builder.build());
```

## 错误处理

SDK 使用 `ApiException` 来处理所有 API 相关的错误：

```java
try {
    // API 调用
    ProductResponse product = productsApi.getProduct(productId);
} catch (ApiException e) {
    // 获取 HTTP 状态码
    int statusCode = e.getCode();
    
    // 获取错误消息
    String errorMessage = e.getMessage();
    
    // 获取响应体（如果有）
    String responseBody = e.getResponseBody();
    
    // 根据状态码进行不同的处理
    switch (statusCode) {
        case 400:
            System.err.println("请求参数错误: " + errorMessage);
            break;
        case 401:
            System.err.println("认证失败，请检查访问令牌");
            break;
        case 403:
            System.err.println("权限不足: " + errorMessage);
            break;
        case 404:
            System.err.println("资源不存在: " + errorMessage);
            break;
        case 429:
            System.err.println("请求频率过高，请稍后重试");
            break;
        case 500:
            System.err.println("服务器内部错误: " + errorMessage);
            break;
        default:
            System.err.println("未知错误 (" + statusCode + "): " + errorMessage);
    }
    
    // 打印详细的响应体（用于调试）
    if (responseBody != null && !responseBody.isEmpty()) {
        System.err.println("响应体: " + responseBody);
    }
}
```

## 最佳实践

### 1. 连接池管理

```java
// 为高并发场景配置连接池
OkHttpClient.Builder builder = new OkHttpClient.Builder()
    .connectionPool(new ConnectionPool(10, 5, TimeUnit.MINUTES))
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS);
```

### 2. 重试机制

```java
public class RetryableApiCall {
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 1000;
    
    public static <T> T executeWithRetry(Supplier<T> apiCall) throws ApiException {
        ApiException lastException = null;
        
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                return apiCall.get();
            } catch (ApiException e) {
                lastException = e;
                
                // 只对特定的错误码进行重试
                if (e.getCode() == 429 || e.getCode() >= 500) {
                    try {
                        Thread.sleep(RETRY_DELAY_MS * (i + 1));
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw e;
                    }
                } else {
                    throw e;
                }
            }
        }
        
        throw lastException;
    }
}
```

### 3. 异步调用

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncApiExample {
    private final ExecutorService executor = Executors.newFixedThreadPool(10);
    private final ProductsApi productsApi;
    
    public CompletableFuture<ProductListResponse> getProductsAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return productsApi.listProducts(1, 20, null, null, null, null, null);
            } catch (ApiException e) {
                throw new RuntimeException(e);
            }
        }, executor);
    }
}
```

## 常见问题

### Q: 如何处理大量数据的分页查询？

A: 使用循环和分页参数：

```java
public List<Product> getAllProducts() throws ApiException {
    List<Product> allProducts = new ArrayList<>();
    int page = 1;
    int pageSize = 100;
    
    while (true) {
        ProductListResponse response = productsApi.listProducts(
            page, pageSize, null, null, null, null, null);
        
        allProducts.addAll(response.getData());
        
        if (response.getData().size() < pageSize) {
            break; // 已经是最后一页
        }
        
        page++;
    }
    
    return allProducts;
}
```

### Q: 如何处理文件上传？

A: 使用 MultipartBody 进行文件上传：

```java
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import java.io.File;

File file = new File("path/to/your/file.xlsx");
RequestBody fileBody = RequestBody.create(MediaType.parse("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"), file);
MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), fileBody);

// 调用上传 API
// uploadApi.uploadFile(filePart);
```

### Q: 如何设置自定义请求头？

A: 通过 ApiClient 设置默认请求头：

```java
ApiClient client = Configuration.getDefaultApiClient();
client.addDefaultHeader("X-Custom-Header", "custom-value");
client.addDefaultHeader("X-Request-ID", UUID.randomUUID().toString());
```

## 支持和文档

- **API 文档**: [OpenAPI 规范文档](https://raw.githubusercontent.com/SZJM-GWMS/gwms-java-sdk/refs/heads/master/api/openapi.yaml)
- **问题反馈**: [GitHub Issues](https://github.com/SZJM-GWMS/gwms-java-sdk/issues)
- **源代码**: [GitHub 仓库](https://github.com/SZJM-GWMS/gwms-java-sdk)
- **更新日志**: [Releases](https://github.com/SZJM-GWMS/gwms-java-sdk/releases)

## 许可证

本 SDK 遵循 Apache License 2.0 许可证。详情请参见 [LICENSE](LICENSE) 文件。

## 贡献

欢迎提交 Issue 和 Pull Request 来改进这个 SDK。

---

**注意**: 这是一个自动生成的 SDK，请不要直接修改生成的代码。如需自定义，请修改 OpenAPI 规范文件或生成器配置。