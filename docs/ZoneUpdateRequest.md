

# ZoneUpdateRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**params** | **Map&lt;String, Object&gt;** | 扩展参数，Map&lt;String, Object&gt;类型，用于后期扩展 |  [optional] |
|**name** | **String** | 库区名称 |  |
|**priority** | **Long** | 优先级 |  [optional] |
|**zoneType** | [**ZoneTypeEnum**](#ZoneTypeEnum) | 库区类型 |  [optional] |
|**remark** | **String** | 备注 |  [optional] |



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


