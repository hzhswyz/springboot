package com.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    @RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
    String getUserByPost(@RequestParam(value = "userName") String userName){
        return "Hello " + userName;
    }

    @RequestMapping(value = "/getUserByJson",method = RequestMethod.POST)
    String getUserByJson(@RequestBody String data){
        logger.debug("data:"+data);
        return data;
    }

}