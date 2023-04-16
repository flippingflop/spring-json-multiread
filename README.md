# spring-json-multiread [![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fflippingflop%2Fspring-json-multiread&count_bg=%233221D8&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

This project demonstrates how to create a Spring Boot WebApp that allows HttpServletRequest to be read multiple times, thus avoiding the "stream is already closed" error when logging JSON body within an interceptor or other similar situations.

## Overview

This project consists of several classes that are responsible for different tasks:

- WebMvcConfig - Configuration for adding an interceptor in the Spring Boot application.
- CommonController - Controller containing sample API endpoints.
- HelloWorldRequest - A simple request model.
- RequestBodyRetrieveFilter - A filter that wraps the request to make it readable multiple times.
- ApiLogInterceptor - Interceptor that logs the JSON body of the incoming request.
- CommonUtils - A utility class that provides helper methods for handling requests.
- CustomHttpServletRequestWrapper - A custom wrapper for HttpServletRequest that allows reading the input stream multiple times.

The build.gradle file includes the necessary dependencies for the project.

## Usage
1. Clone the repository
```
git clone https://github.com/flippingflop/spring-json-multiread.git
```

2. Import the project into your favorite IDE.
3. Install the required dependencies using Gradle.
4. Run the Spring boot application.
5. Test the application by sending HTTP requests to the following endpoints:
- `/api/hello-world` : A simple POST request with a JSON payload.
- `/api/hello-world/multipart` : A POST request with a JSON payload and a file as a multipart request.
In both cases, the application will log the JSON body in the console.
.http file is stored for IntelliJ users.

## Contribution
Feel free to contribute to this project by submitting issues, pull requests, or suggestions for the improvement.

## License
This project is licensed under MIT License.
