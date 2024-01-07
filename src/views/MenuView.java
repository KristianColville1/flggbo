package views;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.Dimension;

import utils.ColorConstants;

public class MenuView extends JMenuBar {
    private int preferredHeight;
    private JMenu fileMenu;
    private JMenu contestantsMenu;
    private JMenu leagueMenu;
    private JMenu predictionsMenu;
    private JMenu helpMenu;

    // -----------------------------------------------------------------------Constructor
    public MenuView() {
        setDefaults();
        addMenuButtons();
    }

    // -----------------------------------------------------------------------Defaults
    public void setDefaults() {
        this.preferredHeight = 30;
        UIManager.put("Menu.selectionBackground", ColorConstants.HONEYDEW);
        setBackground(ColorConstants.RICH_BLACK);
        setForeground(ColorConstants.ATOMIC_TANGERINE);
    }

    // -----------------------------------------------------------------------Menu
    // Button Setup
    public void addMenuButtons() {
        this.fileMenu = addFileMenu();
        this.contestantsMenu = addContestantsMenu();
        this.leagueMenu = addLeagueMenu();
        this.predictionsMenu = addPredictionsMenu();
        this.helpMenu = addHelpMenu();

        // Add menus to the menu bar and center
        add(Box.createHorizontalGlue());
        add(fileMenu);
        add(contestantsMenu);
        add(leagueMenu);
        add(predictionsMenu);
        add(helpMenu);
        add(Box.createHorizontalGlue());

        addCustomMenuStyling();
    }

    // Styling
    public void addCustomMenuStyling() {
        for (Component comp : this.getComponents()) {
            if (comp instanceof JMenu) {
                ((JMenu) comp).setForeground(ColorConstants.HONEYDEW);
            }
        }
    }

    // -----------------------------------------------------------------------Individual
    // Menu Buttons
    public JMenu addFileMenu() {
        JMenu fileMenu = new JMenu("File".toUpperCase());
        JMenuItem returnHome = new JMenuItem("Home");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(returnHome);
        fileMenu.add(exitItem);
        return fileMenu;
    }

    public JMenu addContestantsMenu() {
        JMenu contestantsMenu = new JMenu("Contestants".toUpperCase());
        JMenuItem addContestantItem = new JMenuItem("Add Contestant");
        JMenuItem viewContestantsItem = new JMenuItem("View Contestants");
        contestantsMenu.add(addContestantItem);
        contestantsMenu.add(viewContestantsItem);
        return contestantsMenu;
    }

    public JMenu addLeagueMenu() {
        JMenu leagueMenu = new JMenu("League".toUpperCase());
        JMenuItem createLeagueItem = new JMenuItem("Create League");
        JMenuItem viewLeagueItem = new JMenuItem("View League Standings");
        leagueMenu.add(createLeagueItem);
        leagueMenu.add(viewLeagueItem);
        return leagueMenu;
    }

    public JMenu addPredictionsMenu() {
        JMenu predictionsMenu = new JMenu("Predictions".toUpperCase());
        JMenuItem enterPredictionsItem = new JMenuItem("Enter Predictions");
        JMenuItem viewPredictionsItem = new JMenuItem("View Predictions");
        predictionsMenu.add(enterPredictionsItem);
        predictionsMenu.add(viewPredictionsItem);
        return predictionsMenu;
    }

    public JMenu addHelpMenu() {
        JMenu helpMenu = new JMenu("Help".toUpperCase());
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        return helpMenu;
    }

    // -----------------------------------------------------------------------Overrides
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        return new Dimension(size.width, preferredHeight);
    }
}
