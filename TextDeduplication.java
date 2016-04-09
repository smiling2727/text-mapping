package pkg1;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class TextDeduplication {

public ArrayList<String> deduplicate(ArrayList<String> olist){
 Set<String> set = new TreeSet<String>();
ArrayList<String> dlist = new ArrayList<String>();
for(int i=0; i<olist.size();i++){
	set.add(olist.get(i));
	//System.out.println("olist.get"+i+":"+ olist.get(i));
 }
String[] array =(String[])set.toArray(new String[set.size()]);
//System.out.println("array.length:"+array.length);
for (int j=0;j<array.length;j++){
	dlist.add(array[j]);
	//System.out.println("dlist.get(j):"+dlist.get(j));
}	

	return dlist;
}
	
}
