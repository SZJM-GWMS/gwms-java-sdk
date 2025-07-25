

# InboundOrderBox


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createBy** | **Long** | 创建者ID |  [optional] |
|**createTime** | **OffsetDateTime** | 创建时间 |  [optional] |
|**updateBy** | **Long** | 更新者ID |  [optional] |
|**updateTime** | **OffsetDateTime** | 更新时间 |  [optional] |
|**params** | **Map&lt;String, Object&gt;** | 扩展参数 |  [optional] |
|**boxNo** | **String** | 箱号 |  [optional] |
|**boxStartNo** | **Integer** | 起始箱号 |  [optional] |
|**boxEndNo** | **Integer** | 结束箱号 |  [optional] |
|**boxCount** | **Integer** | 箱子数量 |  [optional] |
|**dimensions** | [**InboundDimensions**](InboundDimensions.md) |  |  [optional] |
|**weight** | [**InboundWeight**](InboundWeight.md) |  |  [optional] |
|**totalVolume** | **Double** | 总体积 |  [optional] |
|**totalWeight** | **Double** | 总重量 |  [optional] |
|**details** | [**List&lt;InboundOrderDetail&gt;**](InboundOrderDetail.md) | 箱内明细列表 |  [optional] |


## Implemented Interfaces

* Serializable


