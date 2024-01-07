package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Component;
import java.awt.Dimension;

import utils.ColorConstants;

public class MenuView extends JMenuBar {
    private int preferredHeight;

    public MenuView() {
        setDefaults();
        addMenuButtons();
    }

    public void setDefaults() {
        this.preferredHeight = 40;
        setBackground(ColorConstants.RICH_BLACK);
        setForeground(ColorConstants.ATOMIC_TANGERINE);
    }

    public void addMenuButtons() {
        JMenu fileMenu = new JMenu("File".toUpperCase());
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        // Contestants menu
        JMenu contestantsMenu = new JMenu("Contestants".toUpperCase());
        JMenuItem addContestantItem = new JMenuItem("Add Contestant");
        JMenuItem viewContestantsItem = new JMenuItem("View Contestants");
        contestantsMenu.add(addContestantItem);
        contestantsMenu.add(viewContestantsItem);

        // League menu
        JMenu leagueMenu = new JMenu("League".toUpperCase());
        JMenuItem createLeagueItem = new JMenuItem("Create League");
        JMenuItem viewLeagueItem = new JMenuItem("View League Standings");
        leagueMenu.add(createLeagueItem);
        leagueMenu.add(viewLeagueItem);

        // Predictions menu
        JMenu predictionsMenu = new JMenu("Predictions".toUpperCase());
        JMenuItem enterPredictionsItem = new JMenuItem("Enter Predictions");
        JMenuItem viewPredictionsItem = new JMenuItem("View Predictions");
        predictionsMenu.add(enterPredictionsItem);
        predictionsMenu.add(viewPredictionsItem);

        // Help menu
        JMenu helpMenu = new JMenu("Help".toUpperCase());
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        // Add menus to the menu bar
        add(fileMenu);
        add(contestantsMenu);
        add(leagueMenu);
        add(predictionsMenu);
        add(helpMenu);

        for (Component comp : this.getComponents()) {
            if (comp instanceof JMenu) {
                ((JMenu) comp).setForeground(ColorConstants.HONEYDEW);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        return new Dimension(size.width, preferredHeight);
    }
}
