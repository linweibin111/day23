package com.dream.tcp02;

public class GoBang {

	//���ԣ�
	
	//���̳���
	private int len = 20;
	//��������
	private String[][] goBang = new String[len][len];
	//�±������
	private String[] nums = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
	//����
	private String add = "��";
	private String black = "��";
	private String white = "��";
	
	//ʹ�ô���飺��ʼ������
	{
		init();
		printGoBang();
	}
	
	//ʹ���޲ι��죺��ʼ������
//	public GoBang() {
//		System.out.println("���췽��");
//		init();
//		printGoBang();
//	}

	//����

	//��ʼ���������ݵķ���
	private void init(){
		for (int i = 0; i < goBang.length; i++) {//������
			for (int j = 0; j < goBang[i].length; j++) {//������
				if(i == len-1){//���һ��
					goBang[i][j] = nums[j];
				}else if(j == len-1){//ÿ�е����һ��
					goBang[i][j] = nums[i];
				}else{
					goBang[i][j] = add;
				}
				
			}
		}
	}
	
	//��ӡ���̵ķ���
	public void printGoBang(){
		for (String[] strings : goBang) {
			for (String str : strings) {
				System.out.print(str);
			}
			System.out.println();
		}
	}
	
	//�ж������Ƿ���������
	private boolean isIndexOutofGoBang(int x,int y){
		if(x < 0 || x > len-2 || y < 0 || y > len-2){
			return false;
		}
		return true;
	}
	
	//�ж��������Ƿ�������
	private boolean isGoBang(int x,int y){
		if(!goBang[x][y].equals(add)){
			return false;
		}
		return true;
	}
	
	/**
	 * ����
	 * @param x	����
	 * @param y ����
	 * @param bool �ڰ���
	 * @return -1�����곬�����̷�Χ 	-2����������������	1�����ӳɹ�
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
