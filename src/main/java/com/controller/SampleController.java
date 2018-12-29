package com.controller;

import com.exception.NotfoundException;
import com.javabean.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @ResponseBody
    @RequestMapping("/home")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/")
    public String index() {
        return "/index.html";
    }

    //SpringBoot 默认是无法使用矩阵变量绑定参数的。需要覆盖WebMvcConfigurer中的configurePathMatch方法。
    //http://localhost/hzh/showbean/id100/infoschool=crk;grade=2015;major=jsj;age=22?sex=男
    @RequestMapping("/showbean/id{id}/info{schoolinfo}")
    public ResponseEntity<UserBean> showbean(@RequestBody UserBean userBean,
                         @RequestParam("sex") String sex,
                         @PathVariable("id") String id,
                         @MatrixVariable(pathVar = "schoolinfo",value="school",required = false) String school,
                         @MatrixVariable(pathVar = "schoolinfo",value="age",required = false) int age,
                         @MatrixVariable(pathVar = "schoolinfo",value="grade",required = false) int grade,
                         @MatrixVariable(pathVar = "schoolinfo",value="major",required = false) String major) {
        userBean.setSchool(school);
        userBean.setSex(sex);
        userBean.setId(id);
        userBean.setGrade(grade);
        userBean.setMajor(major);
        userBean.setAge(age);
        log.info("school:"+userBean.getSchool());
        log.info("grade:"+userBean.getGrade());
        log.info("major:"+userBean.getMajor());
        log.info("name:"+userBean.getName());
        log.info("age:"+userBean.getAge());
        log.info("id:"+id);
        return  new ResponseEntity<>(userBean,HttpStatus.OK);
    }

    @RequestMapping(value = "/users")
    public ResponseEntity<Collection<UserBean>> getProduct(HttpEntity<String> entity) {
        log.info("ContentType:"+entity.getHeaders().getContentType());
        for(MediaType mediaType:entity.getHeaders().getAccept())
            log.info("Accept:"+mediaType);
        Map<String,UserBean> productRepo = new HashMap<>();
        UserBean userBean1 = new UserBean();
        userBean1.setName("HZH1");
        UserBean userBean2 = new UserBean();
        userBean2.setName("HZH2");
        UserBean userBean3 = new UserBean();
        userBean3.setName("HZH3");
        UserBean userBean4 = new UserBean();
        userBean4.setName("HZH4");
        productRepo.put("1",userBean1);
        productRepo.put("2",userBean2);
        productRepo.put("3",userBean3);
        productRepo.put("4",userBean4);
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createException", method = RequestMethod.GET)
    public ResponseEntity<Object> createException() {
        throw new NotfoundException();
    }


}