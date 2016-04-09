package pkg1;

import java.util.ArrayList;

public class AddList {
	private String[][] addlist;//完整的地名库
	private int listsize = 0;//一共有多少个地名
	private int addCount = 0;//一共有多少个编号
	private String[][] mainAddList;//对于每一个编号唯一对应的一个主地名，主地名库
	
	public AddList(){
		initializer();
	}
	
	public AddList(String[][] addList,int size){
		this.addlist = addList;
		this.listsize = size;
	}
	
	public String[][] getList(){
		return addlist;
	}
	
	public String[][] getmainAddList(){
		return mainAddList;
	}
	
	public int getSize(){
		return listsize;
	}
	public int getaddCount(){
		return addCount;
	}
	
	public void initializer(){
		String inputAdd = "/Users/Smiling/Desktop/Disaster_allocation/数据筛选结果（txt版）/data3-3test/地名库map.txt";
		TextRead tr = new TextRead();
		ArrayList<String> list = tr.TextReader(inputAdd);//从TR读入的list
		String str;
		String[] strArray;
		//int count = 0;
		addlist = new String[list.size()][2];//初始化地名库
		listsize = list.size();//给Size赋值
		for(int i=0;i<list.size();i++){
			str = list.get(i);
			strArray = str.split("/");
			if(strArray.length>=2){
				addlist[i][0] = strArray[0];
				addlist[i][1] = strArray[1];
				//将地名库里的地名和序号对应着存入数组里
			if(Integer.parseInt(addlist[i][1])>=addCount) {
				addCount = Integer.parseInt(addlist[i][1]);
				}
			}
			else System.out.println("Mapping document false,line length<2");
		}	
		System.out.println("addCount = "+addCount);//addCount的个数
		
		System.out.println("Initializer done");
		
	}
	
	public void creatMainAddList(){
		mainAddList = new String[addCount+1][2];
		int tag = 0;
		for(int i=0;i<addlist.length;i++){
			if(Integer.parseInt(addlist[i][1])>tag){
				tag = Integer.parseInt(addlist[i][1]);
				mainAddList[tag][1] = addlist[i][1];
				mainAddList[tag][0] = addlist[i][0];
				System.out.println("tag="+tag);
				System.out.println("ma["+tag+"][0]"+mainAddList[tag][0]+"，ma["+tag+"][1]"+mainAddList[tag][1]);
			}
		}
	}
	
	public void outList(){
		for(int i=0;i<listsize;i++){
			System.out .println("第"+i+"个地名"+addlist[i][0]);
			System.out .println("第"+i+"个地名对应的数"+addlist[i][1]);
		}
	}
	public void outmainAddList(){
		for(int i=0;i<mainAddList.length;i++){
			System.out .println("第"+i+"个地名"+mainAddList[i][0]);
			System.out .println("第"+i+"个地名对应的数"+mainAddList[i][1]);
		}
	}



}
