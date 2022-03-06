package site.whatsblog.dao;


import org.apache.ibatis.annotations.Param;
import site.whatsblog.pojo.User;

import java.util.List;

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
    public int addUser(User user);
    public int deleteUser(@Param("id")int id);
}
