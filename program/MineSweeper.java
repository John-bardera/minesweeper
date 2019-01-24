public class MineSweeper{
  static Draw draw;

  public static void main(String args[]){
    MineSweeper frame = new MineSweeper();
    frame.setMineSweeper("Minesweeper", 0); //Math.random()*3)
    for(int i = 60;i >= 0;i--){
      draw.getTime(i);
    }
    new Popup(draw, false);
  }

  void setMineSweeper(String title, int level){
    Problem problem = new Problem(level);
    draw = new Draw(title, problem.minetable);
  }
}