package site.whatsblog.dao;

import org.mybatis.spring.SqlSessionTemplate;
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
@Repository("userMapper")
public class UserMapperImpl implements UserMapper{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<User> findAll() {
        return sqlSession.getMapper(UserMapper.class).findAll();
    }
}
