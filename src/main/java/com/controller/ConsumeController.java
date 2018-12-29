package com.controller;

import com.javabean.OrderBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
public class ConsumeController {
    private RestTemplate restTemplate = new RestTemplate();
    private Logger logger = LoggerFactory.getLogger(ConsumeController.class);

    @RequestMapping(value = "/template/detail")
    @ResponseBody
    public String createProducts(@RequestBody OrderBean orderBean) {
        //logger.info("/template/detail"+orderBean.getMoney());
        //logger.info(orderBean.getDate().toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        HttpEntity<OrderBean> entity = new HttpEntity<>(orderBean,headers);
        return restTemplate.exchange(
                "http://localhost/hzh/detail", HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/detail")
    public ResponseEntity<OrderBean> create(@RequestBody OrderBean orderBean) {
        //logger.info("/detail"+orderBean.getMoney());
        //logger.info(orderBean.getDate().toString());
        return new ResponseEntity<>(orderBean,HttpStatus.OK);
    }






}
