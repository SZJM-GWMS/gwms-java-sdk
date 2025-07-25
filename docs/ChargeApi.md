# ChargeApi

All URIs are relative to *https://gwms.jmalltech.com/api-gateway*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listChargeTransactions**](ChargeApi.md#listChargeTransactions) | **GET** /api/v1/transactions | 查询计费流水列表 |


<a id="listChargeTransactions"></a>
# **listChargeTransactions**
> ChargeTransactionListResponse listChargeTransactions(pageNumber, pageSize, customerCode, warehouseCode, transactionsCode, bizBillNo, bizType, chargeStatus)

查询计费流水列表

根据过滤条件查询计费流水，支持分页。

### Example
```java
// Import classes:
import com.jmalltech.gwms.sdk.invoker.ApiClient;
import com.jmalltech.gwms.sdk.invoker.ApiException;
import com.jmalltech.gwms.sdk.invoker.Configuration;
import com.jmalltech.gwms.sdk.invoker.auth.*;
import com.jmalltech.gwms.sdk.invoker.models.*;
import com.jmalltech.gwms.sdk.api.ChargeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://gwms.jmalltech.com/api-gateway");
    
    // Configure HTTP bearer authorization: BearerAuth
    HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
    BearerAuth.setBearerToken("BEARER TOKEN");

    ChargeApi apiInstance = new ChargeApi(defaultClient);
    Integer pageNumber = 1; // Integer | 页码（从1开始）
    Integer pageSize = 20; // Integer | 每页记录数
    String customerCode = "customerCode_example"; // String | 客户编码
    String warehouseCode = "warehouseCode_example"; // String | 仓库编码
    String transactionsCode = "transactionsCode_example"; // String | 流水编号
    String bizBillNo = "bizBillNo_example"; // String | 业务单号
    ChargeBizType bizType = ChargeBizType.fromValue("inbound"); // ChargeBizType | 流水类型
    ChargeStatus chargeStatus = ChargeStatus.fromValue("-1"); // ChargeStatus | 计费状态
    try {
      ChargeTransactionListResponse result = apiInstance.listChargeTransactions(pageNumber, pageSize, customerCode, warehouseCode, transactionsCode, bizBillNo, bizType, chargeStatus);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ChargeApi#listChargeTransactions");
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
| **customerCode** | **String**| 客户编码 | [optional] |
| **warehouseCode** | **String**| 仓库编码 | [optional] |
| **transactionsCode** | **String**| 流水编号 | [optional] |
| **bizBillNo** | **String**| 业务单号 | [optional] |
| **bizType** | [**ChargeBizType**](.md)| 流水类型 | [optional] [enum: inbound, warehouseInternal, outbound, warehouseRent, order, other] |
| **chargeStatus** | [**ChargeStatus**](.md)| 计费状态 | [optional] [enum: -1, 0, 1, 2, 3] |

### Return type

[**ChargeTransactionListResponse**](ChargeTransactionListResponse.md)

### Authorization

[BearerAuth](../README.md#BearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | 成功获取计费流水列表 |  -  |
| **400** | 错误的请求。由于被认为是客户端错误（例如，格式错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理该请求。 |  -  |
| **401** | 未经授权。客户端必须对自己进行身份验证才能获得请求的响应。 |  -  |
| **500** | 内部服务器错误。服务器遇到了不知道如何处理的情况。 |  -  |

