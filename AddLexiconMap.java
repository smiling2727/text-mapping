package pkg1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class AddLexiconMap {
//Map addMap = new HashMap();
private HashMap<String,String> addMap = new HashMap<String,String>();

public AddLexiconMap(){
//等会把iniTable()写进构造方法里
	
}
public AddLexiconMap(HashMap<String,String> addMap){
	this.addMap = addMap;
}

public void setMap(HashMap<String, String> map){
	this.addMap = map;
}

public HashMap<String, String> getTable(){	
	return addMap;
}

public  HashMap<String, String>  iniTable(){
	String inputAdd = "/Users/Smiling/Desktop/Disaster_allocation/数据筛选结果（txt版）/data3-3test/地名库map.txt";
	HashMap<String,String> map = new HashMap<String,String>();
	TextRead tr = new TextRead();
	ArrayList<String> list = tr.TextReader(inputAdd);
	String str;
	String[] strArray;
	for(int i=0;i<list.size();i++){
		str = list.get(i);
		strArray = str.split("/");
		if(strArray.length>=2){
			map.put(strArray[0], strArray[1]);//将地名库里的地名和序号对应着存入hashmap里
		}
		else System.out.println("Mapping document false,line length<2");
	}	
	System.out.println("Initializer done");
	return map;
}

public void outputMap(HashMap<String,String> map){//用循环来遍历Hashmap
	Iterator<String> irt  = map.keySet().iterator();
	while(irt.hasNext()){
	//Map.Entry entry = (Map.Entry) irt.next(); //这三行报错
	//Object key = entry.getKey();
	//Object value = entry.getValue();
   String key = (String)irt.next();  
   System.out.println("key:" + key);  
   System.out.println("value:" + map.get(key));  
	}
	
	
}

}
