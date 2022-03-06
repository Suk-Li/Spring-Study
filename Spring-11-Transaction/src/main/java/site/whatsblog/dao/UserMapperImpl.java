package site.whatsblog.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import site.whatsblog.pojo.User;

import java.util.List;

/**
 * <strong>
 * description :
 * </strong>
 * <br/>
 * <p>author : Suk-Lee</p>
 * <p>date : 2022/3/6 15:29</p>
 * <p>site : https://www.whatsblog.site/</p>
 */

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<User> findAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5, "小王", "12345");
        mapper.addUser(user);
        mapper.deleteUser(5);
        return mapper.findAll();
    }

    @Override
    public int addUser(User user) {
        return sqlSession.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return sqlSession.getMapper(UserMapper.class).deleteUser(id);
    }
}
