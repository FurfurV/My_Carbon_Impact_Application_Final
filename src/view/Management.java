package view;

import controller.Crasher;
import controller.ManagementController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Activity;
import view.managementView.BottomButtns;
import view.managementView.TopLabels;

import java.util.ArrayList;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class Management {
    private TextField weekTextField,pointsBox;
    private DatePicker datePicker;
    private Label message, total;
    private GridPane buttonsPane, buttonsBottomPane, grid, textFieldPad,tabsPane;
    private ListView listView;
    private ComboBox comboBox;
    private TabPane tabPane=new TabPane();
    private Tab tabMang;
    private Button btnAdd, btnRemove, btnList, btnSummary;
    private Button btnLoad, btnSave, btnCrash;
    private HBox hbBtnAdd, hbBtnRem, hbBtnList, hbBtnSummary;
    private HBox hbBtnLoad, hbBtnSave, hbBtnCrash;
    private VBox vBox;
    private Scene scene;

    private String style = "-fx-background-color: rgba(157, 63, 191, 0.6);";
    private int totalPoints=0;
    private ArrayList<Activity> actList=new ArrayList<>();

    private Results res=new Results();
    private TopLabels t=new TopLabels();
    private BottomButtns b=new BottomButtns();

    public Scene management(Stage primaryStage){

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ padding added ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        var spacer = new Region();
        var spacer2=new Region();
        spacer.setPrefWidth(40);
        spacer2.setPrefWidth(460);
        VBox.setVgrow(spacer, Priority.ALWAYS);
        VBox.setVgrow(spacer2, Priority.ALWAYS);

        buttonsPane=new GridPane();
        buttonsPane.setHgap(10);
        buttonsPane.setPadding(new Insets(0,0,2,5));

        buttonsBottomPane=new GridPane();
        buttonsBottomPane.setHgap(2);
        buttonsBottomPane.setPadding(new Insets(0,5,2,0));

        grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(5);
        grid.setPadding(new Insets(5, 5, 0, 5));

        textFieldPad=new GridPane();
        textFieldPad.setHgap(5);
        textFieldPad.setPadding(new Insets(5,5,5,5));

        tabsPane=new GridPane();
        tabsPane.setPadding(new Insets(5,5,0,5));

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ tabs▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        //tabIntro = new Tab();
        tabMang = new Tab("Activity management");
        tabMang.setClosable(false);

        tabPane.getTabs().add(new IntroTab());
        tabPane.getTabs().add(tabMang);
        tabPane.getTabs().add(res);

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ set tab size ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        tabPane.widthProperty().addListener((observable, oldValue, newValue) ->
        {
            tabPane.setTabMinWidth(tabPane.getWidth() / 4);
            tabPane.setTabMaxWidth(tabPane.getWidth() / 4);
        });

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ the top labels in the application▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        grid=t.topLabels(grid);

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ the top fields in the application▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        weekTextField = new TextField();
        grid.add(weekTextField, 1, 1);

        message=new Label();
        grid.add(message,3,1);

        datePicker = new DatePicker();
        grid.add(datePicker,1,2);

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Walking to work",
                        "Eating a 8oz steak",
                        "Cycling to shop",
                        "Driving to work",
                        "Vegetarian for a day",
                        "Cycling to work",
                        "Using the bus"
                );
        comboBox = new ComboBox(options);

        grid.add(comboBox, 1, 3);

        pointsBox = new TextField();
        grid.add(pointsBox, 1, 4);
        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ buttons under the app ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 3);

        total=new Label();

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ middle textfield▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        listView = new ListView();

        listView.setPrefHeight(300);
        listView.setPrefWidth(600);
        listView.getItems().add("Activities to be displayed.");

        textFieldPad.add(listView,0,0);

//▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ bottom buttons ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

        buttonsBottomPane=b.bottomButtonsView(buttonsBottomPane);

        btnLoad = new Button("Load");
        hbBtnLoad = new HBox(3);
        hbBtnLoad.getChildren().add(btnLoad);
        buttonsBottomPane.add(hbBtnLoad, 0, 0);

        btnSave = new Button("Save");
        hbBtnSave = new HBox(3);
        hbBtnSave.getChildren().add(btnSave);
        buttonsBottomPane.add(hbBtnSave, 1, 0);

        btnCrash = new Button("--- Danger ---App Crasher");
        hbBtnCrash = new HBox(3);
        hbBtnCrash.getChildren().add(btnCrash);
        btnCrash.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        buttonsBottomPane.add(hbBtnCrash, 2, 0);

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ button actions▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

        btnCrash.setOnAction(e ->{
            Crasher.crashApp(actList);
        });

        btnLoad.setOnAction(e-> {
            message.setText("Loaded!");

//            Serialize serial = new Serialize();
//            actList = serial.deserialize();
            actList=ManagementController.loadActs(actList);
            for (Activity a : actList) {
                System.out.println(a);
            }
        });

        b.buttonPressExit(primaryStage);

        btnSave.setOnAction(e->{
            ManagementController.saveActiv(actList);
            message.setText("Saved!");
        });

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚  top buttons▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

//        tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
//            System.err.println("changed");
//        });

        spacer.setPrefWidth(40);

        btnAdd = new Button("Add");
        hbBtnAdd = new HBox(3);
        hbBtnAdd.getChildren().add(btnAdd);
        buttonsPane.add(hbBtnAdd, 0, 5);

        btnRemove = new Button("Remove");
        hbBtnRem = new HBox(3);
        hbBtnRem.getChildren().add(btnRemove);
        buttonsPane.add(hbBtnRem, 1, 5);

        btnList = new Button("List");
        hbBtnList = new HBox(3);
        hbBtnList.getChildren().add(btnList);
        buttonsPane.add(hbBtnList, 2, 5);

        btnSummary = new Button("Summary");
        hbBtnSummary = new HBox(3);
        hbBtnSummary.getChildren().add(btnSummary);
        buttonsPane.add(hbBtnSummary, 3, 5);

        buttonsPane.add(spacer,4,5);

        buttonsPane.add(total, 5, 5);

        //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ top button actions▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚

        btnList.setOnAction(e -> {
            System.out.println(actList.toString());
            //ArrayList<model.Activity> actList;
            if (actList.size() == 0) {
                listView.getItems().clear();
                listView.getItems().add("Empty");
            } else {

                listView.getItems().clear();
                for (int i = 0; i < actList.size(); i++) {
                    listView.getItems().add(actList.get(i));
                }
            }
        });

        btnAdd.setOnAction(e ->{
            ManagementController.addActivity(actList,weekTextField.getText(),comboBox.getValue().toString(),datePicker.getValue(),pointsBox.getText());

            System.out.println(actList);
            message.setText("Added!");
        });

        btnRemove.setOnAction(e->{
            int index = listView.getSelectionModel().getSelectedIndex();
            System.out.println("removed at :"+index);

            ManagementController.removeAct(index,actList);

            listView.getItems().clear();
            for(int i=0;i<actList.size();i++){
                listView.getItems().add(actList.get(i));
            }
        });

        btnSummary.setOnAction(e->{
            totalPoints=ManagementController.addPoints(actList);
            total.setText("Total points: "+ totalPoints);
        });

//▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ scene▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
        grid.setGridLinesVisible(false);
        buttonsPane.setGridLinesVisible(false);
        buttonsBottomPane.setGridLinesVisible(false);
        textFieldPad.setGridLinesVisible(false);
        tabsPane.setGridLinesVisible(false);

        vBox = new VBox(5,grid,buttonsPane,textFieldPad,buttonsBottomPane);
        tabsPane.setStyle(style);
        vBox.setStyle(style);
        tabMang.setContent(vBox);

        scene = new Scene(tabPane, 600, 550);

        return scene;
    }
}
