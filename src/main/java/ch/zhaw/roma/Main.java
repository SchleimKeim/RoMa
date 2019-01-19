package ch.zhaw.roma;

import ch.zhaw.roma.interfaces.IRepositority;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/IntroView.fxml.fxml"));
            rootLayout = (BorderPane) loader.load();
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("RoHo - Royalty Management System");
            this.primaryStage.setScene(new Scene(rootLayout));
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
