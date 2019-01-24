package ch.zhaw.roma;

<<<<<<< HEAD
import ch.zhaw.roma.controller.ManageAuthorsController;
import ch.zhaw.roma.helpers.AuthorCollection;
import ch.zhaw.roma.model.royaltycalculation.Author;
=======
>>>>>>> db6f11875fec7e9639f1f03d915da197256ed90b
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


    private Stage primaryStage;
    private BorderPane rootLayout;
    private AuthorCollection authorCollection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/IntroView.fxml"));
            rootLayout = (BorderPane) loader.load();
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("RoHo - Royalty Management System");
            this.primaryStage.setScene(new Scene(rootLayout));
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageAuthors() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ManageAuthorsView.fxml"));
            AnchorPane manageAuthors = (AnchorPane) loader.load();
            this.rootLayout.setCenter((manageAuthors));
            //ManageAuthorsController controller = (ManageAuthorsController) loader.getController();
            //controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD

    //public void loadAuthorAndBooks() {
    //  authorCollection = new ArrayList<>();
    //TODO: Load authors in list
    //}

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public AuthorCollection getAuthorCollection() {
        return authorCollection;
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
    //public void loadAuthorAndBooks() {
    //  authorCollection = new ArrayList<>();
    //TODO: Load authors in list
    //}

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public AuthorCollection getAuthorCollection() {
        return authorCollection;
    }

<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    public void setAuthorCollection(AuthorCollection authorCollection) {
        this.authorCollection = authorCollection;
    }

    public void addToAuthorList(Author author) {
        authorCollection.addAuthor(author);
    }




    public static void main(String[] args) {
        launch(args);
    }
=======
>>>>>>> db6f11875fec7e9639f1f03d915da197256ed90b
}
