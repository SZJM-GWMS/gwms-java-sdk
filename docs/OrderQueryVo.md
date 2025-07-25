

# OrderQueryVo


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**orderType** | [**OrderTypeEnum**](#OrderTypeEnum) | 单据类型 |  [optional] |
|**orderState** | [**OrderStateEnum**](#OrderStateEnum) | 订单出库状态 |  [optional] |
|**errorMsg** | **String** | 异常信息 |  [optional] |
|**trackingNo** | **String** | 运单号 |  [optional] |
|**charges** | [**List&lt;Charge&gt;**](Charge.md) | 计费项 |  [optional] |
|**customerCode** | **String** | 客户代码 |  [optional] |
|**expressChannelCode** | **String** | 物流渠道 |  [optional] |
|**platformOrderNo** | **String** | 平台单号 |  [optional] |
|**wmsOrderNo** | **String** | wms单号 |  [optional] |
|**warehouseCode** | **String** | 仓库代码 |  [optional] |
|**toFullName** | **String** | 收货人 |  [optional] |
|**toNumber** | **String** | 收货人联系号码 |  [optional] |
|**toCountry** | **String** | 收货国家 |  [optional] |
|**toProvince** | **String** | 收货省/州 |  [optional] |
|**toCity** | **String** | 收货城市 |  [optional] |
|**toAddressLine1** | **String** | 收货地址行1 |  [optional] |
|**toAddressLine2** | **String** | 收货地址行2 |  [optional] |
|**toZipCode** | **String** | 收货邮编 |  [optional] |
|**details** | [**List&lt;OutboundOrderDetail&gt;**](OutboundOrderDetail.md) |  |  [optional] |



## Enum: OrderTypeEnum

| Name | Value |
|---- | -----|
| DROP_SHIPPING | &quot;DROP_SHIPPING&quot; |
| FBA | &quot;FBA&quot; |



## Enum: OrderStateEnum

| Name | Value |
|---- | -----|
| DRAFT | &quot;DRAFT&quot; |
| NOT_OUT | &quot;NOT_OUT&quot; |
| OUTED | &quot;OUTED&quot; |
| ERROR | &quot;ERROR&quot; |


## Implemented Interfaces

* Serializable


