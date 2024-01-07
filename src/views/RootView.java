package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.RootController;
import utils.ColorConstants;

/**
 * Starting view of the application. This is the main frame passed to all other views.
 */
public class RootView extends JFrame {
    private RootController controller;
    private MenuView menuView;

    public RootView() {
        this.controller = new RootController(this);
        this.menuView = new MenuView();
        setJMenuBar(menuView);
        setTitle("Fantasy Great British Bake-Off League");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpAppDimensions();
        buildRoot();
    }

    public void setUpAppDimensions() {
        int width = 1000;
        int height = setHeight(width);
        setSize(width, height);
    }

    public void buildRoot() {
        // reset the entire window (for using more than once)
        getContentPane().removeAll();
        getContentPane().repaint();

        // defaults of root view
        setLayout(null);
        getContentPane().setBackground(ColorConstants.ROYAL_BLUE);
        addMenuButtons();
        addLogo();
        repaint();
    }

    public void addMenuButtons() {
        addEnterBtnAndEventListener(); // start
    }

    public void addEnterBtnAndEventListener() {
        JButton startButton = new JButton("Enter");
        startButton.setBackground(ColorConstants.RICH_BLACK);
        startButton.setForeground(ColorConstants.RED_CRAYOLA);
        startButton.setBounds(getWidth() / 3 - 150, getHeight() / 10, 100, 50);
        startButton.setFocusPainted(false);
        startButton.setOpaque(true);
        startButton.setBorderPainted(false);

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleEnterAction();
            }

        });
        add(startButton);
    }

    public void addLogo() {
        ImageIcon image = createImageIcon("../assets/images/logo.png", "GBBO Logo");
        JLabel imageLabel = new JLabel(image);
        int x = (getWidth() - image.getIconWidth()) / 2;
        int y = (getHeight() - image.getIconHeight()) / 2;
        imageLabel.setBounds(x, y, image.getIconWidth(), image.getIconHeight());
        add(imageLabel);
    }

    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public int setHeight(int width) {
        double height = width * (9.0 / 16.0);
        return (int) height;
    }

    /**
     * Clears the main window
     */
    public void clearView() {
        getContentPane().removeAll();
        getContentPane().repaint();
    }

    public void returnToRoot() {
        clearView();
        buildRoot();
    }
}
