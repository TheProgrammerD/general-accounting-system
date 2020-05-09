package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Cuenta;

public class BalanceGeneralController implements Initializable{
	
	ObservableList<Cuenta> listA = FXCollections.observableArrayList();
	
	private TableView<Cuenta> toShow;
	
	@FXML
	private BorderPane panel;
	
	@FXML
	private Button agregarCuenta;
	
	@FXML
	private Label valorActivosCorrientes;
	
	@FXML
	private Label valorPasivosCorrientes;
	
	@FXML
	private Label valorActivosNoCorrientes;
	
	@FXML
	private Label valorPasivosNocorrientes;
	
	
	
	@SuppressWarnings("unchecked")
	void init() {
		toShow = new TableView<Cuenta>();
		toShow.setMaxWidth(400);
		toShow.setMaxHeight(400);
		
		TableColumn<Cuenta, String> colCode = new TableColumn<>("Codigo");
		colCode.setCellValueFactory(new PropertyValueFactory<Cuenta, String>("codigo_c"));
		colCode.setPrefWidth(toShow.getMaxWidth()/4);
		
		TableColumn<Cuenta, String> colName = new TableColumn<>("Cuenta");
		colName.setCellValueFactory(new PropertyValueFactory<Cuenta, String>("nombre_c"));
		colName.setPrefWidth(toShow.getMaxWidth()/4);
		
		TableColumn<Cuenta, String> colTipo = new TableColumn<>("Tipo");
		colTipo.setCellValueFactory(new PropertyValueFactory<Cuenta, String>("tipo_c"));
		colTipo.setPrefWidth(toShow.getMaxWidth()/4);
		
		TableColumn<Cuenta, Integer> colVal = new TableColumn<>("Valor");
		colVal.setCellValueFactory(new PropertyValueFactory<Cuenta, Integer>("valor_c"));
		colVal.setPrefWidth(toShow.getMaxWidth()/4);
		toShow.getColumns().addAll(colCode, colName, colTipo,colVal);
		panel.setCenter(toShow);
		
		toShow.setItems(listA);
		panel.setCenter(toShow);
		
		agregarCuenta.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent t) {

				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/agregarCuenta.fxml"));
					Scene scene = new Scene(root);
					Stage stage = (Stage) ((Node) t.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.centerOnScreen();
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

	}



	
	
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
		
	}

}