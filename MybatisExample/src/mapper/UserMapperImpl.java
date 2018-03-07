package mapper;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import po.User;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

	@Override
	public User fingUserById(int id) throws Exception {
		return this.getSqlSession().getMapper(UserMapper.class).fingUserById(id);
	}

}
