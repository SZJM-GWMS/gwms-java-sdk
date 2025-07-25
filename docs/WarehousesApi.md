# WarehousesApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createWarehouse**](WarehousesApi.md#createWarehouse) | **POST** /api/v1/warehouses | 创建仓库 |
| [**getWarehouseByCode**](WarehousesApi.md#getWarehouseByCode) | **GET** /api/v1/warehouses/code/{code} | 获取仓库详情 |
| [**listWarehouses**](WarehousesApi.md#listWarehouses) | **GET** /api/v1/warehouses | 列出仓库 |
| [**updateWarehouse**](WarehousesApi.md#updateWarehouse) | **PUT** /api/v1/warehouses/code/{code} | 更新仓库 |
| [**updateWarehouseStatus**](WarehousesApi.md#updateWarehouseStatus) | **PUT** /api/v1/warehouses/code/{code}/status | 更新仓库状态 |


<a id="createWarehouse"></a>
# **createWarehouse**
> WarehouseResponse createWarehouse(idempotencyKey, warehouseCreateRequest)

创建仓库

在系统中创建一个新仓库。此操作是幂等的，支持上游系统推送仓库数据。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - ERP系统推送新建仓库信息 - 系统集成时批量创建仓库主数据 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.WarehousesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    WarehousesApi apiInstance = new WarehousesApi(defaultClient);
    UUID idempotencyKey = UUID.randomUUID(); // UUID | 一个唯一的密钥（例如，UUID），以确保资源的幂等创建。
    WarehouseCreateRequest warehouseCreateRequest = new WarehouseCreateRequest(); // WarehouseCreateRequest | 要创建的仓库信息。
    try {
      WarehouseResponse result = apiInstance.createWarehouse(idempotencyKey, warehouseCreateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WarehousesApi#createWarehouse");
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
| **warehouseCreateRequest** | [**WarehouseCreateRequest**](WarehouseCreateRequest.md)| 要创建的仓库信息。 | |

### Return type

[**WarehouseResponse**](WarehouseResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | 仓库已成功创建。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **409** | 冲突。当请求与服务器的当前状态冲突时，将发送此响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="getWarehouseByCode"></a>
# **getWarehouseByCode**
> WarehouseResponse getWarehouseByCode(code)

获取仓库详情

通过仓库编码检索特定仓库的详细信息。  **所需权限：** &#x60;warehouse:read&#x60;  **使用场景：** - 验证仓库编码有效性 - 获取仓库详细配置信息 - 查询仓库地址和联系方式 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.WarehousesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    WarehousesApi apiInstance = new WarehousesApi(defaultClient);
    String code = "code_example"; // String | 仓库编码。
    try {
      WarehouseResponse result = apiInstance.getWarehouseByCode(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WarehousesApi#getWarehouseByCode");
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
| **code** | **String**| 仓库编码。 | |

### Return type

[**WarehouseResponse**](WarehouseResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 仓库详情。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="listWarehouses"></a>
# **listWarehouses**
> WarehouseListResponse listWarehouses(pageNumber, pageSize, sort, isAsc, code, name, status, city, province)

列出仓库

检索仓库的分页列表，允许过滤和排序。  **所需权限：** &#x60;warehouse:read&#x60;  **使用场景：** - ERP系统同步仓库主数据 - 电商平台获取可用仓库列表 - TMS系统查询配送仓库信息 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.WarehousesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    WarehousesApi apiInstance = new WarehousesApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String sort = "createTime,code"; // String | 结果的排序字段。使用逗号分隔的字段列表。
    SortDirection isAsc = SortDirection.fromValue("ASC"); // SortDirection | 排序方向。ASC为升序，DESC为降序。
    String code = "code_example"; // String | 按仓库编码筛选。
    String name = "name_example"; // String | 按仓库名称筛选。
    EntityStatus status = EntityStatus.fromValue("ENABLED"); // EntityStatus | 按仓库状态筛选。
    String city = "city_example"; // String | 按城市筛选。
    String province = "province_example"; // String | 按省/州筛选。
    try {
      WarehouseListResponse result = apiInstance.listWarehouses(pageNumber, pageSize, sort, isAsc, code, name, status, city, province);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WarehousesApi#listWarehouses");
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
| **code** | **String**| 按仓库编码筛选。 | [optional] |
| **name** | **String**| 按仓库名称筛选。 | [optional] |
| **status** | [**EntityStatus**](.md)| 按仓库状态筛选。 | [optional] [enum: ENABLED, DISABLED] |
| **city** | **String**| 按城市筛选。 | [optional] |
| **province** | **String**| 按省/州筛选。 | [optional] |

### Return type

[**WarehouseListResponse**](WarehouseListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 仓库的分页列表。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateWarehouse"></a>
# **updateWarehouse**
> WarehouseResponse updateWarehouse(code, warehouseUpdateRequest)

更新仓库

更新特定仓库的信息。支持上游系统推送更新后的仓库数据。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - ERP系统同步仓库信息变更 - 更新仓库地址、联系方式等基础信息 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.WarehousesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    WarehousesApi apiInstance = new WarehousesApi(defaultClient);
    String code = "code_example"; // String | 仓库编码。
    WarehouseUpdateRequest warehouseUpdateRequest = new WarehouseUpdateRequest(); // WarehouseUpdateRequest | 要更新的仓库信息。
    try {
      WarehouseResponse result = apiInstance.updateWarehouse(code, warehouseUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WarehousesApi#updateWarehouse");
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
| **code** | **String**| 仓库编码。 | |
| **warehouseUpdateRequest** | [**WarehouseUpdateRequest**](WarehouseUpdateRequest.md)| 要更新的仓库信息。 | |

### Return type

[**WarehouseResponse**](WarehouseResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 仓库已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateWarehouseStatus"></a>
# **updateWarehouseStatus**
> WarehouseResponse updateWarehouseStatus(code, status)

更新仓库状态

启用或禁用特定仓库。  **所需权限：** &#x60;warehouse:write&#x60;  **使用场景：** - 临时禁用维护中的仓库 - 启用新投入使用的仓库 - 系统管理和运营控制 

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.WarehousesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    WarehousesApi apiInstance = new WarehousesApi(defaultClient);
    String code = "code_example"; // String | 仓库编码。
    EntityStatus status = EntityStatus.fromValue("ENABLED"); // EntityStatus | 新的仓库状态。
    try {
      WarehouseResponse result = apiInstance.updateWarehouseStatus(code, status);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WarehousesApi#updateWarehouseStatus");
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
| **code** | **String**| 仓库编码。 | |
| **status** | [**EntityStatus**](.md)| 新的仓库状态。 | [enum: ENABLED, DISABLED] |

### Return type

[**WarehouseResponse**](WarehouseResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 仓库状态已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

