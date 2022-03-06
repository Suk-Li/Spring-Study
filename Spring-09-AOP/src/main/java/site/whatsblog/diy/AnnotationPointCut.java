package site.whatsblog.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * <strong>
 * description : 使用注解方式实现aop
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 17:45</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
// 声明式事务
@Aspect // 标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* site.whatsblog.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("========方法执行前========");
    }
    @After("execution(* site.whatsblog.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("========方法执行后========");
    }
    // 在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* site.whatsblog.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("========环绕前======");
        // 执行方法
        Signature signature = jp.getSignature();
        System.out.println("signature:"+signature);
        Object proceed = jp.proceed();
        System.out.println("========环绕后======");
        System.out.println(proceed);
    }
}
