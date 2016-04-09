package pkg1;

import java.util.ArrayList;

public class TextSplit {
	public int rowCount;
	private String[] lineAry;
	//private int strLength;
	
	public String[][] txtSplit(ArrayList<String> list){//old
	String[][] dbArray = new String[200][200];
	int k = 0;//k为行数
	
	for (k=0;k<list.size();k++){
		String str = list.get(k);//从List里读1行
		String[] eachLine = str.split("   ");//把每一行的每个词分开
	
		for (int j=0; j<eachLine.length;j++){
			dbArray[k][j] = eachLine[j];
			}
		//System.out.println("每一行的长度 = " + eachLine.length);
		}
	rowCount = k;
	System.out.println("行数 = " +rowCount);
	return dbArray;
	}

	public String[] strSplit(String inputStr){//new
		lineAry = inputStr.split("   ");//lineAry是一个Str数组
		//strLength = eachline.length;//每一行有多少个词

	return lineAry;	
	}
	
	public String[] slashSplit(String inputStr){//这个函数没有测试过
		lineAry = inputStr.split("/");//lineAry是一个Str数组
		//strLength = eachline.length;//每一行有多少个词

	return lineAry;	
	}
}
