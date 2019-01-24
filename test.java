import java.util.ArrayList;

public class test{
	public static void main(String args[]){
	mineTable table = new mineTable(3, 3, new int[][] {{4, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}, {10, 0}});
	table.displayTable();
	System.out.println(table.surround());
	}
}
class mineTable{
	int verticle, width;
	int[][][] table;
	ArrayList<Integer[]> hasNumberPoints = new ArrayList<>();
	int[][] surroundConfirmationTable;
	mineTable(int verticle, int width, int[][] cells){
		// cell[0]は周りに何個置くか
		// 0 ~ 11
		// 10は指定なし
		// 11はマスで無い
		
		// cell[1]は指定されている色
		// 固定値
		// cell[0]が10,11の時は0(無色)
		// 10,11以外の場合は1~3が入る
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
		this.table = new int[verticle + 2][][];
    this.surroundConfirmationTable = new int[verticle*width][2];
    for(int i = 0;i < verticle*width;i++){
      if((i/verticle) == 0){
        surroundConfirmationTable[i][0] = -1;
      }else if((i/verticle) == (verticle-1)){
        surroundConfirmationTable[i][0] = 1;
      }else{
        surroundConfirmationTable[i][0] = 0;
      }
      if(i%width == 0){
        surroundConfirmationTable[i][1] = -1;
      }else if((i%width) ==  (width-1)){
        surroundConfirmationTable[i][1] = 1;
      }else{
        surroundConfirmationTable[i][1] = 0;
      }
    }

		for(int i = 0; i < verticle + 2; i++){
			table[i] = new int[width + 2][];
			for(int j = 0; j < width + 2; j++){
				if(i == 0 || i == verticle + 1 || j == 0 || j == width + 1){
					table[i][j] = new int[] {11, 0, 0};
					continue;
				}
				else{
					if(cells[(i - 1) * width + (j - 1)][0] < 10)
						this.hasNumberPoints.add(new Integer[] {i, j});
					table[i][j] = new int[] {cells[(i - 1) * width + (j - 1)][0], cells[(i - 1) * width + (j - 1)][1], 0};
				}
			}
		}
	}
	void displayTable(){
		for(int i = 0; i < this.verticle + 2; i++){
			for(int j = 0; j < this.width + 2; j++){
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
	boolean surround(){
		int clearedCount = 0;
		for(Integer[] tarCell: this.hasNumberPoints){
			int[] cellStatus = this.table[tarCell[0]][tarCell[1]];
			int markedCount = 0;
			int markNumber = cellStatus[0];
			int markColor = cellStatus[1];
			for(int[] confirmCell: this.surroundConfirmationTable){
				if(this.table[confirmCell[0] + tarCell[0]][confirmCell[1] + tarCell[1]][0] == 11)
					continue;
				else if(markColor == this.table[confirmCell[0] + tarCell[0]][confirmCell[1] + tarCell[1]][2])
					markedCount++;
			}
			if(markedCount == markNumber)
				clearedCount++;
		}
		if(clearedCount == this.hasNumberPoints.size())
			return true;
		return false;
	}
}
