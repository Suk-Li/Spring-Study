package site.whatsblog.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <strong>
 * description : 用这个类自动生成代理类
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 12:06</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class ProxyInvocationHandler implements InvocationHandler {

    //接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //处理代理实例并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理类的本质，就是反射机制的实现
        System.out.println(method.getName()+"方法运行了！");
        return method.invoke(target, args);
    }

}
