import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Start extends JLayeredPane implements ActionListener{
  JFrame frame = new JFrame();
  Problem problem;

  Start(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    ImageIcon icon = new ImageIcon("./akashi.png");
    JLabel label = new JLabel(icon);
    JButton button = new JButton("スタート");
    button.setActionCommand("start");
    button.addActionListener(this);

    label.setOpaque(true);
    label.setSize(500, 500);
    add(label);
    setLayer(label, DEFAULT_LAYER, 0);
    button.setBounds(200, 375, 100, 50);
    add(button);
    setLayer(button, PALETTE_LAYER, 100);
  }

  void gameStart(){
    frame.add(this);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setSize(500, 530);
    frame.setTitle("Minesweeper");
  }

  void gameStart(int x, int y){
    frame.add(this);
    frame.setLocation(x, y);
    frame.setVisible(true);
    frame.setSize(500, 530);
    frame.setTitle("Minesweeper");
  }

  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();

    if(cmd.equals("start")){
      int x = frame.getX();
      int y = frame.getY();
      frame.setVisible(false);
      frame.dispose();
      problem = new Problem(0);
      problem.start(x, y);
    }
  }
}