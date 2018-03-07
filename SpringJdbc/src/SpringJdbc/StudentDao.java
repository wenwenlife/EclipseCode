package SpringJdbc;


public interface StudentDao {

	/**
	 * 向数据库插入数据
	 * @param name 学生姓名
	 * @param age  学生年龄
	 */
	public void create(String name,int age);

}
