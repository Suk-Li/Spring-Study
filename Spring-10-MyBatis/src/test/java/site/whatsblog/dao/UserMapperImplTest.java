package site.whatsblog.dao;

import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import site.whatsblog.pojo.User;

import java.util.List;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/6 15:31</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public class UserMapperImplTest extends TestCase {
    public void testFindAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapperImpl userMapper = applicationContext.getBean("userMapper", UserMapperImpl.class);
        List<User> all = userMapper.findAll();
        all.forEach(System.out::println);
    }
}