import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Popup extends JDialog implements ActionListener{  
  int level;
  JFrame frame;

  Popup(JFrame frame){
    super(frame);
    this.frame = frame;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new FlowLayout());
    Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
    int x = frame.getX()+(frame.getWidth()-200)/2;
    int y = frame.getY()+(frame.getHeight()-150)/2;
    setModal(true);
    frame.setEnabled(true);

    finish();
    setSize(200, 150);
    setLocation(x,y);
    setVisible(true);
  }

  Popup(JFrame frame, int level){
    super(frame);
    this.level = level;
    this.frame = frame;
    getContentPane().setLayout(new FlowLayout());
    Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
    int x = frame.getX()+(frame.getWidth()-200)/2;
    int y = frame.getY()+(frame.getHeight()-150)/2;
    setModal(true);
    frame.setEnabled(true);

    if(level < 0){
      nextLevel();
      setSize(200, 150);
      setLocation(x,y);
      setVisible(true);
    }else{
      allClear();
      setSize(500, 560);
      setLocation(frame.getX(), frame.getY());
      setVisible(true);
    }
  }

  public void allClear(){
    setTitle("オールクリア");
    JPanel p = new JPanel();
    ImageIcon icon = new ImageIcon("./clear.png");
    JLabel label = new JLabel(icon);
    JButton button = new JButton("スタート画面へ");
    button.setActionCommand("clear");
    button.addActionListener(this);
    button.setAlignmentX(0.5f);
    label.setAlignmentX(0.5f);
    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

    p.add(label);
    p.add(button);
    getContentPane().add(p, BorderLayout.CENTER);  
  }

  public void nextLevel(){
    setTitle("レベルクリア");
    JPanel p = new JPanel();
    JLabel text = new JLabel("レベルクリアです!!");
    JButton btn = new JButton("次のレベルへ");
    btn.addActionListener(this);
    btn.setActionCommand("next");
    text.setAlignmentX(0.5f);
    btn.setAlignmentX(0.5f);
    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    
    p.add(text);
    p.add(btn);
    getContentPane().add(p, BorderLayout.CENTER);
  }

  public void finish(){
    setTitle("終了ポップアップ");
    JLabel text = new JLabel("制限時間になりました。");
    JButton btn = new JButton("終了");
    JPanel p = new JPanel();
    btn.addActionListener(this);
    btn.setActionCommand("finish");
    text.setAlignmentX(0.5f);
    btn.setAlignmentX(0.5f);
    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    
    p.add(text);
    p.add(btn);
    getContentPane().add(p, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent e){
    String cmd;
    int x = frame.getX();
    int y = frame.getY();
    setVisible(true);
    cmd = e.getActionCommand();
    if(cmd.equals("finish")){
      frame.setVisible(false);
      Start start = new Start();
      start.gameStart(x, y);
    }
    if(cmd.equals("next")){
      frame.setVisible(false);
      Problem problem = new Problem(level+1);
      problem.start(x, y);
    }
    if(cmd.equals("clear")){
      frame.setVisible(false);
      Start start = new Start();
      start.gameStart(x, y);      
    }
  }
}