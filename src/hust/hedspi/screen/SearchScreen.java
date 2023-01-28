package hust.hedspi.screen;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SearchScreen extends JFrame {
	public SearchScreen() {
        super();

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Search Screen");
        this.setVisible(true);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("Search.fxml")
                    );
                    SearchController controller = new SearchController();
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
