

# ProductUpdateRequest

完整更新（PUT）需要所有字段。

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**params** | **Map&lt;String, Object&gt;** | 扩展参数，Map&lt;String, Object&gt;类型，用于后期扩展 |  [optional] |
|**spuCode** | **String** | SPU编码，关联产品SPU。使用业务编码耏非内部ID。 |  [optional] |
|**upc** | **String** | 通用产品代码。 |  [optional] |
|**amazonFnSku** | **String** | Amazon FN SKU。 |  [optional] |
|**serialNumber** | **String** | 序列号。 |  [optional] |
|**dimensions** | [**Dimensions**](Dimensions.md) |  |  [optional] |
|**weight** | [**Weight**](Weight.md) |  |  [optional] |
|**packaging** | [**Packaging**](Packaging.md) |  |  [optional] |
|**pricing** | [**Pricing**](Pricing.md) |  |  [optional] |
|**attributes** | [**Attributes**](Attributes.md) |  |  [optional] |
|**imageUrl** | **String** | 产品图片URL。 |  [optional] |


## Implemented Interfaces

* Serializable


