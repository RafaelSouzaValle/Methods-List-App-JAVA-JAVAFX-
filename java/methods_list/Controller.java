package methods_list;


import java.lang.reflect.Method;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Represents the search engine
 * 
 * @author Rafael.Valle
 *
 */
public class Controller {
	@FXML
	private TextField txtClassPath;
	
	@FXML
	private ListView<Method> listViewClasses;
	
	@FXML
	private Button btnSearch;
	
	/**
	 * Search engine
	 */
	public void onSearch() {
		try {
			
			if(!txtClassPath.getText().isEmpty()) {
				//call the class name typed 
				Class<?> clazz = Class.forName(txtClassPath.getText());
				
				//Array of class methods list
				Method[] methods = clazz.getDeclaredMethods();
				
				//Instantiate the list that load the methods
				ObservableList<Method> listMethods = FXCollections.observableArrayList(methods);
				
				//load the methods list on the listVIew
				listViewClasses.setItems(listMethods);
			} else {
				//Show alert pop-up window in the case of Class not founded
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Alert");
				alert.setHeaderText("Text Field is empty. Please, type the Class Name");
				alert.showAndWait();
			}
			
			
		} catch (ClassNotFoundException e) {
			//Show alert pop-up window in the case of Class not founded
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alert");
			alert.setHeaderText("Fail to load methods of the class \'"
			+ txtClassPath.getText() + "\'. Verify the Fully Qualified name and type again.");
			alert.showAndWait();
		}
	}
}
