import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Thread;

class MineSweeper extends JFrame implements ActionListener{
  static Draw draw;
  int num = 5; // 1辺
  int all_num = num*num;
  int btn_len = 60;
  int btn;
  JButton button[] = new JButton[all_num];
  JButton decide = new JButton("決定");
  JLabel time = new JLabel();
  JPanel p = new JPanel();
  ArrayList<Color> color = new ArrayList<Color>(Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.GREEN, Color.BLUE));

  public static void main(String args[]){
    MineSweeper frame = new MineSweeper();
    frame.setMineSweeper("Minesweeper", 0); //Math.random()*3)
    for(int i = 60;i > 0;i--){
      draw.getTime(i);
    }
    new Finish(draw);
  }

  void setMineSweeper(String title, int level){
    Problem problem = new Problem(level);
    draw = new Draw(title, problem.minetable);
  }

  void getTime(int i){
    time.setHorizontalAlignment(JLabel.CENTER);
    time.setText("残り : "+String.valueOf(i)+"秒");
    getContentPane().add(time, BorderLayout.NORTH);
    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }


  void DrawButton(int x,int y,int z){
    p.setLayout(null);

    for(int i = 0;i < all_num;i++){
      btn = i;

      button[btn] = new JButton("2");
      button[btn].setBackground(color.get(0));
      button[btn].setBounds((i%5)*z, (i/5)*z, z, z);
      button[btn].addActionListener(this);
      button[btn].setActionCommand("a"+btn);
      p.add(button[btn]);
    
    }
  }

  public void actionPerformed(ActionEvent e){
    String cmd;
    cmd = e.getActionCommand();
    for(int i = 0;i < all_num;i++){
      if(cmd.equals("a"+i)){
        int color_num = color.indexOf(button[i].getBackground());
        button[i].setBackground(color.get((color_num+1)%4));
      }
    }
  }
}