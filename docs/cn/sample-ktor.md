## Sample-ktor-sureness  

[ktor-sureness例子项目仓库地址](https://github.com/tomsun28/sureness/tree/master/samples/ktor-sureness)    

- 基于`ktor, servlet`
- 从默认的配置文件`sureness.yml`加载账户信息,资源角色,过滤资源等信息  
- 使用默认的`sureness-config`  
- 使用默认的`jwt,basic auth`方式认证鉴权
- 例子中包含`restful api`  
- 保护入口: `Application.kt`  
- 推荐使用`postman`测试