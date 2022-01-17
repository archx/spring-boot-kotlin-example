# Spring Boot Kotlin Example

## Gradle 配置

**代理配置**

> 当内网环境需要代理时，在项目根目录添加文件 `gradle.properties`

```properties
systemProp.http.proxyHost=10.168.17.70
systemProp.http.proxyPort=808
systemProp.http.nonProxyHosts=10.*|localhost
systemProp.https.proxyHost=10.168.17.70
systemProp.https.proxyPort=808
systemProp.https.nonProxyHosts=10.*|localhost
```