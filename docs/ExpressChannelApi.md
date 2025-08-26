# ExpressChannelApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**callList**](ExpressChannelApi.md#callList) | **GET** /api/v1/expressChannel | 获取所有物流渠道 |


<a id="callList"></a>
# **callList**
> ApiListResponseBase callList()

获取所有物流渠道

获取所有可用的物流渠道信息。  **所需权限：** &#x60;express:read&#x60;  **使用场景：** - 获取可用物流渠道列表 - 查询物流渠道配置信息 - 电商平台同步物流渠道数据 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ExpressChannelApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ExpressChannelApi apiInstance = new ExpressChannelApi(defaultClient);
    try {
      ApiListResponseBase result = apiInstance.callList();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ExpressChannelApi#callList");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ApiListResponseBase**](ApiListResponseBase.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取物流渠道列表 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **403** | 禁止访问。客户端没有访问内容的权限。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

