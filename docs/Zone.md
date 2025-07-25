

# Zone


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createBy** | **Long** | 创建者ID |  [optional] |
|**createTime** | **OffsetDateTime** | 创建时间 |  [optional] |
|**updateBy** | **Long** | 更新者ID |  [optional] |
|**updateTime** | **OffsetDateTime** | 更新时间 |  [optional] |
|**params** | **Map&lt;String, Object&gt;** | 扩展参数 |  [optional] |
|**zoneId** | **Long** | 库区唯一标识 |  |
|**warehouseId** | **Long** | 所属仓库ID |  |
|**warehouseName** | **String** | 所属仓库名称 |  [optional] |
|**code** | **String** | 库区编码 |  |
|**name** | **String** | 库区名称 |  |
|**priority** | **Long** | 优先级 |  [optional] |
|**zoneType** | [**ZoneTypeEnum**](#ZoneTypeEnum) | 库区类型 |  [optional] |
|**remark** | **String** | 备注 |  [optional] |
|**status** | **EntityStatus** |  |  |



## Enum: ZoneTypeEnum

| Name | Value |
|---- | -----|
| STORAGE | &quot;STORAGE&quot; |
| PICKING | &quot;PICKING&quot; |
| PACKING | &quot;PACKING&quot; |
| STAGING | &quot;STAGING&quot; |
| DOCK | &quot;DOCK&quot; |
| RETURNS | &quot;RETURNS&quot; |
| QUARANTINE | &quot;QUARANTINE&quot; |


## Implemented Interfaces

* Serializable


