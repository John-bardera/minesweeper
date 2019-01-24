public class Problem{
  Warehouse table = new Warehouse();
  MineTable minetable;

  Problem(int level){
    setLevel(level);
  }

  void setLevel(int level){
    minetable = table.getTable(level); 
  }
}