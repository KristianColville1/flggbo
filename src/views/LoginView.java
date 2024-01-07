package views;

import javax.swing.JButton;
import javax.swing.JFrame;

import utils.ColorConstants;

public class LoginView {
    private JFrame frame;
    private Runnable returnToRootCallback;

    public LoginView(JFrame frame, Runnable returnToRootCallback) {
        this.frame = frame;
        this.returnToRootCallback = returnToRootCallback;
        buildLoginView();
    }

    private void buildLoginView() {
        
        JButton returnButton = new JButton("Return to Root");
        returnButton.setBackground(ColorConstants.RICH_BLACK);
        returnButton.setForeground(ColorConstants.RED_CRAYOLA);
        returnButton.setBounds(frame.getWidth() / 3 - 150, frame.getHeight() / 10, 100, 50);
        returnButton.setFocusPainted(false);
        returnButton.setOpaque(true);
        returnButton.setBorderPainted(false);
        returnButton.addActionListener(e -> returnToRootCallback.run());
        frame.add(returnButton);

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
}
