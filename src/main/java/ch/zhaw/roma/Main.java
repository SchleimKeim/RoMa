package ch.zhaw.roma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/IntroView.fxml"));
            primaryStage.setTitle("RoHo - Royalty Management System");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        catch(Exception ex) {
            System.out.print(ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
