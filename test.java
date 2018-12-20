public class test{
	public static void main(String args[]){
	mineTable table = mineTable(3, 3, [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0], [10, 0])
	}
}
class mineTable{
	mineTable(int verticle, int width, int[] ... cells){
		// cell[0]は周りに何個置くか
		// 0 ~ 10
		// 10は指定なし
		
		// cell[1]は置かれている色
		// 初期値は0(無色)
		// 0: 無色
		// 1: 赤色
		// 2: 緑色
		// 3: 青色
		int[][][] table = int[verticle][][]
		for(int i = 0; i < verticle; i++){
			table[i] = int[width][]
			for(int j = 0; j < width; j++)
				table[i][j] = [cells[i * width + j][0], cells[i * width + j][1]
		}
	}
	display(){

	}
}