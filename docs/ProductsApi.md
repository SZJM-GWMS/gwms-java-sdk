# ProductsApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createProduct**](ProductsApi.md#createProduct) | **POST** /api/v1/products | 创建一个产品 |
| [**createProductsBatch**](ProductsApi.md#createProductsBatch) | **POST** /api/v1/products/batch | 批量创建产品 |
| [**deleteProductBySkuCode**](ProductsApi.md#deleteProductBySkuCode) | **DELETE** /api/v1/products/skuCode/{skuCode} | 通过SKU编码删除产品 |
| [**getProductBySkuCode**](ProductsApi.md#getProductBySkuCode) | **GET** /api/v1/products/skuCode/{skuCode} | 通过SKU编码获取产品 |
| [**listProducts**](ProductsApi.md#listProducts) | **GET** /api/v1/products | 列出产品 |
| [**partialUpdateProductBySkuCode**](ProductsApi.md#partialUpdateProductBySkuCode) | **PATCH** /api/v1/products/skuCode/{skuCode} | 通过SKU编码更新产品（部分） |
| [**updateProductBySkuCode**](ProductsApi.md#updateProductBySkuCode) | **PUT** /api/v1/products/skuCode/{skuCode} | 通过SKU编码更新产品（完整） |


<a id="createProduct"></a>
# **createProduct**
> ProductResponse createProduct(idempotencyKey, productCreateRequest)

创建一个产品

在主数据中创建一个新产品。此操作是幂等的，支持上游系统推送产品数据。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    UUID idempotencyKey = UUID.randomUUID(); // UUID | 一个唯一的密钥（例如，UUID），以确保资源的幂等创建。
    ProductCreateRequest productCreateRequest = new ProductCreateRequest(); // ProductCreateRequest | 要创建的产品。
    try {
      ProductResponse result = apiInstance.createProduct(idempotencyKey, productCreateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#createProduct");
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
| **productCreateRequest** | [**ProductCreateRequest**](ProductCreateRequest.md)| 要创建的产品。 | |

### Return type

[**ProductResponse**](ProductResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | 产品已成功创建。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **409** | 冲突。当请求与服务器的当前状态冲突时，将发送此响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="createProductsBatch"></a>
# **createProductsBatch**
> ProductBatchResponse createProductsBatch(idempotencyKey, productBatchRequest)

批量创建产品

支持上游系统批量推送产品数据到WMS系统。适用于ERP系统、电商平台等批量同步产品主数据的场景。批量操作具有事务一致性：要么全部成功创建，要么全部失败。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    UUID idempotencyKey = UUID.randomUUID(); // UUID | 一个唯一的密钥（例如，UUID），以确保批量操作的幂等性。
    ProductBatchRequest productBatchRequest = new ProductBatchRequest(); // ProductBatchRequest | 批量创建的产品数据。
    try {
      ProductBatchResponse result = apiInstance.createProductsBatch(idempotencyKey, productBatchRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#createProductsBatch");
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
| **idempotencyKey** | **UUID**| 一个唯一的密钥（例如，UUID），以确保批量操作的幂等性。 | |
| **productBatchRequest** | [**ProductBatchRequest**](ProductBatchRequest.md)| 批量创建的产品数据。 | |

### Return type

[**ProductBatchResponse**](ProductBatchResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 批量操作成功完成，返回创建的产品ID列表。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="deleteProductBySkuCode"></a>
# **deleteProductBySkuCode**
> deleteProductBySkuCode(skuCode)

通过SKU编码删除产品

通过产品SKU编码删除产品。外部skuCode将映射到内部的sku或gsku字段。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    String skuCode = "WIDGET-001"; // String | 产品SKU编码（外部编码，将映射到内部sku或gsku）。
    try {
      apiInstance.deleteProductBySkuCode(skuCode);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#deleteProductBySkuCode");
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
| **skuCode** | **String**| 产品SKU编码（外部编码，将映射到内部sku或gsku）。 | |

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
| **204** | 产品已成功删除。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **409** | 冲突。产品无法删除，例如，它有关联的库存。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="getProductBySkuCode"></a>
# **getProductBySkuCode**
> ProductResponse getProductBySkuCode(skuCode)

通过SKU编码获取产品

通过产品SKU编码检索特定产品的详细信息。外部skuCode将映射到内部的sku或gsku字段。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    String skuCode = "WIDGET-001"; // String | 产品SKU编码（外部编码，将映射到内部sku或gsku）。
    try {
      ProductResponse result = apiInstance.getProductBySkuCode(skuCode);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#getProductBySkuCode");
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
| **skuCode** | **String**| 产品SKU编码（外部编码，将映射到内部sku或gsku）。 | |

### Return type

[**ProductResponse**](ProductResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 产品详情。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="listProducts"></a>
# **listProducts**
> ProductListResponse listProducts(pageNumber, pageSize, sort, isAsc, sku, status)

列出产品

检索产品的分页列表，允许过滤和排序。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String sort = "createdAt,sku"; // String | 结果的排序字段。使用逗号分隔的字段列表。
    SortDirection isAsc = SortDirection.fromValue("ASC"); // SortDirection | 排序方向。ASC为升序，DESC为降序。
    String sku = "sku_example"; // String | 按产品SKU筛选。
    ProductStatus status = ProductStatus.fromValue("ACTIVE"); // ProductStatus | 按产品状态筛选。
    try {
      ProductListResponse result = apiInstance.listProducts(pageNumber, pageSize, sort, isAsc, sku, status);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#listProducts");
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
| **sku** | **String**| 按产品SKU筛选。 | [optional] |
| **status** | [**ProductStatus**](.md)| 按产品状态筛选。 | [optional] [enum: ACTIVE, INACTIVE, DRAFT] |

### Return type

[**ProductListResponse**](ProductListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 产品的分页列表。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="partialUpdateProductBySkuCode"></a>
# **partialUpdateProductBySkuCode**
> ProductResponse partialUpdateProductBySkuCode(skuCode, productPartialUpdateRequest)

通过SKU编码更新产品（部分）

通过产品SKU编码更新产品的一个或多个属性。外部skuCode将映射到内部的sku或gsku字段。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    String skuCode = "WIDGET-001"; // String | 产品SKU编码（外部编码，将映射到内部sku或gsku）。
    ProductPartialUpdateRequest productPartialUpdateRequest = new ProductPartialUpdateRequest(); // ProductPartialUpdateRequest | 要更新的产品属性。
    try {
      ProductResponse result = apiInstance.partialUpdateProductBySkuCode(skuCode, productPartialUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#partialUpdateProductBySkuCode");
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
| **skuCode** | **String**| 产品SKU编码（外部编码，将映射到内部sku或gsku）。 | |
| **productPartialUpdateRequest** | [**ProductPartialUpdateRequest**](ProductPartialUpdateRequest.md)| 要更新的产品属性。 | |

### Return type

[**ProductResponse**](ProductResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 产品已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

<a id="updateProductBySkuCode"></a>
# **updateProductBySkuCode**
> ProductResponse updateProductBySkuCode(skuCode, productUpdateRequest)

通过SKU编码更新产品（完整）

通过产品SKU编码更新产品的所有属性。外部skuCode将映射到内部的sku或gsku字段。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ProductsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ProductsApi apiInstance = new ProductsApi(defaultClient);
    String skuCode = "WIDGET-001"; // String | 产品SKU编码（外部编码，将映射到内部sku或gsku）。
    ProductUpdateRequest productUpdateRequest = new ProductUpdateRequest(); // ProductUpdateRequest | 要更新的完整产品数据。
    try {
      ProductResponse result = apiInstance.updateProductBySkuCode(skuCode, productUpdateRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProductsApi#updateProductBySkuCode");
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
| **skuCode** | **String**| 产品SKU编码（外部编码，将映射到内部sku或gsku）。 | |
| **productUpdateRequest** | [**ProductUpdateRequest**](ProductUpdateRequest.md)| 要更新的完整产品数据。 | |

### Return type

[**ProductResponse**](ProductResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 产品已成功更新。 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **404** | 未找到。服务器找不到请求的资源。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

