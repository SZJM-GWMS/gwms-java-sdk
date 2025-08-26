

# OutboundOrder


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**params** | **Map&lt;String, Object&gt;** | 扩展参数，Map&lt;String, Object&gt;类型，用于后期扩展 |  [optional] |
|**orderType** | [**OrderTypeEnum**](#OrderTypeEnum) | 单据类型 |  [optional] |
|**expressChannelsCode** | **String** | 物流渠道代码 |  |
|**labelUrl** | **String** | 自提面单url |  [optional] |
|**trackingNo** | **String** | 跟踪号 |  |
|**platformOrderNo** | **String** | 平台单号 |  |
|**warehouseCode** | **String** | 仓库代码 |  |
|**toFullName** | **String** | 收货人 |  |
|**toNumber** | **String** | 收货人联系号码 |  |
|**toCountry** | **String** | 收货国家 |  |
|**toProvince** | **String** | 收货省/州 |  |
|**toCity** | **String** | 收货城市 |  |
|**toAddressLine1** | **String** | 收货地址行1 |  |
|**toAddressLine2** | **String** | 收货地址行2 |  [optional] |
|**toZipCode** | **String** | 收货邮编 |  |
|**details** | [**List&lt;OutboundOrderDetail&gt;**](OutboundOrderDetail.md) | 订单sku明细 |  |



## Enum: OrderTypeEnum

| Name | Value |
|---- | -----|
| DROP_SHIPPING | &quot;DROP_SHIPPING&quot; |
| FBA | &quot;FBA&quot; |


## Implemented Interfaces

* Serializable


