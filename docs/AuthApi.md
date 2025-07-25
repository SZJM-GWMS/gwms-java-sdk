# AuthApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAccessToken**](AuthApi.md#getAccessToken) | **POST** /auth-api/token | 获取访问令牌 |


<a id="getAccessToken"></a>
# **getAccessToken**
> TokenResponse getAccessToken(tokenRequest)

获取访问令牌

使用客户端凭证（clientId + clientSecret）和API密钥获取JWT访问令牌。  ## 认证流程详解  ### 1. 准备阶段 - **系统管理员**：为上游系统生成clientId和clientSecret - **仓库用户**：生成apiKey，关联到特定仓库和权限范围 - **上游系统**：获取并安全存储这三个凭证  ### 2. 令牌获取 &#x60;&#x60;&#x60;bash curl -X POST https://gwms.jmalltech.com/api-gateway/auth-api/token \\   -H \&quot;Content-Type: application/json\&quot; \\   -d &#39;{     \&quot;clientId\&quot;: \&quot;EOUSSQNWMRVX15GA\&quot;,     \&quot;clientSecret\&quot;: \&quot;tiy3dbyW8l5W06sFQwsjOIU8-xTLbRJJVtxreGlka8Y&#x3D;\&quot;,     \&quot;apiKey\&quot;: \&quot;8MO5994KEQMEZMAN\&quot;   }&#39; &#x60;&#x60;&#x60;  ### 3. API访问 &#x60;&#x60;&#x60;bash curl -H \&quot;Authorization: Bearer {access_token}\&quot; \\   https://gwms.jmalltech.com/api/v1/products &#x60;&#x60;&#x60;  ## 安全最佳实践  - **clientSecret安全**：只在生成时显示一次，请妥善保存在安全的配置管理系统中 - **令牌管理**：访问令牌有效期为1小时，建议在过期前5分钟重新获取 - **权限最小化**：apiKey应只包含业务所需的最小权限范围 - **网络安全**：生产环境必须使用HTTPS传输 - **日志安全**：不要在日志中记录完整的凭证信息  ## 错误处理  - **400 Bad Request**：请求参数缺失或格式错误 - **401 Unauthorized**：凭证无效、过期或被禁用 - **429 Too Many Requests**：请求频率超出限制 - **500 Internal Server Error**：服务器内部错误  ## 权限范围说明  令牌的权限范围由apiKey关联的仓库用户权限决定：  | 权限范围 | 说明 | 示例操作 | |---------|------|---------| | &#x60;product:read&#x60; | 产品数据读取 | 查询产品列表、获取产品详情 | | &#x60;product:write&#x60; | 产品数据写入 | 创建、更新、删除产品 | | &#x60;warehouse:read&#x60; | 仓库数据读取 | 查询仓库、库区、库位信息 | | &#x60;warehouse:write&#x60; | 仓库数据写入 | 创建、更新仓库配置 | | &#x60;stock:read&#x60; | 库存数据读取 | 查询库存数量、库存明细 | | &#x60;stock:write&#x60; | 库存数据写入 | 库存调整、库存转移 | | &#x60;inbound:read&#x60; | 入库单读取 | 查询入库单列表、获取入库单详情 | | &#x60;inbound:write&#x60; | 入库单写入 | 创建、更新、取消入库单 | | &#x60;outbound:read&#x60; | 出库单读取 | 查询出库单列表、获取出库单详情 | | &#x60;outbound:write&#x60; | 出库单写入 | 创建、更新、取消出库单 | 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.AuthApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");

    AuthApi apiInstance = new AuthApi(defaultClient);
    TokenRequest tokenRequest = new TokenRequest(); // TokenRequest | 
    try {
      TokenResponse result = apiInstance.getAccessToken(tokenRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AuthApi#getAccessToken");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **tokenRequest** | [**TokenRequest**](TokenRequest.md)|  | |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 认证成功，返回访问令牌 |  -  |
| **400** | 请求参数错误 |  -  |
| **401** | 认证失败 |  -  |
| **429** | 请求频率超限 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

