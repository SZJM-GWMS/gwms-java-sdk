# ZonesApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createZone**](ZonesApi.md#createZone) | **POST** /api/v1/zones | 创建库区 |
| [**getZoneById**](ZonesApi.md#getZoneById) | **GET** /api/v1/zones/code/{code} | 获取库区详情 |
| [**listZones**](ZonesApi.md#listZones) | **GET** /api/v1/zones | 列出库区 |
| [**updateZone**](ZonesApi.md#updateZone) | **PUT** /api/v1/zones/code/{code} | 更新库区 |
| [**updateZoneStatus**](ZonesApi.md#updateZoneStatus) | **PUT** /api/v1/zones/code/{code}/status | 更新库区状态 |


<a id="createZone"></a>
# **createZone**
> ZoneResponse createZone(idempotencyKey, zoneCreateRequest)

创建库区

在指定仓库中创建一个新库区。此操作是幂等的。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - 仓库扩建时创建新库区 - 系统初始化时批量创建库区 - ERP系统推送库区配置 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ZonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ZonesApi apiInstance = new ZonesApi(defaultClient);
    UUID idempotencyKey = UUID.randomUUID(); // UUID | 一个唯一的密钥（例如，UUID），以确保资源的幂等创建。
    ZoneCreateRequest zoneCreateRequest = new ZoneCreateRequest(); // ZoneCreateRequest | 要创建的库区信息。
    try {
      ZoneResponse result = apiInstance.createZone(idempotencyKey, zoneCreateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ZonesApi#createZone");
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
| **zoneCreateRequest** | [**ZoneCreateRequest**](ZoneCreateRequest.md)| 要创建的库区信息。 | |

### Return type

[**ZoneResponse**](ZoneResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | 库区已成功创建。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **409** | 冲突。当请求与服务器的当前状态冲突时，将发送此响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="getZoneById"></a>
# **getZoneById**
> ZoneResponse getZoneById(code)

获取库区详情

通过库区编码检索特定库区的详细信息。  **所需权限：** &#x60;warehouse:read&#x60;  **使用场景：** - 验证库区编码有效性 - 获取库区容量和配置信息 - 库存分配前查询库区状态 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ZonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ZonesApi apiInstance = new ZonesApi(defaultClient);
    String code = "code_example"; // String | 库区编码。
    try {
      ZoneResponse result = apiInstance.getZoneById(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ZonesApi#getZoneById");
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
| **code** | **String**| 库区编码。 | |

### Return type

[**ZoneResponse**](ZoneResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库区详情。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="listZones"></a>
# **listZones**
> ZoneListResponse listZones(pageNumber, pageSize, sort, isAsc, warehouseId, code, name, status, zoneType)

列出库区

检索库区的分页列表，允许过滤和排序。  **所需权限：** &#x60;warehouse:read&#x60;  **使用场景：** - 查询仓库内的库区布局 - 获取可用库区列表用于库存分配 - 系统集成时同步库区信息 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ZonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ZonesApi apiInstance = new ZonesApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String sort = "createTime,code"; // String | 结果的排序字段。使用逗号分隔的字段列表。
    SortDirection isAsc = SortDirection.fromValue("ASC"); // SortDirection | 排序方向。ASC为升序，DESC为降序。
    Long warehouseId = 56L; // Long | 按所属仓库ID筛选。
    String code = "code_example"; // String | 按库区编码筛选。
    String name = "name_example"; // String | 按库区名称筛选。
    EntityStatus status = EntityStatus.fromValue("ENABLED"); // EntityStatus | 按库区状态筛选。
    String zoneType = "zoneType_example"; // String | 按库区类型筛选。
    try {
      ZoneListResponse result = apiInstance.listZones(pageNumber, pageSize, sort, isAsc, warehouseId, code, name, status, zoneType);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ZonesApi#listZones");
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
| **warehouseId** | **Long**| 按所属仓库ID筛选。 | [optional] |
| **code** | **String**| 按库区编码筛选。 | [optional] |
| **name** | **String**| 按库区名称筛选。 | [optional] |
| **status** | [**EntityStatus**](.md)| 按库区状态筛选。 | [optional] [enum: ENABLED, DISABLED] |
| **zoneType** | **String**| 按库区类型筛选。 | [optional] |

### Return type

[**ZoneListResponse**](ZoneListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库区的分页列表。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateZone"></a>
# **updateZone**
> ZoneResponse updateZone(code, zoneUpdateRequest)

更新库区

更新特定库区的信息。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - 调整库区容量配置 - 更新库区类型和属性 - 同步ERP系统的库区变更 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ZonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ZonesApi apiInstance = new ZonesApi(defaultClient);
    String code = "code_example"; // String | 库区编码。
    ZoneUpdateRequest zoneUpdateRequest = new ZoneUpdateRequest(); // ZoneUpdateRequest | 要更新的库区信息。
    try {
      ZoneResponse result = apiInstance.updateZone(code, zoneUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ZonesApi#updateZone");
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
| **code** | **String**| 库区编码。 | |
| **zoneUpdateRequest** | [**ZoneUpdateRequest**](ZoneUpdateRequest.md)| 要更新的库区信息。 | |

### Return type

[**ZoneResponse**](ZoneResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库区已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateZoneStatus"></a>
# **updateZoneStatus**
> ZoneResponse updateZoneStatus(code, status)

更新库区状态

启用或禁用特定库区。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - 库区维护时临时禁用 - 新库区投入使用时启用 - 库存策略调整时控制库区可用性 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ZonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ZonesApi apiInstance = new ZonesApi(defaultClient);
    String code = "code_example"; // String | 库区编码。
    EntityStatus status = EntityStatus.fromValue("ENABLED"); // EntityStatus | 新的库区状态。
    try {
      ZoneResponse result = apiInstance.updateZoneStatus(code, status);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ZonesApi#updateZoneStatus");
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
| **code** | **String**| 库区编码。 | |
| **status** | [**EntityStatus**](.md)| 新的库区状态。 | [enum: ENABLED, DISABLED] |

### Return type

[**ZoneResponse**](ZoneResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库区状态已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

