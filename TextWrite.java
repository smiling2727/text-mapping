package pkg1;
import java.io.*;
import java.util.ArrayList;
public class TextWrite {
	
public void TextWriter (ArrayList<String> list,String outputAdd){
	//String outputAdd = "/Users/Smiling/Desktop/Disaster_allocation/Microblog utf8/Output.txt";
	File textFile = new File(outputAdd);
	BufferedWriter myWriter;
	try {
		myWriter= new BufferedWriter(new FileWriter(textFile,true));
		int k = 0;
			while (k<list.size()){
				//System.out.println("list.get(k):"+list.get(k));
				myWriter.write(list.get(k));
				myWriter.newLine();
				k++;
		}
		myWriter.close();
		System.out.println("OK,输出完毕");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void charWriter(char[] a){//未调试，不过应该没问题
	String outputAdd = "/Users/Smiling/Desktop/Disaster_allocation/Microblog utf8/Output.txt";
	File textFile = new File(outputAdd);
	BufferedWriter myWriter;
	try {
		myWriter= new BufferedWriter(new FileWriter(textFile,true));
		myWriter.write(String.valueOf(a));
		myWriter.newLine();
		myWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public void stringWriter(String str,String outputAdd){
	//String outputAdd = "/Users/Smiling/Desktop/Disaster_allocation/Microblog utf8/Output.txt";
	File textFile = new File(outputAdd);
	BufferedWriter myWriter;
	try {
		myWriter= new BufferedWriter(new FileWriter(textFile,true));
		myWriter.write(str);
		myWriter.newLine();
		myWriter.close();
		System.out.println("OK,输出完毕");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

public void matrixWriter(int[][] mt,String outputAdd){
	File txtfile = new File(outputAdd);
	BufferedWriter writer;
	try {
	writer = new BufferedWriter(new FileWriter(txtfile,true));
	//int x = mt.length;
	for(int i=0;i<mt.length;i++){//mt = int[x][y], mt.length = x+1 
		int[] line = mt[i];//二维数组是数组的数组，相当于把int[i][0]-int[i][y]放在了line里
		String str = new String();
		for(int j=0;j<line.length;j++){//相当于把int[i][0]-int[i][y]放在了line里
		str = str +"	"+ String.valueOf(line[j]);//将一行int[]变成一行str
		}
		writer.write(str);
		writer.newLine();
		}
	writer.close();
	System.out.println("OK,输出完毕");
	}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void straryWriter(String[][] mt,String outputAdd){
	File txtfile = new File(outputAdd);
	BufferedWriter writer;
	try {
	writer = new BufferedWriter(new FileWriter(txtfile,true));
	//int x = mt.length;
	for(int i=0;i<mt.length;i++){//mt = int[x][y], mt.length = x+1 
		String[] line = mt[i];//二维数组是数组的数组，相当于把int[i][0]-int[i][y]放在了line里
		String str = new String();
		for(int j=0;j<line.length;j++){//相当于把int[i][0]-int[i][y]放在了line里
		str = str +"	"+ String.valueOf(line[j]);//将一行int[]变成一行str
		}
		writer.write(str);
		writer.newLine();
		}
	writer.close();
	System.out.println("OK,输出完毕");
	}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}


