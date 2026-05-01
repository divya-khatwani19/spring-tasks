package com.divya.soapservice.endpoint;

import com.divya.soapservice.generated.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/user";

    // GET
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {

        GetUserResponse response = new GetUserResponse();
        response.setName("Divya");
        response.setEmail("divya@example.com");

        return response;
    }

    // ADD
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {

        AddUserResponse response = new AddUserResponse();
        response.setMessage("User added: " + request.getName());

        return response;
    }

    // UPDATE
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {

        UpdateUserResponse response = new UpdateUserResponse();
        response.setMessage("User updated with ID: " + request.getId());

        return response;
    }

    // DELETE
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {

        DeleteUserResponse response = new DeleteUserResponse();
        response.setMessage("User deleted with ID: " + request.getId());

        return response;
    }
}


//
//import com.divya.soapservice.generated.GetUserRequest;
//import com.divya.soapservice.generated.GetUserResponse;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;
//import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
//import org.springframework.ws.server.endpoint.annotation.RequestPayload;
//import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//
//@Endpoint
//public class UserEndpoint {
//
//    private static final String NAMESPACE_URI = "http://example.com/user";
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
//    @ResponsePayload
//    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
//
//        GetUserResponse response = new GetUserResponse();
//        response.setName("Divya");
//        response.setEmail("divya@example.com");
//
//        return response;
//    }
//}