import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JPanel {
    // 描画する画像
    private BufferedImage image;

    public Window(String path) {
        try {
            this.image = ImageIO.read(getClass().getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
            this.image = null;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        double imageWidth = image.getWidth();
        double imageHeight = image.getHeight();
        double panelWidth = this.getWidth();
        double panelHeight = this.getHeight();

        // 画像がコンポーネントの何倍の大きさか計算
        double sx = (panelWidth / imageWidth);
        double sy = (panelHeight / imageHeight);

        // スケーリング
        AffineTransform af = AffineTransform.getScaleInstance(sx, sy);
        g2D.drawImage(image, af, this);
    }

    // test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new ImagePanel("/kosen.png"));
        frame.setTitle("JPanelに画像を描画");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}