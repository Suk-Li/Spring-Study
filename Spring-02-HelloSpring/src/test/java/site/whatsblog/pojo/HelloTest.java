package site.whatsblog.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/2/21 14:52</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
class HelloTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml");
        Hello hello = context.getBean("hello", Hello.class);
        hello.show();
    }
}