import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Thread;

class Draw extends JFrame implements ActionListener{
  MineTable minetable;
  int sides; // 辺の数
  int length = 500;
  int all_sides_num;
  int btn_len;
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
    btn_len = length/sides;

    setTitle(title);
    setLocationRelativeTo(null);
    setSize(length, length+65);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DrawButton(sides, all_sides_num, btn_len);
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(decide, BorderLayout.SOUTH);
    setVisible(true);
  }

  void DrawButton(int x,int y,int z){
    int btn = -1;
    p.setLayout(null);

    decide.addActionListener(this);
    decide.setActionCommand("decide");
    for(int i = 0; i < minetable.table[0].length;i++){ // 縦
      for(int j = 0;j < minetable.table[1].length;j++){ // 横
        if(minetable.table[i][j][0] != 11){ // 表示タイル
          btn += 1;
          if(minetable.table[i][j][0] != 10){
            button[btn] = new JButton(String.valueOf(minetable.table[i][j][0]));
            button[btn].setFont(new Font("MS ゴシック", Font.BOLD, (100/x)));
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
    decide.setForeground(Color.BLACK);

    if(cmd.equals("decide")){
      if(minetable.surround()){
        new Popup(this, true);
      }else{
        decide.setForeground(color.get(1));
      }
    }
    for(int i = 0;i < all_sides_num;i++){
      if(cmd.equals("a"+i)){
        int color_num = color.indexOf(button[i].getBackground());
        int next_color = (color_num+1)%4;
        if(color.get(next_color) == button[i].getForeground()){
          button[i].setForeground(color.get(4));
          button[i].setBackground(color.get(next_color));
        }else if(color.get(4) == button[i].getForeground()){
          button[i].setForeground(button[i].getBackground());
          button[i].setBackground(color.get(next_color));
        }else{
          button[i].setBackground(color.get(next_color));
        }
        minetable.table[(i/sides)+1][(i%sides)+1][2] = next_color;        
      }
    }
  }
}