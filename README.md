# Contract testing with Spring Cloud Contract


## Steps in provider
* Create provider
* Create contract (Success case for Get user by id = 1)

```
package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return user by id=1"

    request {
        url "/users/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 1,
                firstname: "Test firstname",
                lastname: "Test lastname"
        )
    }

}
```

* Run provider testing with contract

pom.xml
```
<plugin>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-contract-maven-plugin</artifactId>
    <version>3.1.4</version>
    <extensions>true</extensions>
    <configuration>
        <testFramework>JUNIT5</testFramework>
        <baseClassForTests>com.example.provider.BaseClass</baseClassForTests>
    </configuration>
</plugin>
```

Generate the stubs ann run test the provider
```
$mvnw clean install
```


## Steps in consumer
* Create consumer
* Create consumer contract test
* Run test
