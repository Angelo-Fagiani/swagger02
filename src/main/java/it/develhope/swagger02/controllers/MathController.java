package it.develhope.swagger02.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.develhope.swagger02.entities.ArithmeticOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/math")
public class MathController {
    @GetMapping(value ="")
    @ApiOperation(value = "Welcome math message!",notes = "Print out a welcome math message")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Created"),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public String welcomeMathMsg(){
        return "Welcome math message";
    }

    @GetMapping("/math/division-info")
    @ApiOperation(value = "Division Info", notes = "Print out Division Info")
    public ArithmeticOperation DivisionInfo(){
        return new ArithmeticOperation("division-info",2,"does the division",
                new String[]{"distributive-property","invariant-property"});
    }
    @GetMapping(value ="multiplication")
    @ApiOperation(value = "Multiplication info", notes = "Takes two int parameters and returns the multiplication result")
    public int multiplication(@RequestParam int a, int b){
        return Math.multiplyExact(a, b);
    }

    @GetMapping("square/{n}")
    @ApiOperation(value = "Execute square", notes = "Takes one int parameters and calculate square of a number")
    public double square(@ApiParam(value = "The id of the user") @PathVariable int n){
        return Math.pow(n,2);
    }
}
