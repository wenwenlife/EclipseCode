package com.wen.service;

public interface Service {
 /**
  * 
  * @param inner 存钱人
  * @param outer 取钱人
  * @param money 钱数
  */
	public void  accountService(String inner,String outer,int money);
}
