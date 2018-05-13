package com.web.dev.controller;

import com.web.dev.pojo.Book;
import com.web.dev.pojo.User;
import com.web.dev.service.BookService;
import com.web.dev.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/5/12/0012.
 * https://www.cnblogs.com/Sinte-Beuve/p/5730553.html
 * SSM:https://www.cnblogs.com/zyw-205520/p/4771253.html
 * 首先配置pom文件，引入需要的包
 * 然后配置web.xml文件
 * 随后配置spring-mvc.xml文件
 * 配置log4j.properties文件
 * 在pom中已经配置过jetty插件，edit configuration，使用maven自带的容器，配置jetty:run即可启动运行web工程
 */
@RestController
@RequestMapping("/test")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private BookService bookService;

    @Resource
    private UserService userService;

    @RequestMapping("/sayhello")
    public String sayHello(@RequestParam(name = "NAME",required = false) String name){
        logger.info("请求参数为：name={}",name);
        return "hello "+name;
    }

    @RequestMapping("/insertbook")
    public String insertBook(@RequestParam("name") String name) {
        Book book = new Book();
        book.setName("");
        book.setFormat("pdf");
        if (name != null && name.length() != 0) {
            book.setName(name);
            bookService.insertBook(book);
            Book res = bookService.findBookById(2);
            logger.info("#result={}",res);
        }
        return "success";
    }


    @RequestMapping("/addUser")
    public String addUser(@RequestParam("name") String name,@RequestParam("sex") int sex,
                          @RequestParam("age") int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        userService.insertUser(user);
        return "success";
    }

    @RequestMapping("/findUser")
    public String findUser(@RequestParam("mingzi") String name) {
        User user = userService.findUser(name);
        return user.toString();
    }
}
