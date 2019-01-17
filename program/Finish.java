import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Finish extends JDialog implements ActionListener{
  Finish(JFrame frame){
    super(frame);
    getContentPane().setLayout(new FlowLayout());
    Dimension display = Toolkit.getDefaultToolkit().getScreenSize();
    int x = frame.getX()+(frame.getWidth()-200)/2;
    int y = frame.getY()+(frame.getHeight()-150)/2;

    setModal(true);
    JLabel text = new JLabel("終了!!");
    JButton btn = new JButton("クリア");
    btn.addActionListener(this);
    getContentPane().add(text, BorderLayout.CENTER);
    getContentPane().add(btn, BorderLayout.CENTER);

    setTitle("終了ポップアップ");
    setSize(200, 150);
    setLocation(x,y);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e){
    setVisible(true);
  }
}