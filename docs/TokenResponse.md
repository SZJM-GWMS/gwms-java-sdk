

# TokenResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**accessToken** | **String** | JWT访问令牌，用于后续API调用的身份验证。 令牌包含用户身份、权限范围和过期时间等信息。  |  |
|**apiKey** | **String** | API密钥 |  |
|**userId** | **String** | 用户ID |  |
|**systemId** | **String** | 系统ID |  |
|**vendor** | **String** | 供应商 |  |
|**scope** | **String** | 令牌权限范围，以空格分隔的字符串。 权限范围由apiKey关联的仓库用户权限决定。  |  |
|**tokenType** | [**TokenTypeEnum**](#TokenTypeEnum) | 令牌类型 |  |
|**expiresIn** | **Integer** | 令牌过期时间（秒） |  |
|**clientId** | **String** | 客户端ID |  |



## Enum: TokenTypeEnum

| Name | Value |
|---- | -----|
| BEARER | &quot;Bearer&quot; |


## Implemented Interfaces

* Serializable


