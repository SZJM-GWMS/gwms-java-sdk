# OutboundOrderApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cancel**](OutboundOrderApi.md#cancel) | **POST** /api/v1/outboundOrder/{wmsOrderNo}/cancel | 取消出库单 |
| [**createNewOrder**](OutboundOrderApi.md#createNewOrder) | **POST** /api/v1/outboundOrder | 创建出库单 |
| [**pageQueryOutboundOrder**](OutboundOrderApi.md#pageQueryOutboundOrder) | **GET** /api/v1/outboundOrders | 分页查询出库单 |


<a id="cancel"></a>
# **cancel**
> ApiResponseBase cancel(wmsOrderNo)

取消出库单

取消出库单。  **所需权限：** &#x60;outbound:write&#x60;  **使用场景：** - 订单取消后撤销出库指令 - 处理异常情况下的出库单撤销 - 客户修改订单后重新安排出库 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.OutboundOrderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    OutboundOrderApi apiInstance = new OutboundOrderApi(defaultClient);
    String wmsOrderNo = "wmsOrderNo_example"; // String | 
    try {
      ApiResponseBase result = apiInstance.cancel(wmsOrderNo);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OutboundOrderApi#cancel");
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
| **wmsOrderNo** | **String**|  | |

### Return type

[**ApiResponseBase**](ApiResponseBase.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 出库单已成功取消 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **403** | 禁止访问。客户端没有访问内容的权限。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **409** | 冲突。当请求与服务器的当前状态冲突时，将发送此响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="createNewOrder"></a>
# **createNewOrder**
> ApiResponseBase createNewOrder(outboundOrder)

创建出库单

创建出库单。  **所需权限：** &#x60;outbound:write&#x60;  **使用场景：** - 电商平台创建发货订单 - ERP系统推送出库指令 - 订单系统同步出库需求 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.OutboundOrderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    OutboundOrderApi apiInstance = new OutboundOrderApi(defaultClient);
    OutboundOrder outboundOrder = new OutboundOrder(); // OutboundOrder | 
    try {
      ApiResponseBase result = apiInstance.createNewOrder(outboundOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OutboundOrderApi#createNewOrder");
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
| **outboundOrder** | [**OutboundOrder**](OutboundOrder.md)|  | |

### Return type

[**ApiResponseBase**](ApiResponseBase.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 出库单已成功创建 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **403** | 禁止访问。客户端没有访问内容的权限。 |  -  |
| **409** | 业务冲突 - 订单状态不允许创建或库存不足 |  -  |
| **422** | 业务逻辑验证失败 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="pageQueryOutboundOrder"></a>
# **pageQueryOutboundOrder**
> OutboundOrderListResponse pageQueryOutboundOrder(pageNumber, pageSize, wmsOrderNo, platformOrderNo, orderState, trackingNo, orderType)

分页查询出库单

分页查询出库单列表，支持多种筛选条件。  **所需权限：** &#x60;outbound:read&#x60;  **使用场景：** - 批量查询出库单状态 - 按条件筛选出库单 - 监控出库作业进度 - 生成出库报表 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.OutboundOrderApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    OutboundOrderApi apiInstance = new OutboundOrderApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String wmsOrderNo = "wmsOrderNo_example"; // String | WMS单号
    String platformOrderNo = "platformOrderNo_example"; // String | 平台单号
    String orderState = "orderState_example"; // String | 订单状态
    String trackingNo = "trackingNo_example"; // String | 跟踪号
    String orderType = "orderType_example"; // String | 单据类型(DROP_SHIPPING：一件代发, FBA：备货中转)
    try {
      OutboundOrderListResponse result = apiInstance.pageQueryOutboundOrder(pageNumber, pageSize, wmsOrderNo, platformOrderNo, orderState, trackingNo, orderType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling OutboundOrderApi#pageQueryOutboundOrder");
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
| **pageNumber** | **Integer**| 页码（从1开始） | [optional] [default to 1] |
| **pageSize** | **Integer**| 每页记录数 | [optional] [default to 20] |
| **wmsOrderNo** | **String**| WMS单号 | [optional] |
| **platformOrderNo** | **String**| 平台单号 | [optional] |
| **orderState** | **String**| 订单状态 | [optional] |
| **trackingNo** | **String**| 跟踪号 | [optional] |
| **orderType** | **String**| 单据类型(DROP_SHIPPING：一件代发, FBA：备货中转) | [optional] |

### Return type

[**OutboundOrderListResponse**](OutboundOrderListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取出库单列表 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **403** | 禁止访问。客户端没有访问内容的权限。 |  -  |
| **422** | 业务逻辑验证失败 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

