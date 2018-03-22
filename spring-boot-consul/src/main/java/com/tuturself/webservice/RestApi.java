package com.tuturself.webservice;

import com.tuturself.model.ConsulConfiguration;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Consul Configuration APIs",
        description = "Rest APIs for Spring Boot Consul API",
        produces = "application/json")
public class RestApi {

    @Autowired
    private ConsulConfiguration consulConfiguration;

    @RequestMapping(value = "/consulConfig", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> readConsulConfiguration() {
        return new ResponseEntity<String>(consulConfiguration.toString(), HttpStatus.OK);
    }
}
