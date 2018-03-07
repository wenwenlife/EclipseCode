package cn.strong.Factory;

/**
 * 
 * @Description: 实现打印和记录功能
 */
public class Printer implements OutPut {
	private static final int MAX_CHCHE_LINE = 20;
	private String[] printData = new String[(MAX_CHCHE_LINE)];
	private int dataNum = 0;

	/**
	 * 打印输入的数据
	 */
	@Override
	public void out() {
		while (dataNum > 0) {
			System.out.println("打印机打印: " + printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}

	
	@Override
	/**向队列中添加数据
	 * @param msg :向队列中添加的数据
	 */
	public void getData(String msg) {
		if (dataNum >= MAX_CHCHE_LINE) {
			System.out.println("输出队列已满,添加失败");
		} else {
			// 将数据添加到队列中,以保存数据加1
			printData[dataNum++] = msg;
		}
	}

}
