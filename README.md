
# Required
[Maven](https://maven.apache.org/) (to build)
[cURL](http://curl.haxx.se/) (for testing)
[chrome](https://www.google.com/chrome/browser/desktop/index.html) (for testing)
[postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop) (plugin for chrome)

# Build, Run, and Test:

1. Package Maven project (after resolving dependencies, two test should be ran and should pass)

```
mvn clean package
```

2. Run project with [jetty-maven-plugin](http://eclipse.org/jetty/documentation/current/jetty-maven-plugin.html). 
This is not required, but I prefer it in development, rather than deploying to local server instance.

```
mvn jetty:run
```

3-1. Run cURL command to test (not required, you can simple use the browser url bar

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

3-2. Browse to http://localhost:8080 to see the top page
```
WebSocket
http://localhost:8080
RESTful API
http://localhost:8080/rest/user/{name}
ex.
[GET]http://localhost:8080/rest/user/someuser
[PUT]http://localhost:8080/rest/user/user1
[DELETE]http://localhost:8080/rest/user/user1
```
