# 安全策略

## 支持的版本

我们目前支持以下版本的安全更新：

| 版本 | 支持状态 |
| --- | --- |
| 1.0.3 | :white_check_mark: |
| < 1.0.3 | :x: |

## 报告漏洞

我们非常重视安全问题。如果您发现了安全漏洞，请**不要**在公开的GitHub Issues中报告。

### 如何报告安全漏洞

请通过以下方式之一报告安全漏洞：

1. **邮件报告**：发送邮件至 [dev@jmalltech.com]
2. **私密报告**：使用GitHub的私密漏洞报告功能

### 报告内容应包括

为了帮助我们更好地理解和解决问题，请在报告中包含以下信息：

- 漏洞的详细描述
- 重现步骤
- 潜在的影响
- 您认为可能的解决方案（如果有）
- 相关的代码片段或配置
- 您的联系信息

### 我们的承诺

- **确认收到**：我们将在48小时内确认收到您的报告
- **初步评估**：我们将在5个工作日内进行初步评估
- **定期更新**：我们会每周向您更新进展情况
- **修复时间**：我们致力于在合理时间内修复确认的安全漏洞

### 负责任的披露

我们遵循负责任的披露原则：

1. 给我们合理的时间调查和修复问题
2. 在修复发布之前，请勿公开披露漏洞
3. 避免对生产系统造成不必要的影响

### 安全最佳实践

使用本SDK时，请遵循以下安全最佳实践：

#### 1. 凭证管理
```java
// ❌ 错误：硬编码凭证
TokenRequest request = new TokenRequest()
    .clientId("your-client-id")
    .clientSecret("your-client-secret");

// ✅ 正确：使用环境变量
TokenRequest request = new TokenRequest()
    .clientId(System.getenv("GWMS_CLIENT_ID"))
    .clientSecret(System.getenv("GWMS_CLIENT_SECRET"));
```

#### 2. HTTPS连接
```java
// 确保使用HTTPS端点
ApiClient client = Configuration.getDefaultApiClient();
client.setBasePath("https://api.gwms.jmalltech.com"); // HTTPS
```

#### 3. 超时设置
```java
// 设置合理的超时时间，避免长时间等待
ApiClient client = Configuration.getDefaultApiClient();
client.setConnectTimeout(30000); // 30秒
client.setReadTimeout(60000);    // 60秒
```

#### 4. 输入验证
```java
// 验证用户输入，防止注入攻击
public void createProduct(String name) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("产品名称不能为空");
    }
    if (name.length() > 100) {
        throw new IllegalArgumentException("产品名称长度不能超过100字符");
    }
    // 继续处理...
}
```

#### 5. 错误处理
```java
// 避免暴露敏感信息
try {
    // API调用
} catch (ApiException e) {
    // ❌ 错误：可能暴露敏感信息
    logger.error("API调用失败: " + e.getResponseBody());
    
    // ✅ 正确：记录安全的错误信息
    logger.error("API调用失败，状态码: " + e.getCode());
}
```

### 已知安全考虑

1. **令牌安全**：访问令牌具有时效性，请确保及时刷新
2. **网络安全**：在不安全的网络环境中使用时要格外谨慎
3. **日志安全**：避免在日志中记录敏感信息
4. **依赖更新**：定期更新SDK和相关依赖
5. **漏洞扫描**：建议在项目中集成依赖漏洞扫描工具，如：
   - Maven: `mvn org.owasp:dependency-check-maven:check`
   - Gradle: `./gradlew dependencyCheckAnalyze`
   - GitHub Dependabot：自动检测和提醒依赖漏洞

### 依赖安全管理

我们建议在您的项目中采用以下安全实践：

```xml
<!-- 在pom.xml中添加OWASP依赖检查插件 -->
<plugin>
    <groupId>org.owasp</groupId>
    <artifactId>dependency-check-maven</artifactId>
    <version>9.0.7</version>
    <configuration>
        <failBuildOnCVSS>7</failBuildOnCVSS>
        <skipProvidedScope>true</skipProvidedScope>
        <skipRuntimeScope>false</skipRuntimeScope>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

### 安全更新通知

我们将通过以下渠道发布安全更新：

- GitHub Releases页面
- 项目README文件
- 官方邮件列表（如果适用）

### 联系我们

如有安全相关问题，请联系：

- **安全邮箱**：[dev@jmalltech.com]
- **项目维护者**：[JMall Tech]
- **组织**：[JMall Technology]

感谢您帮助保护gwms-java-sdk及其用户的安全！