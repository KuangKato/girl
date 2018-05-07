package com.kuang.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Set;

/**
 * SpringBoot Hello World
 */
@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

//    @Value("${together}")
//    private String together;

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @PostMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!!";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String demo1(){
        return cupSize+age;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String demo2(){
        return girlProperties.getCupSize()+girlProperties.getAge();
    }
//
//    @RequestMapping(value = "/test3",method = RequestMethod.GET)
//    public String demo3(){
//        StringBuilder sb = new StringBuilder();
//        for (Map<String, String> s : girlProperties.getList()) {
//            Set<Map.Entry<String, String>> entries = s.entrySet();
//            for (Map.Entry<String, String> entry : entries) {
//                sb.append(entry.getKey()+","+entry.getValue());
//            }
//        }
//        return sb.toString();
//    }
//
//    @RequestMapping(value = "/test4",method = RequestMethod.GET)
//    public String demo4(){
//        return together;
//    }

    /**
     * @Valid 验证关联的对象
     * @param bindingResult
     * @return
     */
    @PostMapping("/addgirl")
    public String girlAdd(@Valid @RequestBody Girl girl, BindingResult bindingResult){
        //判断
        if(bindingResult.hasErrors()){
            //如果有错误就进行打印
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return "error";
        }

        return "Success";
    }

}
