package day1213;

/**
 * @author 李文 2017年12月14日上午9:02:51
 * 
 */
public class Program {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(shuMu(n));
	}

	public static int shuMu(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return shuMu(n - 1) + shuMu(n - 2);

		}
	}
}
