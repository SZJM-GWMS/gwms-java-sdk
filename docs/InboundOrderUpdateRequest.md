

# InboundOrderUpdateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**params** | **Map&lt;String, Object&gt;** | 扩展参数，Map&lt;String, Object&gt;类型，用于后期扩展 |  [optional] |
|**inboundType** | **InboundTypeEnum** |  |  [optional] |
|**arriveMethod** | **ArrivalMethodEnum** |  |  [optional] |
|**asnOrderCode** | **String** | 关联预报单编码 |  [optional] |
|**transportType** | [**TransportTypeEnum**](#TransportTypeEnum) | 运输方式 |  [optional] |
|**expectArriveTime** | **OffsetDateTime** | 预期送达时间 |  [optional] |
|**trackingNo** | **String** | 跟踪号(快递单号/运单号) |  [optional] |
|**carrierCode** | **String** | 承运商编码 |  [optional] |
|**attachmentUrls** | **String** | 附件地址(多个逗号分隔) |  [optional] |
|**remark** | **String** | 备注 |  [optional] |
|**boxes** | [**List&lt;InboundOrderBoxCreateRequest&gt;**](InboundOrderBoxCreateRequest.md) | 入库单箱子列表 |  [optional] |



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


