package com.wen.view;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import com.wen.bean.gjpBean;
import com.wen.service.gjpService;

public class gjpView {
	Scanner sc = new Scanner(System.in);

	public void run() throws Exception {
		boolean flog = true;

	System.out.println("---------------管家婆家庭记账软件---------------");
		System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
	System.out.println("请输入要操作的功能序号[1-5]:");
		int selectNumber1 = sc.nextInt();
		while (flog) {
			switch (selectNumber1) {
			case 1:
				addZhangWu();
				flog = false;
				break;
			case 2:
				editZhangWu();
				flog = false;
				break;
			case 3:
				deleteZhangWu();
				flog = false;
				break;
			case 4:
				selectZhangWu();
				flog = false;
				break;
			case 5:
				System.out.println("软件已退出,再见");
				flog = false;
				break;

			default:
				System.out.println("请输入正确的选择");
				flog = false;
				break;
			}

		}
}

	// 添加账务
	private void addZhangWu() throws SQLException {
		Scanner in = new Scanner(System.in);
		gjpBean zw = new gjpBean();
		System.out.print("请输入类别：");
		zw.setZw_name(in.next());
		System.out.print("请输入金额：");
		zw.setZw_money(in.nextDouble());
		System.out.print("请输入账户：");
		zw.setZw_zhangHu(in.next());
		System.out.print("请输入时间：");
		zw.setZw_createtime(in.next());
		System.out.print("请输入说明：");
		zw.setZw_miaoshu(in.next());
		System.out.println("操作" + gjpService.addZhangWu(zw));
	}

	// 编辑账务
	private void editZhangWu() {

	}

	// 删除账务
	private void deleteZhangWu() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个int值");
		int deleteZhangwu = gjpService.deleteZhangwu(sc.nextInt());
		if (deleteZhangwu > 0) {
			System.out.println("成功删除" + deleteZhangwu + "行");
		} else {
			System.out.println("操作失败");
		}
	}

	// 查询账务
	private void selectZhangWu() throws Exception {
		System.out.println("---------------管家婆家庭记账软件---------------");
		System.out.println("1.查询全部     2.按条件查询    3.返回上一级");
		int selectNumber2 = sc.nextInt();
		boolean flogSelect = true;
		while (flogSelect) {
			switch (selectNumber2) {
			case 1:
				selectAll();
				flogSelect = false;
				break;
			case 2:
				selectConditions();
				flogSelect = false;
				break;
			case 3:
				run();
				flogSelect = false;
				break;
			default:
				System.out.println("你输入的编号有误");
				flogSelect = false;
				break;

			}
		}
	}

	// 按条件查询
	private void selectConditions() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要查询的开始时间");
		String start = sc.next();
		System.out.println("请输入查询结束的时间");
		String end = sc.next();
		ResultSet zhangWuList = gjpService.selectCoditions(start, end);
		print(zhangWuList);

	}

	// 查询全部
	private void selectAll() throws Exception {
		ResultSet zhangWuList = gjpService.selectAll();
		print(zhangWuList);
	}


	private void print(ResultSet zhangWuList) throws SQLException {
		System.out.println("ID\t类别\t账户\t金额\t时间\t\t说明");
		ResultSetMetaData rsd = zhangWuList.getMetaData();
		int count = rsd.getColumnCount();
		while (zhangWuList.next()) {
		for (int i = 0; i < count; i++) {
				System.out.print(zhangWuList.getString(i + 1) + "\t");
		}
			System.out.println();
		}
	}
}
