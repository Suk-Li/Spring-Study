package site.whatsblog.diy;

import org.aspectj.lang.annotation.After;
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
}
