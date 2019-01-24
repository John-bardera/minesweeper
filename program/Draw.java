import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Thread;

class Draw extends JFrame implements ActionListener{
  MineTable minetable = new MineTable();
  int sides; // 辺の数
  int all_sides_num;
  int btn_len = 60;
  JButton[] button;
  JButton decide = new JButton("決定");
  JLabel time = new JLabel();
  JPanel p = new JPanel();
  ArrayList<Color> color = new ArrayList<Color>(Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.GREEN, Color.BLUE));


  Draw(String title, MineTable table){
    sides = table.verticle;
    all_sides_num = sides*sides;
    JButton[] button = new JButton[all_sides_num];

    setTitle(title);
    setLocationRelativeTo(null);
    setSize(num*btn_len, num*btn_len+65);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DrawButton(num, all_num, btn_len);
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(decide, BorderLayout.SOUTH);
  }

  void DrawButton(int x,int y,int z){
    int btn
    p.setLayout(null);

    for(int i = 0;i < all_num;i++){
      btn = i;

      button[btn] = new JButton();
      button[btn].setBackground(color.get(0));
      button[btn].setBounds((i%5)*z, (i/5)*z, z, z);
      button[btn].addActionListener(this);
      button[btn].setActionCommand("a"+btn);
      p.add(button[btn]);
    
    }
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