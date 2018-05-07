package com.kuang.girl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    //创建日志
    private static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //配置切入的方法
    @Pointcut("execution(public * com.kuang.girl.HelloController.*(..))")
    public void log(){}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获得请求参数
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        //打印url
        logger.info("url={}",request.getRequestURL());

        //打印method
        logger.info("method={}",request.getMethod());

        //打印ip
        logger.info("ip={}",request.getRemoteAddr());

        //打印类方法 获取类名和类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //打印参数
        logger.info("args={}",joinPoint.getArgs());
    }

    /**
     * 后置通知
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfter(Object object){
        //打印响应的数据
        logger.info("response={}",object.toString());
    }

}
