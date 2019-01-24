import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Thread;

class Draw extends JFrame implements ActionListener{
  MineTable minetable;
  int sides; // 辺の数
  int all_sides_num;
  int btn_len = 60;
  JButton[] button;
  JButton decide = new JButton("決定");
  JLabel time = new JLabel();
  JPanel p = new JPanel();
  ArrayList<Color> color = new ArrayList<Color>(Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.GREEN, Color.BLUE, Color.WHITE));
  

  Draw(String title, MineTable table){
    minetable = table;
    sides = table.verticle;
    all_sides_num = sides*sides;
    button = new JButton[all_sides_num];

    setTitle(title);
    setLocationRelativeTo(null);
    setSize(sides*btn_len, sides*btn_len+65);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DrawButton(sides, all_sides_num, btn_len);
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(decide, BorderLayout.SOUTH);
    setVisible(true);
  }

  void DrawButton(int x,int y,int z){
    int btn = -1;
    p.setLayout(null);

    for(int i = 0; i < minetable.table[0].length;i++){ // 縦
      for(int j = 0;j < minetable.table[1].length;j++){ // 横
        if(minetable.table[i][j][0] != 11){ // 表示タイル
          btn += 1;
          if(minetable.table[i][j][0] != 10){
            button[btn] = new JButton(String.valueOf(minetable.table[i][j][0]));
            button[btn].setForeground(color.get(minetable.table[i][j][1]));
          }else{
            button[btn] = new JButton();
          }
          button[btn].setBackground(color.get(0));
          button[btn].setBounds((btn%x)*z, (btn/x)*z, z, z);
          button[btn].addActionListener(this);
          button[btn].setActionCommand("a"+btn);
          p.add(button[btn]);
        }
      }
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
    for(int i = 0;i < all_sides_num;i++){
      if(cmd.equals("a"+i)){
        int color_num = color.indexOf(button[i].getBackground());
        if(color.get((color_num+1)%4) == button[i].getForeground()){
          button[i].setForeground(color.get(4));
          button[i].setBackground(color.get((color_num+1)%4));
        }else if(color.get(4) == button[i].getForeground()){
          button[i].setForeground(button[i].getBackground());
          button[i].setBackground(color.get((color_num+1)%4));
        }else{
          button[i].setBackground(color.get((color_num+1)%4));
        }
      }
    }
  }
}