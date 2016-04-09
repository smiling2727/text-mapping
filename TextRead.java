package pkg1;
import java.io.*;
import java.util.ArrayList;

public class TextRead {
	
public ArrayList<String> TextReader (String inputAdd){
	ArrayList<String> list = new ArrayList<String>();
	File textFile = new File(inputAdd);
	BufferedReader myreader;
	try {
		myreader = new BufferedReader(new FileReader(textFile));

	String line;
		while((line = myreader.readLine())!=null){//逐行读取文字
			line = line.trim();
			//System.out.println(line);
			list.add(line);			
		}
		myreader.close();
	} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	
}
}

