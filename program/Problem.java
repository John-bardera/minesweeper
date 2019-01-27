import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class Problem{
  Warehouse table = new Warehouse();
  MineTable minetable;
  Draw draw;
  int limit = 60;
  Timer t = new Timer();
  int level;
  
  Problem(int level){
    setLevel(level);
  }

  void setLevel(int level){
    this.level = level;
    minetable = table.getTable(level); 
  }

  void start(int x, int y){
    draw = new Draw(x, y, t, level, this.minetable);
    t.schedule(new TimerDrawTask(), 0, 1000);
  }

  class TimerDrawTask extends TimerTask{

    @Override
    public void run(){
      limit -= 1;
      draw.drawTime(limit);
      if(limit == 0){
        t.cancel();
        new Popup(draw, false);
      }
    }
  }
}