package methods_list;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Methods list factory: insert a Fully Qualified name of a class
 * and his methods will be showed by the application.
 * 
 * @author Rafael.Valle
 *
 */
public class MainBusca extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.show();
		primaryStage.setTitle("List Methods");
		Pane root = FXMLLoader.load(getClass().getResource("/Layout.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
