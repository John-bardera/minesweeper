public class Problem{
  int difficult;
  int num, all_num, btn;
  int btn_len;
  ArrayList<Color> color = new ArrayList<Color>(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE));
  Warehouse table = new Warehouse();
  MineTable minetable = new MineTable();

  Problem(int level){
    setLevel(level);
  }

  void setLevel(int level){
    minetable = table.getTable(level); 
  }
}