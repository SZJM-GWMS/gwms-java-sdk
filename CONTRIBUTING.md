# 贡献指南

感谢您对 gwms-java-sdk 项目的关注！我们欢迎所有形式的贡献，包括bug报告、功能请求、文档改进和代码贡献。

## 贡献方式

### 🐛 报告问题

如果您发现了bug或有功能请求，请通过以下方式提交：

1. 在 [Issues](https://github.com/SZJM-GWMS/gwms-java-sdk/issues) 页面搜索，确认问题尚未被报告
2. 创建新的issue，使用合适的模板
3. 提供详细的信息，包括：
   - SDK版本号
   - Java版本
   - 操作系统信息
   - 完整的错误堆栈跟踪
   - 重现步骤
   - 预期行为和实际行为

### 📝 改进文档

文档改进包括：
- 修正错别字或语法错误
- 添加使用示例
- 改进API说明
- 翻译现有文档

### 💻 代码贡献

**注意**: 这是一个自动生成的SDK，直接的代码贡献有限制：

- ✅ **可以贡献的内容**：
  - 测试用例改进
  - 文档和示例代码
  - 构建脚本优化
  - CI/CD流程改进

- ❌ **请不要直接修改的内容**：
  - 自动生成的API客户端代码
  - 自动生成的模型类
  - 自动生成的配置文件

如果需要修改核心功能，请：
1. 首先提交issue讨论
2. 在主项目中修改OpenAPI规范
3. 重新生成SDK

## 开发流程

### 环境准备

```bash
# 克隆仓库
git clone https://github.com/SZJM-GWMS/gwms-java-sdk.git
cd gwms-java-sdk

# 设置Java环境
# 需要Java 8+，推荐Java 11或17

# 构建项目
mvn clean compile

# 运行测试
mvn test

# 生成文档
mvn javadoc:javadoc
```

### 提交Pull Request

1. **Fork仓库** 到您的GitHub账户
2. **创建特性分支**：
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **进行更改** 并确保：
   - 代码符合项目风格
   - 添加适当的测试
   - 更新相关文档
4. **提交更改**：
   ```bash
   git commit -m "type: 简短描述变更内容"
   ```
5. **推送分支**：
   ```bash
   git push origin feature/your-feature-name
   ```
6. **创建Pull Request** 在GitHub上

### 提交消息规范

使用 [Conventional Commits](https://www.conventionalcommits.org/) 格式：

```
type(scope): description

[可选的正文]

[可选的脚注]
```

**Type类型**：
- `feat`: 新功能
- `fix`: 修复bug
- `docs`: 文档更改
- `style`: 代码格式化（不影响功能）
- `refactor`: 重构代码
- `test`: 添加或修改测试
- `chore`: 构建过程或工具变更

**示例**：
```
feat: 添加重试机制示例代码
fix: 修复README中的安装说明错误
docs: 更新API使用文档
test: 添加ProductApi集成测试
```

## 代码规范

### Java代码规范

- 遵循 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- 使用4个空格缩进
- 行长度限制在120字符
- 所有公共方法必须有JavaDoc注释

### 测试规范

- 为新功能编写相应的测试
- 测试类命名：`ClassNameTest.java`
- 测试方法命名：`should_ExpectedBehavior_When_StateUnderTest()`
- 使用JUnit 5和Mockito框架

### 文档规范

- 中文文档使用简体中文
- 代码示例必须可运行
- API文档保持最新
- 使用Markdown格式编写

## 版本发布流程

版本发布由项目维护者负责：

1. 更新`CHANGELOG.md`记录变更
2. 创建版本标签：`git tag v1.0.3`
3. 推送标签触发自动发布：`git push origin v1.0.3`
4. GitHub Actions自动构建并发布到JitPack

## 社区准则

请遵守我们的 [行为准则](CODE_OF_CONDUCT.md)，保持友善和专业的交流环境。

## 许可证

通过贡献代码，您同意您的贡献将在 [Commercial](LICENSE) 下许可。

## 获得帮助

如有任何问题，您可以：
- 查看现有的 [Issues](https://github.com/SZJM-GWMS/gwms-java-sdk/issues)
- 创建新的issue询问
- 查看项目 [Wiki](https://github.com/SZJM-GWMS/gwms-java-sdk/wiki)（如果有）

感谢您的贡献！🎉