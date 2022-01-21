# network-spring-boot-starter

Network Request   SpringBoot Edition

[中文](./README_zh_CN.md)

Support function：
- [x] GetRequest
- [x] PostRequest
- [x] PutRequest
- [x] DeleteRequest
# Support function：
 Request parameter combination problem：
 Request parameters can be combined freely, so do not violate the request rules, such as Get request can not contain Body
 
```xml
<!--Adding dependencies to pom. XML-->
        <dependency>
            <artifactId>network-spring-boot-starter</artifactId>
            <groupId>com.github.thierrysquirrel</groupId>
            <version>2.3.1.2-RELEASE</version>
        </dependency>
```  
 ### configuration file
 
 ```properties
 ## application.properties
thierrysquirrel.connect-timeout= #Connect Timeout
thierrysquirrel.read-timeout= #Read Timeout
thierrysquirrel.write-timeout= #Write Timeout
 ```
 # Start Network
 ```java
 @SpringBootApplication
 @EnableNetwork
 public class DemoApplication{
     public static void main(String[] args){
         SpringApplication.run(DemoApplication.class, args);
     }
    
 }
 ```
 # Build Get、Delete Request
 
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
 # Build Post,Put Request
 
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
 # Send Requests
   
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