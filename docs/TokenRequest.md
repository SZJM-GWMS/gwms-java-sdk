

# TokenRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**clientId** | **String** | 系统管理员生成的客户端ID，32位大写字母和数字组合。 每个上游系统都有唯一的clientId，用于标识和追踪API访问。  |  |
|**clientSecret** | **String** | 系统管理员生成的客户端密钥，Base64编码的64字节随机字符串。 此密钥只在生成时显示一次，请妥善保存。  |  |
|**apiKey** | **String** | 仓库用户生成的API密钥，32位大写字母和数字组合。 关联到特定仓库和权限范围，决定了访问令牌的权限。  |  |


## Implemented Interfaces

* Serializable


