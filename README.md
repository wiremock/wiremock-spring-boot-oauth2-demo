# Spring Boot WireMock OAuth2 Mocking Demo

Requires a JVM of version 17 or above to be installed.

## How to run

Clone the project and cd into it:

```bash
git clone git@github.com:wiremock/wiremock-spring-boot-oauth2-demo.git --depth 1
cd wiremock-spring-boot-oauth2-demo
```


In one terminal start the OAuth2 mock:

```bash
./gradlew runMocks
```

In another terminal start the app:

```bash
./gradlew bootRun
```

Open [http://localhost:8080](http://localhost:8080/) in your browser to start the demo.