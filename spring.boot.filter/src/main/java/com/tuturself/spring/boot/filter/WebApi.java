package com.tuturself.spring.boot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class WebApi {

    private static final Logger logger = LoggerFactory.getLogger(WebApi.class);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> doSomething(@RequestHeader(name = "remote_addr") String remoteAddress) {
        logger.debug("The Remote address added by WebFiler is :: {}", remoteAddress);
        ResponseEntity<Object> response = null;
        try {
            response = new ResponseEntity<Object>("SUCCESS", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
