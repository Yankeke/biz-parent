# biz-parent

### 项目介绍

SpringCloud微服务开发脚手架

### 模块说明

1. biz-boot-starter-dynamic-datasource 
    动态数据源模块。支持读写分离、多数据源动态切换
2. biz-boot-starter-elastic-job 
    elastic-job starter模块
3. biz-boot-starter-logger 
    elk&sentry starter模块。用于日志上传ELK及Sentry
4. biz-facade-common 
    通用facade模块
5. biz-spring-boot-admin 
    SpringBoot Admin监控模块
6. biz-spring-cloud-api-starter 
   spring-cloud starter模块。提供MDC过滤器、接口/方法切面、访问控制等一系列开箱即用功能
7. biz-spring-cloud-archetype 
    用于一键生成spring-cloud项目基础开发骨架
8. biz-spring-cloud-common 
    spring-cloud项目通用工具类
9. ~~(已废弃)biz-spring-cloud-dashboard-hystrix~~ 
    推荐使用biz-spring-cloud-dashboard-turbine来进行Hystrix断路器监控
10. biz-spring-cloud-dashboard-turbine 
     用于监控应用hystrix.stream断点，并进行Hystrix断路器信息聚合
11. biz-spring-cloud-eureka 
     Eureka注册中心
12. biz-spring-cloud-gateway 
     API网关。用做服务代理及API聚合，并提供所有服务的Swagger文档聚合
13. biz-spring-cloud-test 
     测试模块
14. biz-spring-cloud-api-service-order 
     订单模块(测试)
15. biz-spring-cloud-api-service-user 
     用户模块(测试)
16. biz-spring-cloud-api-service-user 
     公共服务。提供省市区查询、短链生成及解析服务
     
### TODO LIST

1. 完善动态数据源模块，支持多数据源的actuator监控 
2. 支持微服务调用全链路日志追踪，添加requestId 