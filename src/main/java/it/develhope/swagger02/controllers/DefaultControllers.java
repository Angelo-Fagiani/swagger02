package it.develhope.swagger02.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class DefaultControllers {

    @GetMapping(value = "/")
    @ApiOperation(value = "Welcome swagger 2", notes = "Print out a welcome message")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Created"),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String welcomeMessage(){
        return "Welcome swagger 2";
    }
}
