# InboundOrdersApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**cancelInboundOrderByCode**](InboundOrdersApi.md#cancelInboundOrderByCode) | **DELETE** /api/v1/inbound/orders/{inboundNo} | 通过入库单号取消入库单 |
| [**createInboundOrder**](InboundOrdersApi.md#createInboundOrder) | **POST** /api/v1/inbound/orders | 创建入库单 |
| [**getInboundOrderByCode**](InboundOrdersApi.md#getInboundOrderByCode) | **GET** /api/v1/inbound/orders/{inboundNo} | 通过入库单号获取入库单 |
| [**listInboundOrders**](InboundOrdersApi.md#listInboundOrders) | **GET** /api/v1/inbound/orders | 列出入库单 |
| [**updateInboundOrderByCode**](InboundOrdersApi.md#updateInboundOrderByCode) | **PUT** /api/v1/inbound/orders/{inboundNo} | 通过入库单号更新入库单 |
| [**updateInboundOrderStatus**](InboundOrdersApi.md#updateInboundOrderStatus) | **PATCH** /api/v1/inbound/orders/{inboundNo}/status | 更新入库单状态 |


<a id="cancelInboundOrderByCode"></a>
# **cancelInboundOrderByCode**
> cancelInboundOrderByCode(inboundNo)

通过入库单号取消入库单

通过入库单号取消入库单。只有未收获的入库单才能被取消。  **所需权限：** &#x60;inbound:write&#x60;  **使用场景：** - ERP系统取消已下发的入库单 - 供应商取消预约入库 - 处理异常情况下的入库单撤销 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.InboundOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    InboundOrdersApi apiInstance = new InboundOrdersApi(defaultClient);
    String inboundNo = "IB202501130001"; // String | 入库单号。
    try {
      apiInstance.cancelInboundOrderByCode(inboundNo);
    } catch (ApiException e) {
      System.err.println("Exception when calling InboundOrdersApi#cancelInboundOrderByCode");
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
| **inboundNo** | **String**| 入库单号。 | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | 入库单已成功取消。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **409** | 冲突。入库单无法取消，例如，状态不允许取消。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="createInboundOrder"></a>
# **createInboundOrder**
> InboundOrderResponse createInboundOrder(idempotencyKey, inboundOrderCreateRequest)

创建入库单

在系统中创建一个新的入库单，支持同时创建明细和箱子信息。此操作是幂等的。  **所需权限：** &#x60;inbound:write&#x60;  **使用场景：** - ERP系统推送采购入库单 - 供应商系统创建退货入库单 - 调拨系统创建转库入库单 - 第三方系统集成入库作业 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.InboundOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    InboundOrdersApi apiInstance = new InboundOrdersApi(defaultClient);
    UUID idempotencyKey = UUID.randomUUID(); // UUID | 一个唯一的密钥（例如，UUID），以确保资源的幂等创建。
    InboundOrderCreateRequest inboundOrderCreateRequest = new InboundOrderCreateRequest(); // InboundOrderCreateRequest | 要创建的入库单信息。
    try {
      InboundOrderResponse result = apiInstance.createInboundOrder(idempotencyKey, inboundOrderCreateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InboundOrdersApi#createInboundOrder");
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
| **idempotencyKey** | **UUID**| 一个唯一的密钥（例如，UUID），以确保资源的幂等创建。 | |
| **inboundOrderCreateRequest** | [**InboundOrderCreateRequest**](InboundOrderCreateRequest.md)| 要创建的入库单信息。 | |

### Return type

[**InboundOrderResponse**](InboundOrderResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | 入库单已成功创建。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **409** | 冲突。当请求与服务器的当前状态冲突时，将发送此响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="getInboundOrderByCode"></a>
# **getInboundOrderByCode**
> InboundOrderDetailResponse getInboundOrderByCode(inboundNo)

通过入库单号获取入库单

通过入库单号检索特定入库单的详细信息，包括明细和箱子信息。  **所需权限：** &#x60;inbound:read&#x60;  **使用场景：** - 查询入库单详细状态和进度 - 获取入库明细用于对账 - 追踪特定入库单的处理情况 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.InboundOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    InboundOrdersApi apiInstance = new InboundOrdersApi(defaultClient);
    String inboundNo = "IB202501130001"; // String | 入库单号。
    try {
      InboundOrderDetailResponse result = apiInstance.getInboundOrderByCode(inboundNo);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InboundOrdersApi#getInboundOrderByCode");
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
| **inboundNo** | **String**| 入库单号。 | |

### Return type

[**InboundOrderDetailResponse**](InboundOrderDetailResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 入库单详情。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="listInboundOrders"></a>
# **listInboundOrders**
> InboundOrderListResponse listInboundOrders(pageNumber, pageSize, sort, isAsc, inboundNo, inboundType, status, ownerCode, warehouseCode, startDate, endDate)

列出入库单

检索入库单的分页列表，支持多种筛选条件和排序。  **所需权限：** &#x60;inbound:read&#x60;  **使用场景：** - ERP系统查询入库单状态 - 供应商门户查看入库进度 - 仓库管理系统监控入库作业 - 财务系统核对入库记录 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.InboundOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    InboundOrdersApi apiInstance = new InboundOrdersApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String sort = "createdAt,inboundNo"; // String | 结果的排序字段。使用逗号分隔的字段列表。
    SortDirection isAsc = SortDirection.fromValue("ASC"); // SortDirection | 排序方向。ASC为升序，DESC为降序。
    String inboundNo = "inboundNo_example"; // String | 按入库单号筛选。
    InboundTypeEnum inboundType = InboundTypeEnum.fromValue("DROPSHIPPING"); // InboundTypeEnum | 按入库类型筛选。
    InboundOrderStatusEnum status = InboundOrderStatusEnum.fromValue("DRAFT"); // InboundOrderStatusEnum | 按入库单状态筛选。
    String ownerCode = "ownerCode_example"; // String | 按货主编码筛选。
    String warehouseCode = "warehouseCode_example"; // String | 按仓库编码筛选。
    LocalDate startDate = LocalDate.now(); // LocalDate | 创建时间起始日期筛选。
    LocalDate endDate = LocalDate.now(); // LocalDate | 创建时间结束日期筛选。
    try {
      InboundOrderListResponse result = apiInstance.listInboundOrders(pageNumber, pageSize, sort, isAsc, inboundNo, inboundType, status, ownerCode, warehouseCode, startDate, endDate);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InboundOrdersApi#listInboundOrders");
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
| **sort** | **String**| 结果的排序字段。使用逗号分隔的字段列表。 | [optional] |
| **isAsc** | [**SortDirection**](.md)| 排序方向。ASC为升序，DESC为降序。 | [optional] [enum: ASC, DESC] |
| **inboundNo** | **String**| 按入库单号筛选。 | [optional] |
| **inboundType** | [**InboundTypeEnum**](.md)| 按入库类型筛选。 | [optional] [enum: DROPSHIPPING, FBA_PREP, DEVAN_TRANSFER, RELABELING, RETURN_HANDLING] |
| **status** | [**InboundOrderStatusEnum**](.md)| 按入库单状态筛选。 | [optional] [enum: DRAFT, PENDING_APPROVAL, APPROVED, PARTIALLY_RECEIVED, RECEIVED, CANCELLED, PARTIALLY_PUTAWAY, PUTAWAY_COMPLETED] |
| **ownerCode** | **String**| 按货主编码筛选。 | [optional] |
| **warehouseCode** | **String**| 按仓库编码筛选。 | [optional] |
| **startDate** | **LocalDate**| 创建时间起始日期筛选。 | [optional] |
| **endDate** | **LocalDate**| 创建时间结束日期筛选。 | [optional] |

### Return type

[**InboundOrderListResponse**](InboundOrderListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 入库单的分页列表。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateInboundOrderByCode"></a>
# **updateInboundOrderByCode**
> InboundOrderResponse updateInboundOrderByCode(inboundNo, inboundOrderUpdateRequest)

通过入库单号更新入库单

通过入库单号更新入库单信息。  **所需权限：** &#x60;inbound:write&#x60;  **使用场景：** - ERP系统同步入库单变更 - 供应商更新预约入库信息 - 调整入库单明细和数量 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.InboundOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    InboundOrdersApi apiInstance = new InboundOrdersApi(defaultClient);
    String inboundNo = "IB202501130001"; // String | 入库单号。
    InboundOrderUpdateRequest inboundOrderUpdateRequest = new InboundOrderUpdateRequest(); // InboundOrderUpdateRequest | 要更新的入库单信息。
    try {
      InboundOrderResponse result = apiInstance.updateInboundOrderByCode(inboundNo, inboundOrderUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InboundOrdersApi#updateInboundOrderByCode");
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
| **inboundNo** | **String**| 入库单号。 | |
| **inboundOrderUpdateRequest** | [**InboundOrderUpdateRequest**](InboundOrderUpdateRequest.md)| 要更新的入库单信息。 | |

### Return type

[**InboundOrderResponse**](InboundOrderResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 入库单已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateInboundOrderStatus"></a>
# **updateInboundOrderStatus**
> InboundOrderResponse updateInboundOrderStatus(inboundNo, inboundOrderStatusUpdateRequest)

更新入库单状态

更新入库单的状态，如审核、开始处理。  **所需权限：** &#x60;inbound:write&#x60;  **使用场景：** - ERP系统审核入库单 - 仓库系统更新作业状态 - 供应商确认入库预约 - 系统集成时同步状态变更 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.InboundOrdersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    InboundOrdersApi apiInstance = new InboundOrdersApi(defaultClient);
    String inboundNo = "IB202501130001"; // String | 入库单号。
    InboundOrderStatusUpdateRequest inboundOrderStatusUpdateRequest = new InboundOrderStatusUpdateRequest(); // InboundOrderStatusUpdateRequest | 状态更新请求。
    try {
      InboundOrderResponse result = apiInstance.updateInboundOrderStatus(inboundNo, inboundOrderStatusUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InboundOrdersApi#updateInboundOrderStatus");
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
| **inboundNo** | **String**| 入库单号。 | |
| **inboundOrderStatusUpdateRequest** | [**InboundOrderStatusUpdateRequest**](InboundOrderStatusUpdateRequest.md)| 状态更新请求。 | |

### Return type

[**InboundOrderResponse**](InboundOrderResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 入库单状态已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **409** | 冲突。状态转换不被允许。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

