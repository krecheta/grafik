package app.view;

import app.model.JobPosition;
import app.model.JobPositionsManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ResourceBundle;

public class JobPositionsController implements Initializable {

    private JobPositionsManager jobPosManager;

    //***************** FXML controls *****************
    @FXML
    private TableView<JobPosition> jobPositionsTable;

    @FXML
    private TableColumn nameColumn;

    @FXML
    private TableColumn startTimeColumn;

    @FXML
    private TableColumn endTimeColumn;

    @FXML
    private TableColumn internalSymbolColumn;

    @FXML
    private TableColumn externalSymbolColumn;

    @FXML
    private TableColumn mondayColumn;

    @FXML
    private TableColumn tuesdayColumn;

    @FXML
    private TableColumn wednesdayColumn;

    @FXML
    private TableColumn thursdayColumn;

    @FXML
    private TableColumn fridayColumn;

    @FXML
    private TableColumn saturdayColumn;

    @FXML
    private TableColumn sundayColumn;

    @FXML
    private Button addJobPosButton;

    @FXML
    private Button removeJobPosButton;

    @FXML
    private Button nextWindowButton;

    @FXML
    private Button returnButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jobPosManager =  new JobPositionsManager();
        makeHeaderWrappable(startTimeColumn);
        makeHeaderWrappable(endTimeColumn);
        makeHeaderWrappable(internalSymbolColumn);
        makeHeaderWrappable(externalSymbolColumn);
    }

    @FXML
    void addJobPosButtonClicked(ActionEvent event) {

    }

    @FXML
    void nextWindowButtonClicked(ActionEvent event) {

    }

    @FXML
    void removeJobPosButtonClicked(ActionEvent event) {

    }

    @FXML
    void returnButtonClicked(ActionEvent event) {

    }

    /**
     * Makes column's name wrappable.
     * @param col - column
     */
    private void makeHeaderWrappable(TableColumn col) {
        Label label = new Label(col.getText());
        label.setStyle("-fx-padding: 1px;");
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);

        StackPane stack = new StackPane();
        stack.getChildren().add(label);
        stack.prefWidthProperty().bind(col.widthProperty().subtract(5));
        label.prefWidthProperty().bind(stack.prefWidthProperty());
        col.setText(null);
        col.setGraphic(stack);
    }
}
