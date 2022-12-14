# パラメータのNullチェック

## バリエーション実装

1. 依存情報

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    ```

2. Java実装例

    ```java
    @Service
    @Validated
    public class SampleService {
    
        private final Logger logger = LoggerFactory.getLogger(SampleService.class);
    
        public void test(@NotNull String param) {
    
            logger.info("test service.[param = {}]", param);
        }
    }
    ```

## バリエーション結果

```text
2022-12-15T08:47:20.966+09:00 ERROR 20976 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: Failed to execute CommandLineRunner
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:770) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:751) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1302) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1291) ~[spring-boot-3.0.0.jar:3.0.0]
	at cn.gekal.sample.methodparameternotnull.Application.main(Application.java:10) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) ~[spring-boot-devtools-3.0.0.jar:3.0.0]
Caused by: jakarta.validation.ConstraintViolationException: test.param: null は許可されていません
	at org.springframework.validation.beanvalidation.MethodValidationInterceptor.invoke(MethodValidationInterceptor.java:131) ~[spring-context-6.0.2.jar:6.0.2]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184) ~[spring-aop-6.0.2.jar:6.0.2]
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:752) ~[spring-aop-6.0.2.jar:6.0.2]
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:703) ~[spring-aop-6.0.2.jar:6.0.2]
	at cn.gekal.sample.methodparameternotnull.service.SampleService$$SpringCGLIB$$0.test(<generated>) ~[classes/:na]
	at cn.gekal.sample.methodparameternotnull.command.SampleCommand.run(SampleCommand.java:28) ~[classes/:na]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:767) ~[spring-boot-3.0.0.jar:3.0.0]
	... 10 common frames omitted
```

## 参照

1. [Using @NotNull on a Method Parameter](https://www.baeldung.com/java-notnull-method-parameter)
