package site.whatsblog.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import site.whatsblog.pojo.Student;
import site.whatsblog.pojo.User;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/3 16:05</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class Tests {
    @Test
    public void testStudent() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testUser() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("UserBeans.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testStudentEquals() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student = applicationContext.getBean("student", Student.class);
        Student student2 = applicationContext.getBean("student", Student.class);
        System.out.println(student==student2);
    }
}
