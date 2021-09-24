# network-spring-boot-starter

网络请求   SpringBoot 版

[English](./README.md)

支持功能：
- [x] Get请求
- [x] Post请求
- [x] Put请求
- [x] Delete请求
# 提示：
 请求参数组合问题：
 请求参数，可以自由组合，不要因此违法了请求规则，例如Get请求不能包含Body

```xml
<!--在pom.xml中添加依赖-->
        <dependency>
            <artifactId>network-spring-boot-starter</artifactId>
            <groupId>com.github.thierrysquirrel</groupId>
            <version>2.3.0.7-RELEASE</version>
        </dependency>
``` 
 ### 配置文件
 
 ```properties
 ## application.properties
thierrysquirrel.connect-timeout= #连接超时
thierrysquirrel.read-timeout= #读超时
thierrysquirrel.write-timeout= #写超时
 ```
# 启动Network
```java
@SpringBootApplication
@EnableNetwork
public class DemoApplication{
    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }
   
}
```
# 构建Get、Delete请求

```java
@Network
public interface GetDeleteRequestDemo {
	@GetRequest("https://***.com/***")
	String getA(@NetworkHeader("Header") String header, @NetworkParam("paramA") String paramA, @NetworkParam("paramB") String paramB);

	@GetRequest("https://***.com/***.png")
	InputStream getB();
	
    @DeleteRequest("https://***.com/***")
    String delete(@NetworkHeader("Header") String header, @NetworkParam("paramA") String paramA, @NetworkParam("paramB") String paramB);

}
```
# 构建Post,Put请求

```java
@Network
public interface PostPutRequestDemo {
	@PostRequest("https://***.com/***")
	String postA(@NetworkHeader("Header") String header, @NetworkParam("param") String paramA,@NetworkBody String body);

	@PostRequest("https://***.com/***")
	String postB(@NetworkFile("fileName") File fileName);
	
    @PutRequest("https://***.com/***")
    String putA(@NetworkHeader("Header") String header, @NetworkParam("param") String paramA,@NetworkBody String body);
    
    @PutRequest("https://***.com/***")
    String putB(@NetworkFile("fileName") File fileName);
}
```
# 发送请求
```java
@RestController
public class Demo {
    @Resource
    private GetDeleteRequestDemo getDeleteRequestDemo;
    
    public String demo(){
    	return getDeleteRequestDemo.getA("header","paramA","paramB");
    }
}
```