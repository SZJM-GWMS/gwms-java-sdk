# LocationsApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createLocation**](LocationsApi.md#createLocation) | **POST** /api/v1/locations | 创建库位 |
| [**getLocationByCode**](LocationsApi.md#getLocationByCode) | **GET** /api/v1/locations/code/{code} | 获取库位详情 |
| [**listLocations**](LocationsApi.md#listLocations) | **GET** /api/v1/locations | 列出库位 |
| [**updateLocation**](LocationsApi.md#updateLocation) | **PUT** /api/v1/locations/code/{code} | 更新库位 |
| [**updateLocationStatus**](LocationsApi.md#updateLocationStatus) | **PUT** /api/v1/locations/code/{code}/status | 更新库位状态 |


<a id="createLocation"></a>
# **createLocation**
> LocationResponse createLocation(idempotencyKey, locationCreateRequest)

创建库位

在指定库区中创建一个新库位。此操作是幂等的。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - 仓库扩建时批量创建库位 - 系统初始化时导入库位数据 - 货架调整后创建新库位 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.LocationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    LocationsApi apiInstance = new LocationsApi(defaultClient);
    UUID idempotencyKey = UUID.randomUUID(); // UUID | 一个唯一的密钥（例如，UUID），以确保资源的幂等创建。
    LocationCreateRequest locationCreateRequest = new LocationCreateRequest(); // LocationCreateRequest | 要创建的库位信息。
    try {
      LocationResponse result = apiInstance.createLocation(idempotencyKey, locationCreateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LocationsApi#createLocation");
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
| **locationCreateRequest** | [**LocationCreateRequest**](LocationCreateRequest.md)| 要创建的库位信息。 | |

### Return type

[**LocationResponse**](LocationResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | 库位已成功创建。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **409** | 冲突。当请求与服务器的当前状态冲突时，将发送此响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="getLocationByCode"></a>
# **getLocationByCode**
> LocationResponse getLocationByCode(code)

获取库位详情

通过库位编码检索特定库位的详细信息。  **所需权限：** &#x60;warehouse:read&#x60;  **使用场景：** - 验证库位编码有效性 - 获取库位容量和规格信息 - 库存操作前查询库位状态 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.LocationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    LocationsApi apiInstance = new LocationsApi(defaultClient);
    String code = "code_example"; // String | 库位编码。
    try {
      LocationResponse result = apiInstance.getLocationByCode(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LocationsApi#getLocationByCode");
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
| **code** | **String**| 库位编码。 | |

### Return type

[**LocationResponse**](LocationResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库位详情。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="listLocations"></a>
# **listLocations**
> LocationListResponse listLocations(pageNumber, pageSize, sort, isAsc, warehouseId, zoneId, code, status)

列出库位

检索库位的分页列表，允许过滤和排序。  **所需权限：** &#x60;warehouse:read&#x60;  **使用场景：** - 查询可用库位进行库存分配 - 获取库位列表用于拣货路径规划 - 系统集成时同步库位信息 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.LocationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    LocationsApi apiInstance = new LocationsApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String sort = "createTime,code"; // String | 结果的排序字段。使用逗号分隔的字段列表。
    SortDirection isAsc = SortDirection.fromValue("ASC"); // SortDirection | 排序方向。ASC为升序，DESC为降序。
    Long warehouseId = 56L; // Long | 按所属仓库ID筛选。
    Long zoneId = 56L; // Long | 按所属库区ID筛选。
    String code = "code_example"; // String | 按库位编码筛选。
    EntityStatus status = EntityStatus.fromValue("ENABLED"); // EntityStatus | 按库位状态筛选。
    try {
      LocationListResponse result = apiInstance.listLocations(pageNumber, pageSize, sort, isAsc, warehouseId, zoneId, code, status);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LocationsApi#listLocations");
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
| **zoneId** | **Long**| 按所属库区ID筛选。 | [optional] |
| **code** | **String**| 按库位编码筛选。 | [optional] |
| **status** | [**EntityStatus**](.md)| 按库位状态筛选。 | [optional] [enum: ENABLED, DISABLED] |

### Return type

[**LocationListResponse**](LocationListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库位的分页列表。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateLocation"></a>
# **updateLocation**
> LocationResponse updateLocation(code, locationUpdateRequest)

更新库位

更新特定库位的信息。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - 调整库位容量和规格 - 更新库位类型和属性 - 同步货架调整后的库位变更 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.LocationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    LocationsApi apiInstance = new LocationsApi(defaultClient);
    String code = "code_example"; // String | 库位编码。
    LocationUpdateRequest locationUpdateRequest = new LocationUpdateRequest(); // LocationUpdateRequest | 要更新的库位信息。
    try {
      LocationResponse result = apiInstance.updateLocation(code, locationUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LocationsApi#updateLocation");
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
| **code** | **String**| 库位编码。 | |
| **locationUpdateRequest** | [**LocationUpdateRequest**](LocationUpdateRequest.md)| 要更新的库位信息。 | |

### Return type

[**LocationResponse**](LocationResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库位已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateLocationStatus"></a>
# **updateLocationStatus**
> LocationResponse updateLocationStatus(code, status)

更新库位状态

启用或禁用特定库位。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - 库位维护时临时禁用 - 新库位投入使用时启用 - 库存策略调整时控制库位可用性 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.LocationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    LocationsApi apiInstance = new LocationsApi(defaultClient);
    String code = "code_example"; // String | 库位编码。
    EntityStatus status = EntityStatus.fromValue("ENABLED"); // EntityStatus | 新的库位状态。
    try {
      LocationResponse result = apiInstance.updateLocationStatus(code, status);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LocationsApi#updateLocationStatus");
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
| **code** | **String**| 库位编码。 | |
| **status** | [**EntityStatus**](.md)| 新的库位状态。 | [enum: ENABLED, DISABLED] |

### Return type

[**LocationResponse**](LocationResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 库位状态已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

