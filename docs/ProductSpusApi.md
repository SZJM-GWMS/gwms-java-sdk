# ProductSpusApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createProductSpu**](ProductSpusApi.md#createProductSpu) | **POST** /api/v1/products/spus | 创建一个产品SPU |
| [**deleteProductSpuByCode**](ProductSpusApi.md#deleteProductSpuByCode) | **DELETE** /api/v1/products/spus/code/{spuCode} | 通过SPU编码删除产品SPU |
| [**getProductSpuByCode**](ProductSpusApi.md#getProductSpuByCode) | **GET** /api/v1/products/spus/code/{spuCode} | 通过SPU编码获取产品SPU |
| [**listProductSpus**](ProductSpusApi.md#listProductSpus) | **GET** /api/v1/products/spus | 列出产品SPU |
| [**updateProductSpuByCode**](ProductSpusApi.md#updateProductSpuByCode) | **PUT** /api/v1/products/spus/code/{spuCode} | 通过SPU编码更新产品SPU（完整） |


<a id="createProductSpu"></a>
# **createProductSpu**
> ProductSpuResponse createProductSpu(idempotencyKey, productSpuCreateRequest)

创建一个产品SPU

在主数据中创建一个新的产品SPU。此操作是幂等的，支持上游系统推送产品SPU数据。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductSpusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductSpusApi apiInstance = new ProductSpusApi(defaultClient);
    UUID idempotencyKey = UUID.randomUUID(); // UUID | 一个唯一的密钥（例如，UUID），以确保资源的幂等创建。
    ProductSpuCreateRequest productSpuCreateRequest = new ProductSpuCreateRequest(); // ProductSpuCreateRequest | 要创建的产品SPU。
    try {
      ProductSpuResponse result = apiInstance.createProductSpu(idempotencyKey, productSpuCreateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductSpusApi#createProductSpu");
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
| **productSpuCreateRequest** | [**ProductSpuCreateRequest**](ProductSpuCreateRequest.md)| 要创建的产品SPU。 | |

### Return type

[**ProductSpuResponse**](ProductSpuResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | 产品SPU已成功创建。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **409** | 冲突。当请求与服务器的当前状态冲突时，将发送此响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="deleteProductSpuByCode"></a>
# **deleteProductSpuByCode**
> deleteProductSpuByCode(spuCode)

通过SPU编码删除产品SPU

通过SPU编码删除产品SPU。使用业务编码而非内部ID进行操作。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductSpusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductSpusApi apiInstance = new ProductSpusApi(defaultClient);
    String spuCode = "SPU-001"; // String | 产品SPU的业务编码。
    try {
      apiInstance.deleteProductSpuByCode(spuCode);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductSpusApi#deleteProductSpuByCode");
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
| **spuCode** | **String**| 产品SPU的业务编码。 | |

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
| **204** | 产品SPU已成功删除。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **409** | 冲突。产品SPU无法删除，例如，它有关联的产品。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="getProductSpuByCode"></a>
# **getProductSpuByCode**
> ProductSpuResponse getProductSpuByCode(spuCode)

通过SPU编码获取产品SPU

通过SPU编码检索特定产品SPU的详细信息。使用业务编码而非内部ID进行查询。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductSpusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductSpusApi apiInstance = new ProductSpusApi(defaultClient);
    String spuCode = "SPU-001"; // String | 产品SPU的业务编码。
    try {
      ProductSpuResponse result = apiInstance.getProductSpuByCode(spuCode);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductSpusApi#getProductSpuByCode");
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
| **spuCode** | **String**| 产品SPU的业务编码。 | |

### Return type

[**ProductSpuResponse**](ProductSpuResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 产品SPU详情。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="listProductSpus"></a>
# **listProductSpus**
> ProductSpuListResponse listProductSpus(pageNumber, pageSize, sort, isAsc, spuCode, productName)

列出产品SPU

检索产品SPU的分页列表，允许过滤和排序。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductSpusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductSpusApi apiInstance = new ProductSpusApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String sort = "createdAt,spuCode"; // String | 结果的排序字段。使用逗号分隔的字段列表。
    SortDirection isAsc = SortDirection.fromValue("ASC"); // SortDirection | 排序方向。ASC为升序，DESC为降序。
    String spuCode = "spuCode_example"; // String | 按SPU编码筛选。
    String productName = "productName_example"; // String | 按产品名称筛选。
    try {
      ProductSpuListResponse result = apiInstance.listProductSpus(pageNumber, pageSize, sort, isAsc, spuCode, productName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductSpusApi#listProductSpus");
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
| **spuCode** | **String**| 按SPU编码筛选。 | [optional] |
| **productName** | **String**| 按产品名称筛选。 | [optional] |

### Return type

[**ProductSpuListResponse**](ProductSpuListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 产品SPU的分页列表。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateProductSpuByCode"></a>
# **updateProductSpuByCode**
> ProductSpuResponse updateProductSpuByCode(spuCode, productSpuUpdateRequest)

通过SPU编码更新产品SPU（完整）

通过SPU编码更新产品SPU的所有属性。使用业务编码而非内部ID进行操作。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductSpusApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductSpusApi apiInstance = new ProductSpusApi(defaultClient);
    String spuCode = "SPU-001"; // String | 产品SPU的业务编码。
    ProductSpuUpdateRequest productSpuUpdateRequest = new ProductSpuUpdateRequest(); // ProductSpuUpdateRequest | 要更新的完整产品SPU数据。
    try {
      ProductSpuResponse result = apiInstance.updateProductSpuByCode(spuCode, productSpuUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductSpusApi#updateProductSpuByCode");
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
| **spuCode** | **String**| 产品SPU的业务编码。 | |
| **productSpuUpdateRequest** | [**ProductSpuUpdateRequest**](ProductSpuUpdateRequest.md)| 要更新的完整产品SPU数据。 | |

### Return type

[**ProductSpuResponse**](ProductSpuResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 产品SPU已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

