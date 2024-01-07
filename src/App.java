
import database.DatabaseInit;
import views.RootView;
public class App {
    public static void main(String[] args) throws Exception {
        DatabaseInit.init();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RootView appIndex = new RootView();
                appIndex.setVisible(true);
            }
        });
    }
}
