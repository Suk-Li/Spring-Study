package site.whatsblog.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import site.whatsblog.config.AppConfig;
import site.whatsblog.pojo.User;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 17:54</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class AppTest {
    @Test
    public void testApp() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = applicationContext.getBean("getUser", User.class);
        System.out.println(user);
    }
}
