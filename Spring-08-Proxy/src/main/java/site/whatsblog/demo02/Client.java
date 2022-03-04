package site.whatsblog.demo02;


import java.lang.reflect.Proxy;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 11:16</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();

        proxy.setUserService(userService);
        proxy.add();
    }
}
