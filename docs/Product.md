

# Product


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createBy** | **Long** | 创建者ID |  [optional] |
|**createTime** | **OffsetDateTime** | 创建时间 |  [optional] |
|**updateBy** | **Long** | 更新者ID |  [optional] |
|**updateTime** | **OffsetDateTime** | 更新时间 |  [optional] |
|**params** | **Map&lt;String, Object&gt;** | 扩展参数 |  [optional] |
|**id** | **Long** | 产品的唯一标识符。 |  [optional] [readonly] |
|**userId** | **Long** | 用户ID。 |  [optional] |
|**spuCode** | **String** | SPU编码，关联产品SPU。使用业务编码而非内部ID。 |  [optional] |
|**upc** | **String** | 通用产品代码。 |  [optional] |
|**sku** | **String** | 库存单位。产品的唯一的内部标识符。 |  [optional] |
|**skuCode** | **String** | 外部SKU编码。映射到内部的sku或gsku字段，用于外部系统集成。 |  [optional] |
|**gsku** | **String** | 全局库存单位。 |  [optional] |
|**amazonFnSku** | **String** | Amazon FN SKU。 |  [optional] |
|**serialNumber** | **String** | 序列号。 |  [optional] |
|**dimensions** | [**Dimensions**](Dimensions.md) |  |  [optional] |
|**weight** | [**Weight**](Weight.md) |  |  [optional] |
|**packaging** | [**Packaging**](Packaging.md) |  |  [optional] |
|**pricing** | [**Pricing**](Pricing.md) |  |  [optional] |
|**attributes** | [**Attributes**](Attributes.md) |  |  [optional] |
|**imageUrl** | **String** | 产品图片URL。 |  [optional] |
|**status** | **ProductStatus** |  |  [optional] |


## Implemented Interfaces

* Serializable


