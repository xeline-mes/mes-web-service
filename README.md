Jersey and Spring Example with Java Config (no web.xml)

**Required:** Maven (to build)

**Recommended:** [cURL](http://www.google.com/) (for testing)

###Build, Run, and Test:

1. Package Maven project (after resolving dependencies, two test should be ran and should pass)
```
mvn clean package
```

2. Run project with [jetty-maven-plugin](http://eclipse.org/jetty/documentation/current/jetty-maven-plugin.html). 
This is not required, but I prefer it in development, rather than deploying to local server instance.

```
mvn jetty:run
```

3. Run cURL command to test (not required, you can simple use the browser url bar

```
curl -i http://localhost:8080/rest/greeting?name=Tom
```
    **Result**
```
curl -i http://localhost:8080/rest/greeting?name=Tom
HTTP/1.1 200 OK
Content-Type: text/plain
Content-Length: 20
Server: Jetty(9.2.4.v20141103)

Hello, Tom!
```

-----

###UPDATE

Added Jackson and configured ObjectMapper as a `@Bean` and injected it into the 
the `ObjectMapperContextResolver`. The configuration is simple. It's just formatting
the JSON, just to show the configuration works

You can run the app with `mvn jetty:run` and go to 

```
curl -v http://localhost:8080/rest/model
```


