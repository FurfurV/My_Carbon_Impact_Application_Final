package view.managementView;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Mar 2020
 */
public class TopLabels {
    private Label week, date, activity, points;

    public GridPane topLabels(GridPane grid){
        var spacer = new Region();
        spacer.setPrefWidth(40);

        week = new Label("Week ");
        grid.add(week, 0, 1);

        grid.add(spacer,2,1);

        date = new Label("Date ");
        grid.add(date, 0, 2);

        activity = new Label("Activity ");
        grid.add(activity, 0, 3);

        points = new Label("Points -10 +10 ");
        grid.add(points, 0, 4);

        return grid;

    }
}
