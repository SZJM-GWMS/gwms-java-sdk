

# InboundOrderDetail


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createBy** | **Long** | 创建者ID |  [optional] |
|**createTime** | **OffsetDateTime** | 创建时间 |  [optional] |
|**updateBy** | **Long** | 更新者ID |  [optional] |
|**updateTime** | **OffsetDateTime** | 更新时间 |  [optional] |
|**params** | **Map&lt;String, Object&gt;** | 扩展参数 |  [optional] |
|**boxCode** | **String** | 箱子编码 |  [optional] |
|**skuCode** | **String** | 商品编码（外部SKU编码，映射到内部sku或gsku） |  [optional] |
|**skuName** | **String** | 商品名称 |  [optional] [readonly] |
|**quantity** | **Integer** | 产品数量 |  [optional] |
|**dimensions** | [**InboundDimensions**](InboundDimensions.md) |  |  [optional] |
|**weight** | [**InboundWeight**](InboundWeight.md) |  |  [optional] |
|**expirationDate** | **LocalDate** | 到期日期 |  [optional] |
|**productionDate** | **LocalDate** | 生产日期 |  [optional] |
|**skuAttributes** | **String** | SKU扩展属性(JSON格式) |  [optional] |
|**inTransitQuantity** | **Integer** | 在途库存 |  [optional] |


## Implemented Interfaces

* Serializable


