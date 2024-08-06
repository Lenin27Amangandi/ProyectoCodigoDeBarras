package UserInterface.Form;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import UserInterface.Style;


public abstract class SplashScreenForm {
    private static JFrame frameSplash;
    private static JProgressBar splashLoading;
    private static ImageIcon iconSplash;
    private static JLabel labelSplash;

    public static void show() {
        System.out.println(Style.URL_SPLASH);
        iconSplash = new ImageIcon("src/UserInterface/Resources/Img/Splash.png");
        labelSplash = new JLabel(iconSplash);
        splashLoading = new JProgressBar(0, 100);

        splashLoading.setStringPainted(true);

        frameSplash = new JFrame();
        frameSplash.setUndecorated(true);
        frameSplash.getContentPane().add(labelSplash, BorderLayout.CENTER);
        frameSplash.add(splashLoading, BorderLayout.SOUTH);
        frameSplash.setSize(iconSplash.getIconWidth(), iconSplash.getIconHeight());
        frameSplash.setLocationRelativeTo(null);

        frameSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            splashLoading.setValue(i);
        }
        frameSplash.setVisible(false);

    }

}
