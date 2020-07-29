# Trusted-Ticket-Generator
This is the service for generating the tableau trusted ticket. Service response to the GET/POST request will be a unique string (the ticket). If Tableau Server isn’t able to process the request, the return will be -1.  
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.mdsol.raa.trustedticketgenerator.TrustedTicketGeneratorApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### Actuator

To monitor and manage your application

|  URL |  Method |
|----------|--------------|
|`http://SERVER_URL:<PORT>`  						| GET |
|`http://SERVER_URL:<PORT>/actuator/actuator`  | GET |
|`http://SERVER_URL:<PORT>/actuator/health`    	| GET |
|`http://SERVER_URL:<PORT>/actuator/info`      	| GET |
|`http://SERVER_URL:<PORT>/actuator/prometheus`| GET |
|`http://SERVER_URL:<PORT>/actuator/httptrace` | GET |

### Endpoints/URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://SERVER_URL:<PORT>/swagger-ui.html`  | GET | You can see the Swagger/OpenAPI UI documentation|
|`http://SERVER_URL:<PORT>/trusted-token`  | GET | To get Trusted Ticket by passing query params|
|`http://SERVER_URL:<PORT>/trusted-token`  | POST | To get Trusted Ticket by passing request body|

##### Get params
```json
i.e:
http://SERVER_URL:<PORT>/trusted-token?userName=<user_name>&site=<site_name>&serverUrl=<server_url>
```

##### Post request body
```json
{  
"userName":"<user_name>",   
"site":"<site_name>",  
"serverUrl":"<server_url>"
}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Amol Patil** - [Github](https://github.com/amolp-mdsol)