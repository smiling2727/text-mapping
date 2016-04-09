package pkg1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Execute {
	public void test1(){
		String inputAddress = "/Users/Smiling/Desktop/Disaster_allocation/Microblog utf8/test.txt";
		String OutputAddress = "/Users/Smiling/Desktop/Disaster_allocation/数据筛选结果（txt版）/data3-3test/data3-3test输出.txt";
		//String[][] dbArray = new String[200][200];
		 TextRead txtRead = new TextRead();
		 TextWrite txtWrite = new TextWrite();
		// TextSplit txtSpt = new TextSplit();
		 TextDeduplication txtDpc= new TextDeduplication();
		 ArrayList<String> olist,dlist;
		 olist = txtRead.TextReader(inputAddress);
		// System.out.println("Output oList:"+ olist);
		//System.out.println("olist行数:"+ olist.size());
		 dlist = txtDpc.deduplicate(olist);
		 //System.out.println("Output dList:"+ dlist);
		//System.out.println("dlist行数:"+ dlist.size());
		txtWrite.TextWriter(dlist,OutputAddress);//将dlist的值写回文本
		 //dbArray = txtSpt.txtSplit(dlist);
			//验证分词后结果
		 	//for (int m=0;m<txtSpt.rowCount;m++) {
				//for (int n=0; n<200;n++){
					//System.out.println("第" +m+"行"+ "第" +n+"列="+dbArray[m][n]);
				//} } 
	}

	public void test2(){
		String str = "你去吃@粑粑吧@";
		char[] lineC = str.toCharArray();
		int p=0,j = 0;
		while(j<lineC.length){
			if(lineC[j]=='@') { 
				p = 1;//有@
				System.out.println("@j="+j);
				break;
			}
			else{
				j++;
				p=0;
				System.out.println("j="+j);
			}
		}
		if(p==0){
		
		System.out.println(str);
		}
		 String outputAdd = "/Users/Smiling/Desktop/Disaster_allocation/数据筛选结果（txt版）/data2-output.txt";
		TextWrite tw = new TextWrite();
		 String str1 = "测试一下TextWrite里面的stringWriter方法";
		 tw.stringWriter(str1,outputAdd);
		 
	}
	public void callDeduplicate(){//这个是用来调用去重的函数
		String inputAddress = "/Users/Smiling/Desktop/Disaster_allocation/Fenci-utf8-去@后.txt";
		String OutputAddress = "/Users/Smiling/Desktop/Disaster_allocation/Fenci-utf8-去@去重.txt";
		TextRead txtRead = new TextRead();
		TextWrite txtWrite = new TextWrite();
		 TextDeduplication txtDpc= new TextDeduplication();
		 ArrayList<String> olist,dlist;
		 olist = txtRead.TextReader(inputAddress);
		 dlist = txtDpc.deduplicate(olist);
		txtWrite.TextWriter(dlist,OutputAddress);//将dlist的值写回文本
		 
	}
	
	public void callReaderWriter(){//调用读写文件，这个不用用
		String inputAddress = "输入文档的地址/文件名.txt";
		String OutputAddress = "输出文档的地址/文件名.txt.txt";
		TextRead tr = new TextRead();
		TextWrite tw = new TextWrite();
		ArrayList<String> list;
		list = tr.TextReader(inputAddress);
		tw.TextWriter(list, OutputAddress);
	}
	
	public void findAdd(){//***逐句分词处理,找到所有ICTCLAS分出来的地名
		//其实如果需要准确的地名库应该不要筛流感
		String inputAddress = "/Users/Smiling/Desktop/Disaster_allocation/data1/results_others.txt";
		String OutputAddress = "/Users/Smiling/Desktop/Disaster_allocation/data1/地名.txt";
		//String[][] dbArray = new String[200][200];
		String line;
		String[] strArray;
		TextRead tr = new TextRead();
		TextWrite tw = new TextWrite();
		TextSplit ts = new TextSplit();
		TextDeduplication td = new TextDeduplication();
		ArrayList<String> inputlist,addlist = new ArrayList<String>();
		Pattern patternAdd = Pattern.compile(".*/ns");//匹配所有ICTCLAS分出来的地名
		//Matcher match ;
		inputlist = tr.TextReader(inputAddress);
		for(int i=0;i<inputlist.size();i++){
			line = inputlist.get(i);//读取LIST的每一行
			strArray = ts.strSplit(line);//逐行分割
			for(int j=0;j<strArray.length;j++){//逐词遍历
				Matcher matcher = patternAdd.matcher(strArray[j]);
				if(matcher.matches() == true){//如果找到了地名,放在list里面
					strArray[j] = strArray[j].trim();
					addlist.add(strArray[j]);
				}
			}
		}
		addlist = td.deduplicate(addlist);
		tw.TextWriter(addlist,OutputAddress);//将addlist的值写回文本
	}
	
	public void deleteat(){//这个才是真正有用的删除含@的微博的method
		 String inputAddress = "/Users/Smiling/Desktop/Disaster_allocation/Fenci-utf8-测试.txt";
		// String[][] dbArray = new String[200][200];
		 String outputAdd = "/Users/Smiling/Desktop/Disaster_allocation/重新建一个.txt";
		 TextRead tr = new TextRead();
		 TextWrite tw = new TextWrite();
		 ArrayList<String> olist;
		 int p = 0;
		 olist = tr.TextReader(inputAddress);
		// System.out.println("输出oList:"+ olist);
		 System.out.println("olist行数:"+ olist.size());	 
		for(int i=0;i<olist.size();i++)
		 {
			String str = olist.get(i);
			char[] lineC = str.toCharArray();
			int j = 0;
			while(j<lineC.length){
				if(lineC[j]=='@') { 
					p = 1;//有@
					//System.out.println("@j="+j);
					break;}
				else{j++;p=0;}
			}
			if(p==0){
				tw.stringWriter(str,outputAdd);
				System.out.println("没有@所以输出这一句:"+olist.get(i));	
			}
		}
	}
	

public static void main(String[] args) {
 // TODO Auto-generated method stub
  Execute ex = new Execute();
  //ex.callDeduplicate();
  //ex.deleteat();
  ex.findAdd();
 // AddLexicon ad  = new AddLexicon();
 //HashMap<String, String>  map = ad.iniTable();
 //ad.outputMap(map);
  //DisList dl = new DisList();
  //dl.outList();
  //Matrix rm = new Matrix();
	
	//AddList al = new AddList();
	//al.initializer();
	//al.creatMainAddList();
	//al.outmainAddList();
	
  //int[][] m  = new int[5][4];
  //for(int i=0;i<5;i++)
  //for(int j=0;j<4;j++){
	//  m[i][j] = i+j;
  //}
  
  //TextWrite tw = new TextWrite();
  //String OutputAddress = "/Users/Smiling/Desktop/Disaster_allocation/草稿纸.txt";
  //tw.matrixWriter(m, OutputAddress);
  
  //Match ma = new Match();
  //String inputAddress = "/Users/Smiling/Desktop/Disaster_allocation/Fenci-utf8-去@去重.txt";
  //String inputAddress = "/Users/Smiling/Desktop/Disaster_allocation/data1/results_H7N9.txt";
  //String OutputAddress = "/Users/Smiling/Desktop/Disaster_allocation/data1/results_H7N9分词结果.txt";
  //ma.matchWord(inputAddress,OutputAddress);
  
  
}

}
