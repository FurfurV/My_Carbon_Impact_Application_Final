package view.managementView;

import controller.ManagementController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Activity;
import utility.Serialize;

import java.util.ArrayList;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class BottomButtns {
    private Button btnLoad, btnSave, btnExit;
    private HBox hbBtnLoad, hbBtnSave, hbBtnExit;
//    private Serialize serial = new Serialize();

    public GridPane bottomButtonsView( GridPane buttonsBottomPane){
        var spacer2=new Region();
        spacer2.setPrefWidth(410);

        buttonsBottomPane.add(spacer2,2,0);

        btnExit = new Button("Exit");
        hbBtnExit = new HBox(3);
        hbBtnExit.getChildren().add(btnExit);
        buttonsBottomPane.add(hbBtnExit,3,0);


        return buttonsBottomPane;
    }

    public void buttonPressExit(Stage primaryStage) {
        btnExit.setOnAction(e -> {
            primaryStage.close();
        });
    }

}
