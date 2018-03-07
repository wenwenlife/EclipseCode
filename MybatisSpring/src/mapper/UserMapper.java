package mapper;

import po.User;

/**
 * 
 * 
 * @Description: 操作数据库接口
 */
public interface UserMapper {

	public User fingUserById(int id) throws Exception;
}
