package site.whatsblog.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import site.whatsblog.pojo.People;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 16:51</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class TestAutowired {
    @Test
    public void testEnvironment() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        People people = applicationContext.getBean("people", People.class);
        people.getDog1().say();
        people.getCat1().say();
    }
}
