import java.util.ArrayList;

public class test{
	public static void main(String args[]){
	mineTable table = new mineTable(3, 3, new int[][] {{1, 0, 0}, {10, 0, 0}, {5, 0, 0}, {10, 0, 0}, {3, 0, 0}, {10, 0, 0}, {2, 0, 0}, {10, 0, 0}, {9, 0, 0}});
	table.display();
	}
}
class mineTable{
	int verticle, width;
	int[][][] table;
	ArrayList<Intege[]r> has_number_point = new ArrayList<>();
	mineTable(int verticle, int width, int[][] cells){
		// cell[0]は周りに何個置くか
		// 0 ~ 11
		// 10は指定なし
		// 11はマスで無い
		
		// cell[1]は指定されている色
		// 固定値
		// cell[0]が10,11の時は0(無色)
		// 0: 無色
		// 1: 赤色
		// 2: 緑色
		// 3: 青色

		// cell[2]は現在の色
		// 初期値は0(無色)
		// 0: 無色
		// 1: 赤色
		// 2: 緑色
		// 3: 青色
		this.verticle = verticle;
		this.width = width;
		this.table = new int[verticle][][];
		for(int i = 0; i < verticle; i++){
			table[i] = new int[width][];
			for(int j = 0; j < width; j++)
				if(cells[i * width + j][0] < 10)
					this.has_number_point.add(new Integer[] {i, j});
				table[i][j] = new int[] {cells[i * width + j][0], cells[i * width + j][1], cells[i * width + j][2]};
		}
	}
	void display(){
		for(int i = 0; i < this.verticle; i++){
			for(int j = 0; j < this.width; j++){
				if(table[i][j][0] == 10)
					System.out.print("〼");
				else if(table[i][j][0] == 11)
					System.out.print("  ");
				else
					System.out.print(table[i][j][0] + " ");
			}
			System.out.println();
		}
	}
	int surround(int i, j){
		
	}
}
