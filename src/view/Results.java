package view;

import controller.ResultController;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import model.Activity;
import utility.Serialize;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class Results extends Tab {
    private FlowPane pane;
    private Label l1;
    private VBox vbox;
    private ListView listView;
    private HBox hbBtnSort,hbBtnSortAct,hbBtnSortPoint;
    private GridPane buttonsPane,buttonsBottomPane;
    private ArrayList<Activity> actList;
    private Button buttonSortDate, buttonSortAct, buttonSortPoint;

    public Results(){
        Serialize ser=new Serialize();
        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ tab▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        setClosable(false);
        setText("Results");

        pane = new FlowPane();
        setContent(pane);
        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ grid▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        buttonsPane=new GridPane();
        buttonsPane.setHgap(10);
        buttonsPane.setPadding(new Insets(0,0,2,5));

        buttonsBottomPane=new GridPane();
        buttonsBottomPane.setHgap(2);
        buttonsBottomPane.setPadding(new Insets(0,5,2,0));
//▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ table▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        l1 = new Label ("Results");

        listView = new ListView();
        listView.setPrefHeight(410);
        listView.setPrefWidth(550);
        listView.getItems().add("Activities to be displayed.");

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ buttons▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

        buttonSortDate=new Button("Sort by Date");
        hbBtnSort = new HBox(6);
        hbBtnSort.getChildren().add(buttonSortDate);
        buttonsPane.add(hbBtnSort, 0, 5);

        buttonSortAct=new Button("Sort by Activity");
        hbBtnSortAct = new HBox(6);
        hbBtnSortAct.getChildren().add(buttonSortAct);
        buttonsPane.add(hbBtnSortAct, 1, 5);

        buttonSortPoint=new Button("Sort by Points");
        hbBtnSortPoint = new HBox(6);
        hbBtnSortPoint.getChildren().add(buttonSortPoint);
        buttonsPane.add(hbBtnSortPoint, 2, 5);

        buttonSortDate.setOnAction(e->{
            actList=ResultController.sortByDate(actList,ser);

            if(actList==null || actList.size()==0){
                listView.getItems().clear();
                listView.getItems().add("Empty");
            }else {
                listView.getItems().clear();
                for (int i = 0; i < actList.size(); i++) {
                    listView.getItems().add(actList.get(i));
                }
            }
        });

        buttonSortAct.setOnAction(e->{
            actList=ResultController.sortByAct(actList,ser);

            if(actList==null || actList.size()==0){
                listView.getItems().clear();
                listView.getItems().add("Empty");
            }else {
                listView.getItems().clear();

                for (int i = 0; i < actList.size(); i++) {
                    listView.getItems().add(actList.get(i));
                }
            }
        });

        buttonSortPoint.setOnAction(e->{
            actList=ResultController.sortByPoints(actList,ser);

            if(actList==null || actList.size()==0){
                listView.getItems().clear();
                listView.getItems().add("Empty");
            }else{
                listView.getItems().clear();
                for (int i = 0; i < actList.size(); i++) {
                    listView.getItems().add(actList.get(i));
            }
            }
        });

        vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(l1,buttonsPane,listView,buttonsBottomPane);

        pane.getChildren().add(vbox);
        pane.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #196F3D, #0FFFF4); -fx-background-size: 600 550;");

    }

}
