package site.whatsblog.dao;

import site.whatsblog.pojo.User;

import java.util.List;
import java.util.UUID;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/6 14:56</p>
 * <p>site : https://www.whatsblog.site/</p>
 */
public interface UserMapper {
    public List<User> findAll();
}
