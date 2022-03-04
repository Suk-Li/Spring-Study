package site.whatsblog.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 15:00</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
@Component
public class AfterLog implements AfterReturningAdvice {

    /**
     * @param method 要执行的目标对象方法
     * @param args 参数
     * @param target 目标对象
     * @throws Throwable 异常
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        assert target != null;
        System.out.println(target.getClass().getName()+"的"+method.getName()+"方法被执行了,并且返回了："+returnValue);
    }
}
