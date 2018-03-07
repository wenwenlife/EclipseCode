package com.wen.core;

/**
 * 将java类型和数据库类型相互转换
 * @author 李文
 *2018年1月9日下午8:05:00
 */
public interface TypeConvertor {
  /**
   * 将java类型转为数据库类型
   * @param data 传入的数据
   * @return 数据库类型数据
   */
	public String javaToDatabase(String columnType);
	
	
	/**
	 * 将数据库类型转为java类型
	 * @param data 传入的数据
	 * @return java类型数据
	 */
	public String databaseToJava(String columnType);
}
