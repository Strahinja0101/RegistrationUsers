package controller;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import model.SalesModel;

public class SalesController
{

    @FXML
    private ChoiceBox cbSpeed;

    @FXML
    private ChoiceBox cbInternetTraffic;

    @FXML
    private ChoiceBox cbContract;

    @FXML
    private TextField tfNameSurname;

    @FXML
    private TextField tfAddress;

    @FXML
    TableView<SalesModel> tabela = new TableView<>();

    ObservableList<SalesModel> salesList = FXCollections.observableArrayList();
    SalesModel model;

    public SalesController()
    {
    }

    private ObservableList<SalesModel> show() 
    {
	
	salesList = tabela.getItems();
	salesList.add(new SalesModel(Integer.parseInt(cbSpeed.getValue().toString()), "300", Integer.parseInt(cbContract.getValue().toString()), tfNameSurname.getText(), tfAddress.getText()));	
	tabela.setItems(salesList);
	return salesList;
    }

    @FXML
    private void initialize() 
    {
	model = new SalesModel();

	cbSpeed.getItems().addAll(2, 5, 10, 20, 50, 100);
	cbSpeed.setTooltip(new Tooltip("Select Internet Speed"));
	cbSpeed.valueProperty().bindBidirectional(model.speedProperty());

	cbInternetTraffic.getItems().addAll("1", "5", "10", "100", "Flat");	
	cbInternetTraffic.setTooltip(new Tooltip("Select Internet Traffic"));
	cbInternetTraffic.valueProperty().bindBidirectional(model.InternetProperty());

	cbContract.getItems().addAll(1, 2);
	cbContract.valueProperty().bindBidirectional(model.contractProperty());

	tfNameSurname.textProperty().bindBidirectional(model.nameSurnameProperty());
	tfAddress.textProperty().bindBidirectional(model.addressProperty());

	
    }

    @FXML
    private void deleteSell()
    {
        SalesModel selectedItem = tabela.getSelectionModel().getSelectedItem();
        tabela.getItems().remove(selectedItem);
        
    }

    @FXML
    private void insertSell()
    {
	if(model.check())
	    tabela.setItems(show());

	else
	{
	    StringBuilder errmsg = new StringBuilder();

	    ArrayList<String> errlist = model.errorsProperty().get();
	    for(String errList1 : errlist)
		errmsg.append(errList1);
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("ERROR");
	    alert.setHeaderText(null);
	    alert.setContentText(errmsg.toString());
	    alert.showAndWait();
	    errlist.clear();
	}

    }

    @FXML
    private void closeForm()
    {
	Platform.exit();

    }

}
