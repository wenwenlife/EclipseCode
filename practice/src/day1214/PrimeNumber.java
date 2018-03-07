package day1214;

import java.util.Scanner;

public class PrimeNumber {
public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    System.out.println("请输入number:");
    int i =sc.nextInt();
		boolean result = panDuan(i);
		if (result == false) {
			System.out.println("你输入的不是素数");
		}
		if (result == true) {
			System.out.println("你输入的是素数");
		}
}

	public static boolean panDuan(int s) {
		boolean flag = false;
		if (s == 1) {
			flag = false;
		} else {
			for (int i = 2; i < Math.sqrt(s); i++) {
				if (s % i == 0) {
					flag = false;
				} else {
					flag = true;
				}
			}
		}
		return flag;
	
}
}
