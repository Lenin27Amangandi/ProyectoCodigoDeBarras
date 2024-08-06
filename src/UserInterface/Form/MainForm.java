package UserInterface.Form;

import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import UserInterface.Style;

public class MainForm extends JFrame {
    MenuPanel panelMenu = new MenuPanel();
    JPanel panelMain = new MainPanel();

    public MainForm(String titleApp) {
        customizeComponent(titleApp);
        panelMenu.buttonHome.addActionListener(e -> setPanel(new MainPanel()));
        panelMenu.buttonLogin.addActionListener(e -> setPanel(new LoginPanel()));
        panelMenu.buttonProducto.addActionListener(e -> setPanel(new ProductoPanel()));
        panelMenu.buttonLocalidad.addActionListener(e -> setPanel(new MainPanel()));
        // agregar
        panelMenu.buttonTest.addActionListener(e -> {Style.showMsgError("mensaje de error");});
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(panelMain);
        panelMain = formularioPanel;
        container.add(panelMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void customizeComponent(String titleApp) {
        setTitle(titleApp);
        setSize(930, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container.add(panelMenu, BorderLayout.WEST);
        container.add(panelMain, BorderLayout.CENTER);
        setVisible(true);
    }
}