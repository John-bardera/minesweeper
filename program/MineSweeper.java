import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MineSweeper extends JFrame implements ActionListener{
  int num = 5; // 1辺
  int all_num = num*num;
  int btn_len = 60;
  int btn;
  JButton button[] = new JButton[all_num];
  JPanel p = new JPanel();
  ArrayList<Color> color = new ArrayList<Color>(Arrays.asList(Color.LIGHT_GRAY, Color.RED, Color.GREEN, Color.BLUE));

  public static void main(String args[]){
    MineSweeper frame = new MineSweeper("MineSweeper");
    frame.setVisible(true);

  }

  MineSweeper(String title){

    setTitle(title);
    setLocationRelativeTo(null);
    setSize(num*btn_len+10, num*btn_len+30);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DrawButton(num, all_num, btn_len);
    getContentPane().add(p, BorderLayout.CENTER);
  }

  void DrawButton(int x,int y,int z){
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