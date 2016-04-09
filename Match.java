package pkg1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match {
	
	TextRead tr = new TextRead();
	TextWrite tw = new TextWrite();
	TextSplit ts = new TextSplit();
	//TextDeduplication td = new TextDeduplication();
	AddList al = new AddList();
	DisList dl = new DisList();
	Matrix mt = new Matrix();
	
	public void matchWord(String inputAddress,String OutputAddress){//***逐句分词处理,找到所有ICTCLAS分出来的地名
		//其实如果需要准确的地名库应该不要筛流感
		
		String line;
		//boolean tag=false;
		String[] sa,ssa;//strArray
		//int x = al.getSize()+1;
		int x = al.getaddCount()+1;
		int	y = dl.getSize()+1;
		mt.initializer(x, y);//初始化结果矩阵 x代表对应的地名编号数，y代表对应的灾害名编号数(Matrix类必须先初始化再调用)
		
		String[][] aku = al.getList();//地名库
		String[][] dku = dl.getList();//灾害库
		ArrayList<String> inputlist = new ArrayList<String>();	
		//ArrayList<String> addlist = new ArrayList<String>();//这句等会注释掉
		inputlist = tr.TextReader(inputAddress);
		for(int i=0;i<inputlist.size();i++){
			line = inputlist.get(i);//读取LIST的每一行
			sa = ts.strSplit(line);//逐行分割
			//ssa = sa; //这样写不行，这样写ssa跟着sa变化
			ssa = ts.strSplit(line);//ssa是sa的copy避免遍历的时候出现混乱
			for(int j=0;j<sa.length;j++){//逐词遍历，每个词都是sa[j]
				//循环逐个遍历两个库
				for(int m=0;m<al.getSize();m++){//遍历地名库，找到地名，地名为aku[m][0]
					String str1 = ".*"+aku[m][0]+".*";
					Pattern patternAdd = Pattern.compile(str1);
					Matcher matcher = patternAdd.matcher(sa[j]);//匹配所有地名库里的地名
					if(matcher.matches() == true){//如果找到了地名再去遍历灾害库
						for(int k=0;k<ssa.length;k++){//逐词遍历，每个词都是sa[j]
						for(int n=0;n<dl.getSize();n++){//遍历灾害库
							String str2 = ".*"+dku[n][0]+".*";
							Pattern patternDis = Pattern.compile(str2);
							Matcher matcher1 = patternDis.matcher(ssa[k]);//匹配所有地名库里的地名
							if (matcher1.matches()==true){//给代表地名和灾害的二维数组的对应位置+1
					         int x1 = Integer.parseInt(aku[m][1]);//将灾害编码强制转换为矩阵坐标（int）
					         int y1 = Integer.parseInt(dku[n][1]);
					         mt.matrix[x1][y1]++; //相当于match的count+1
					         String strtest1= "对应的文本"+aku[m][0]+dku[n][0];
					         String strtest2="对应的坐标	"+"x="+aku[m][1]+"	y="+dku[n][1];
					         String strtest3="mt.matrix["+x1+"]["+y1+"]="+mt.matrix[x1][y1];
					         String strtestadd = "/Users/Smiling/Desktop/Disaster_allocation/调试文件.txt";
					         tw.stringWriter(strtest1, strtestadd);
					         tw.stringWriter(strtest2, strtestadd);
					         tw.stringWriter(strtest3, strtestadd);
					         //System.out.println("对应的文本"+aku[m][0]+dku[n][0]);
					         //System.out.println("对应的坐标："+"x="+aku[m][1]+"y="+dku[n][1]);
					         //System.out.println("mt.matrix["+x1+"]["+y1+"]="+mt.matrix[x1][y1]);
							}
						}
						}
					}
				}
				
			}
		}
		String[][] smt = new String[x][y];
		for(int i =0;i<x;i++)
			for(int j=0;j<y;j++){
				smt[i][j] = String.valueOf(mt.matrix[i][j]);
			}
		al.creatMainAddList();
		String[][] mlist = al.getmainAddList();
		for(int i=1;i<x;i++){
			smt[i][0]=mlist[i][0];
		}
		smt[0][0] = "地名/编号";
		for(int i =0;i<dku.length;i++){
			smt[0][i+1] = dku[i][0];
			System.out.println("smt[0]["+i+"]="+smt[0][i]);
		}
		tw.straryWriter(smt, OutputAddress);
		//tw.matrixWriter(mt.matrix, OutputAddress);//将matrix的值写回文本
		//带title返回
		
	}
}
