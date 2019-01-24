import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Popup extends JDialog implements ActionListener{
  Popup(JFrame frame, Boolean bool){
    super(frame);
    getContentPane().setLayout(new FlowLayout());
    Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
    int x = frame.getX()+(frame.getWidth()-200)/2;
    int y = frame.getY()+(frame.getHeight()-150)/2;
    setModal(true);

    if(bool){
      nextLevel();
    }else{
      finish();
    }
    setSize(200, 150);
    setLocation(x,y);
    setVisible(true);
  }

  public void nextLevel(){
    setTitle("レベルクリア");
    JLabel text = new JLabel("レベルクリアです。");
    JButton btn = new JButton("次のレベルへ");
    btn.addActionListener(this);
    btn.setActionCommand("next");
    getContentPane().add(text, BorderLayout.CENTER);
    getContentPane().add(btn, BorderLayout.CENTER);
  }

  public void finish(){
    setTitle("終了ポップアップ");
    JLabel text = new JLabel("制限時間になりました。");
    JButton btn = new JButton("終了");
    btn.addActionListener(this);
    btn.setActionCommand("finish");
    getContentPane().add(text, BorderLayout.CENTER);
    getContentPane().add(btn, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent e){
    String cmd;
    setVisible(true);
    cmd = e.getActionCommand();
    if(cmd.equals("finish")){
      setVisible(false);
    }
  }
}