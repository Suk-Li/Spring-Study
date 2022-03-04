package site.whatsblog.demo03;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 12:20</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象！
        handler.setRent(host);
        //这里的proxy就是动态生成的
        Rent proxy = (Rent) handler.getProxy();
        proxy.rent();
    }
}
