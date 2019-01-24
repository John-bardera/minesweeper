class MineTable{
  int verticle, width;
  int[][][] table;
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
    this.table = new int[verticle][][];
    for(int i = 0; i < verticle; i++){
      table[i] = new int[width][];
      for(int j = 0; j < width; j++)
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
