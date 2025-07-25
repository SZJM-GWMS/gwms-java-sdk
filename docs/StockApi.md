# StockApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getPageStocks**](StockApi.md#getPageStocks) | **POST** /api/v1/stock/page/queries | 分页查询产品库存 |
| [**getStocks**](StockApi.md#getStocks) | **POST** /api/v1/stock/queries | 查询产品库存 |


<a id="getPageStocks"></a>
# **getPageStocks**
> StockPageListResponse getPageStocks(stockQueryRequest, pageNumber, pageSize)

分页查询产品库存

根据仓库和产品SKU列表分页查询详细库存信息。  **所需权限：** &#x60;stock:read&#x60;  **使用场景：** - ERP系统同步库存数据 - 电商平台查询可售库存 - 订单履约前检查库存可用性 - 库存报表和分析 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.StockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    StockApi apiInstance = new StockApi(defaultClient);
    StockQueryRequest stockQueryRequest = new StockQueryRequest(); // StockQueryRequest | 
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    try {
      StockPageListResponse result = apiInstance.getPageStocks(stockQueryRequest, pageNumber, pageSize);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StockApi#getPageStocks");
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
| **stockQueryRequest** | [**StockQueryRequest**](StockQueryRequest.md)|  | |
| **pageNumber** | **Integer**| 页码（从1开始） | [optional] [default to 1] |
| **pageSize** | **Integer**| 每页记录数 | [optional] [default to 20] |

### Return type

[**StockPageListResponse**](StockPageListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取库存信息 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="getStocks"></a>
# **getStocks**
> StockQueryResponse getStocks(stockQueryRequest)

查询产品库存

根据仓库和产品SKU列表查询详细库存信息。  **所需权限：** &#x60;stock:read&#x60;  **使用场景：** - ERP系统同步库存数据 - 电商平台查询可售库存 - 订单履约前检查库存可用性 - 库存报表和分析 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.StockApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    StockApi apiInstance = new StockApi(defaultClient);
    StockQueryRequest stockQueryRequest = new StockQueryRequest(); // StockQueryRequest | 
    try {
      StockQueryResponse result = apiInstance.getStocks(stockQueryRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling StockApi#getStocks");
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
| **stockQueryRequest** | [**StockQueryRequest**](StockQueryRequest.md)|  | |

### Return type

[**StockQueryResponse**](StockQueryResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取库存信息 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **403** | 禁止访问。客户端没有访问内容的权限。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

