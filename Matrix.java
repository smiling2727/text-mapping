package pkg1;

public class Matrix {//调用matrix之前一定要先调用initializer

	public int[][] matrix = null;
	private int x ;//内层数组的大小
	private int y ;//外层数组的大小

	public Matrix(){
		
	}
	
	public Matrix(int [][] matrix){
		this.matrix = matrix;
	}
	
	public int getMatrix(int i,int j){
		return matrix[i][j];
	}
	
	public void setMatrix(int i,int j,int value) {
		//这个写的健壮性很差,尽量不要用
		matrix[i][j] = value;
	}
		
	public int getX() {//内层数组大小
		return x;
	}

	public int getY() {//外层数组大小
		return y;
	}


	public void initializer(int x, int y){
		this.x = x;
		this.y = y;
		matrix = new int[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				matrix[i][j]=0;
			}
		}
		System.out.println("matrix initializer done");
	}

	public void printTitle(){
		AddList al = new AddList();
		DisList dl = new DisList();
		for(int i=0;i<x;i++){
			//matrix[i][0]
		}
			for(int j=0;j<y;j++){
				//matrix[i][j]=0;
			}
		
		System.out.println("matrix printTitle done");
	}

}
