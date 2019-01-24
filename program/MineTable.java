import java.util.*;

class MineTable{
  int verticle, width;
  int[][][] table;
  ArrayList<Integer[]> hasNumberPoints = new ArrayList<>();
  int[][] surroundConfirmationTable = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};;

  MineTable(int verticle, int width, int[][] cells){
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
    this.table = new int[verticle + 2][][];

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
