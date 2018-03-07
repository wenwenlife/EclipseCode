package com.wen.dao;

/**
 * 
 * 
 * @Description: 与数据做交互获取数据
 */
public interface Dao {
	/**
	 * 存钱
	 * 
	 * @param inner
	 *            存钱人
	 * @param Money
	 *            存的金额
	 */
	public void lessMoney(String inner, int Money);

	/**
	 * 取钱
	 * 
	 * @param outer
	 *            取款人
	 * @param Money
	 *            取的金额
	 */
	public void addMoney(String outer, int Money);

}
