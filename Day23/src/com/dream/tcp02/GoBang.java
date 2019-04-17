package com.dream.tcp02;

public class GoBang {

	//属性：
	
	//棋盘长度
	private int len = 20;
	//棋盘容器
	private String[][] goBang = new String[len][len];
	//下标的容器
	private String[] nums = {"⒈","⒉","⒊","⒋","⒌","⒍","⒎","⒏","⒐","⒑","⒒","⒓","⒔","⒕","⒖","⒗","⒘","⒙","⒚","⒛"};
	//符号
	private String add = "╋";
	private String black = "■";
	private String white = "○";
	
	//使用代码块：初始化数据
	{
		init();
		printGoBang();
	}
	
	//使用无参构造：初始化数据
//	public GoBang() {
//		System.out.println("构造方法");
//		init();
//		printGoBang();
//	}

	//方法

	//初始化棋盘数据的方法
	private void init(){
		for (int i = 0; i < goBang.length; i++) {//控制行
			for (int j = 0; j < goBang[i].length; j++) {//控制列
				if(i == len-1){//最后一行
					goBang[i][j] = nums[j];
				}else if(j == len-1){//每行的最后一列
					goBang[i][j] = nums[i];
				}else{
					goBang[i][j] = add;
				}
				
			}
		}
	}
	
	//打印棋盘的方法
	public void printGoBang(){
		for (String[] strings : goBang) {
			for (String str : strings) {
				System.out.print(str);
			}
			System.out.println();
		}
	}
	
	//判断坐标是否在棋盘内
	private boolean isIndexOutofGoBang(int x,int y){
		if(x < 0 || x > len-2 || y < 0 || y > len-2){
			return false;
		}
		return true;
	}
	
	//判断坐标上是否有棋子
	private boolean isGoBang(int x,int y){
		if(!goBang[x][y].equals(add)){
			return false;
		}
		return true;
	}
	
	/**
	 * 落子
	 * @param x	坐标
	 * @param y 坐标
	 * @param bool 黑白子
	 * @return -1：坐标超出棋盘范围 	-2：坐标上已有棋子	1：落子成功
	 */
	public int play(int x,int y,boolean bool){
		
		if(!isIndexOutofGoBang(x, y)){
			return -1;
		}
		
		if(!isGoBang(x, y)){
			return -2;
		}
		
		goBang[x][y] = (bool)?black:white;
		return 1;
	}
}
