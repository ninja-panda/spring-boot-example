package com.tuturself.webservice;

import com.tuturself.model.ConsulConfiguration;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Guidelines", description = "Describes the guidelines for using " +
        " Spring boot 2.0 with Consul integration",
        protocols = "http", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RestApi {

    @Autowired
    private ConsulConfiguration consulConfiguration;

    @RequestMapping(value = "/readConsulConfig", method = RequestMethod.GET)
    @ApiOperation(value = "Make a GET request read the Consul Configuration",
            produces = "application/json", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The GET call is Successful"),
            @ApiResponse(code = 500, message = "The GET call is Failed"),
            @ApiResponse(code = 404, message = "The API could not be found")
    })
    public ResponseEntity<String> readConsulConfiguration() {
        return new ResponseEntity<String>(consulConfiguration.toString(), HttpStatus.OK);
    }
}
