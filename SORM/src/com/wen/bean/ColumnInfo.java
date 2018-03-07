package com.wen.bean;

/**
 * 封装一个字段信息
 * 
 * @author 李文 2018年1月9日下午8:14:35
 *
 */
public class ColumnInfo {

	/**
	 * 字段名
	 */
	private String name;

	/**
	 * 字段类型
	 */
	private String dataType;

	/**
	 * 键类型 (0:普通键 ;1:主键;2:外键)
	 */
	private int keyType;

	public ColumnInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ColumnInfo(String name, String dataType, int keyType) {
		super();
		this.name = name;
		this.dataType = dataType;
		this.keyType = keyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getKeyType() {
		return keyType;
	}

	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}
}
