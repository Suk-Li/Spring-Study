package site.whatsblog.service;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/4 14:58</p>
 * <p>site : https://www.whatsblog.site/</p>
 */

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("UserService")
public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("add...");
    }

    @Override
    public void delete() {
        System.out.println("delete...");
    }

    @Override
    public void update() {
        System.out.println("update...");
    }

    @Override
    public void query() {
        System.out.println("query...");
    }
}
