package app.controller;

import app.model.Employee;
import app.model.EmployeesManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller for first window - EmployeesListView.
 */
public class EmployeesListController implements Initializable {

    private EmployeesManager empManager;

    //***************** FXML controls *****************
    @FXML
    private ListView<Employee> employeesList;

    @FXML
    private Button moveUpButton;

    @FXML
    private Button moveDownButton;

    @FXML
    private TextField newEmpTextField;

    @FXML
    private Button addEmpButton;

    @FXML
    private Button removeEmpButton;

    @FXML
    private Button nextWindowButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        empManager = new EmployeesManager();
        employeesList.setItems( empManager.getEmpList() );
        disableButtons(true);

        /**
         * Listener for changing selected item in list.
         * Disable buttons if there is no selected item.
         * Disable "move up" button if first item is selected.
         * Disable "move down" button if last item is selected.
         */
        employeesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Employee>() {
            @Override
            public void changed(ObservableValue<? extends Employee> observable, Employee oldValue, Employee newValue) {
                if(newValue != null) {
                    disableButtons(false);
                    if(newValue.equals(empManager.getEmpList().get(empManager.getEmpList().size()-1))) {
                        moveDownButton.setDisable(true);
                    }
                    if(newValue.equals(empManager.getEmpList().get(0))) {
                        moveUpButton.setDisable(true);
                    }
                } else {
                    disableButtons(true);
                }
            }
        });
    }

    /**
     * Listener for "Add employee" button.
     * @param event
     */
    @FXML
    void addEmpButtonOnAction(ActionEvent event) {
        empManager.addEmployee(new Employee(newEmpTextField.getText()));
        newEmpTextField.setText("");
        employeesList.getSelectionModel().select(null);
    }

    /**
     * Listener for move up and down buttons.
     * @param event
     */
    @FXML
    void moveButtonsOnAction(ActionEvent event) {
        Employee selectedEmp = employeesList.getSelectionModel().getSelectedItem();
        if(event.getSource().equals(moveUpButton)) {
            empManager.moveEmployeeOnList(selectedEmp, true);
        } else {
            empManager.moveEmployeeOnList(selectedEmp, false);
        }
        employeesList.getSelectionModel().select(selectedEmp);
    }

    /**
     * Listener for "remove employee" button
     * @param event
     */
    @FXML
    void removeEmpButtonOnAction(ActionEvent event) {
        empManager.removeEmployee(employeesList.getSelectionModel().getSelectedItem());
        employeesList.getSelectionModel().select(null);
    }

    /**
     * Listener for next window button.
     * Goes to new window.
     * @param event
     */
    @FXML
    void nextWindowButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/JobPositionsView.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            scene.getStylesheets().add(getClass().getResource("../view/JobPositionsView.css").toExternalForm());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            //przekazanie wartoœci do AddSignalController
            //loader.<NewSignalController>getController().initData(signalsManager, this);
            stage.show();

        } catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setHeaderText("Wystąpił błąd");
            alert.setTitle("Błąd");
            alert.setContentText("Spróbuj ponownie");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    /**
     * Disables buttons.
     * @param b
     */
    private void disableButtons(boolean b) {
        moveUpButton.setDisable(b);
        moveDownButton.setDisable(b);
        removeEmpButton.setDisable(b);
    }

}
