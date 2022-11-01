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