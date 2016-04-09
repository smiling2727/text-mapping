package pkg1;

import java.util.ArrayList;

public class DisList {
		private String[][] Dislist;
		private int listsize = 0;
		
		public DisList(){
			initializer();
		}
		
		public DisList(String[][] DisList,int size){
			this.Dislist = DisList;
			this.listsize = size;
		}
		
		public String[][] getList(){
			return Dislist;
		}
		
		public int getSize(){
			return listsize;
		}
		
		public void initializer(){
			String inputAdd = "/Users/Smiling/Desktop/Disaster_allocation/数据筛选结果（txt版）/data3-3test/disaster-map.txt";
			TextRead tr = new TextRead();
			ArrayList<String> list = tr.TextReader(inputAdd);
			String str;
			String[] strArray;
			Dislist = new String[list.size()][2];//初始化地名库
			listsize = list.size();//给Size赋值
			for(int i=0;i<list.size();i++){
				str = list.get(i);
				strArray = str.split("/");
				if(strArray.length>=2){
					Dislist[i][0] = strArray[0];
					Dislist[i][1] = strArray[1];
					//将地名库里的地名和序号对应着存入数组里
				}
				else System.out.println("Mapping document false,line length<2");
			}	
			System.out.println("Initializer done");
			
		}
		
		public void outList(){
			for(int i=0;i<listsize;i++){
				System.out .println("第"+i+"个灾害"+Dislist[i][0]);
				System.out .println("第"+i+"个灾害对应的字母"+Dislist[i][1]);
			}
		}



	}
