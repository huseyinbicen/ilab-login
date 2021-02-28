package com.ilab.login.api.controller;

import com.ilab.login.api.response.ResponseOfGet;
import com.ilab.login.dto.UserRequest;
import com.ilab.login.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/test/{value}" , consumes = {MediaType.ALL_VALUE})
    @ApiOperation(value="test api", notes = "test api")
    public String test(@ApiParam(required = true)  @PathVariable("value") String value) {
        return value;
    }

    @PostMapping(value = "/login")
    @ApiOperation(value="login by username and password", notes = "default username = 'username' and default password='password'")
    public ResponseOfGet<String> login(@RequestBody UserRequest request) {
        return new ResponseOfGet<>(userService.login(request.getUsername(), request.getPassword()));
    }

    @PostMapping(value = "/save")
    @ApiOperation(value="save login info", notes = "")
    public ResponseOfGet<String> saveLogin(@RequestBody UserRequest request) {
        return new ResponseOfGet<>(userService.save(request.getUsername(), request.getPassword()));
    }
}
