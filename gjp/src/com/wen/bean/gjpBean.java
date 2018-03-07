package com.wen.bean;

/*封装数据库信息 */
public class gjpBean {
	private int zw_id;// id
	private String zw_name;// 分类名称
	private String zw_zhangHu;// 账户名称
	private double zw_money;// 金额
	private String zw_createtime;// 创建时间
	private String zw_miaoshu;// 说明

	public int getZw_id() {
		return zw_id;
	}

	public void setZw_id(int zw_id) {
		this.zw_id = zw_id;
	}

	public String getZw_name() {
		return zw_name;
	}

	public void setZw_name(String zw_name) {
		this.zw_name = zw_name;
	}

	public String getZw_zhangHu() {
		return zw_zhangHu;
	}

	public void setZw_zhangHu(String zw_zhangHu) {
		this.zw_zhangHu = zw_zhangHu;
	}

	public double getZw_money() {
		return zw_money;
	}

	public void setZw_money(double zw_money) {
		this.zw_money = zw_money;
	}

	public String getZw_createtime() {
		return zw_createtime;
	}

	public void setZw_createtime(String zw_createtime) {
		this.zw_createtime = zw_createtime;
	}

	public String getZw_miaoshu() {
		return zw_miaoshu;
	}

	public void setZw_miaoshu(String zw_miaoshu) {
		this.zw_miaoshu = zw_miaoshu;
	}
}
