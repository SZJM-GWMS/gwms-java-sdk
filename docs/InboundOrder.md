

# InboundOrder


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createBy** | **Long** | 创建者ID |  [optional] |
|**createTime** | **OffsetDateTime** | 创建时间 |  [optional] |
|**updateBy** | **Long** | 更新者ID |  [optional] |
|**updateTime** | **OffsetDateTime** | 更新时间 |  [optional] |
|**params** | **Map&lt;String, Object&gt;** | 扩展参数 |  [optional] |
|**inboundNo** | **String** | 入库单号 |  [optional] |
|**inboundType** | **InboundTypeEnum** |  |  [optional] |
|**arriveMethod** | **ArrivalMethodEnum** |  |  [optional] |
|**asnOrderCode** | **String** | 关联预报单编码 |  [optional] |
|**ownerCode** | **String** | 货主编码 |  [optional] |
|**ownerName** | **String** | 货主名称 |  [optional] [readonly] |
|**warehouseCode** | **String** | 仓库编码 |  [optional] |
|**warehouseName** | **String** | 仓库名称 |  [optional] [readonly] |
|**status** | **InboundOrderStatusEnum** |  |  [optional] |
|**transportType** | [**TransportTypeEnum**](#TransportTypeEnum) | 运输方式 |  [optional] |
|**expectArriveTime** | **OffsetDateTime** | 预期送达时间 |  [optional] |
|**trackingNo** | **String** | 跟踪号(快递单号/运单号) |  [optional] |
|**carrierCode** | **String** | 承运商编码 |  [optional] |
|**attachmentUrls** | **String** | 附件地址(多个逗号分隔) |  [optional] |
|**totalBoxReceive** | **Integer** | 已接收箱子总数 |  [optional] |
|**totalSkuReceive** | **Integer** | 已接收SKU总数 |  [optional] |
|**totalBoxAsn** | **Integer** | 预报箱子总数 |  [optional] |
|**totalSkuAsn** | **Integer** | 预报SKU总数 |  [optional] |
|**lastReceiveTime** | **OffsetDateTime** | 最后接收时间 |  [optional] |
|**isMetric** | **Boolean** | 是否使用公制单位 |  [optional] |
|**remark** | **String** | 备注 |  [optional] |



## Enum: TransportTypeEnum

| Name | Value |
|---- | -----|
| AIR | &quot;AIR&quot; |
| SEA | &quot;SEA&quot; |
| RAIL | &quot;RAIL&quot; |
| TRUCK | &quot;TRUCK&quot; |
| EXPRESS | &quot;EXPRESS&quot; |
| OTHER | &quot;OTHER&quot; |


## Implemented Interfaces

* Serializable


