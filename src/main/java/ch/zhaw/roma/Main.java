package ch.zhaw.roma;


import ch.zhaw.roma.controller.ManageAuthorsController;
import ch.zhaw.roma.model.royaltycalculation.AuthorCollection;
import ch.zhaw.roma.model.form.CreateData;
import ch.zhaw.roma.model.royaltycalculation.Author;
import ch.zhaw.roma.model.royaltycalculation.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private AnchorPane manageAuthors;

    public ObservableList<Book> getBooks() {
        return books;
    }

    public void setBooks(ObservableList<Book> books) {
        this.books = books;
    }

    public ObservableList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ObservableList<Author> authors) {
        this.authors = authors;
    }

    private ObservableList<Book> books = FXCollections.observableArrayList();
    private ObservableList<Author> authors = FXCollections.observableArrayList();




    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RoHo - Royalty Management System");

        createTestData();
        initRootLayOut();
        //arsch();
        manageAuthors();


    }

    public void arsch() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Test2.fxml"));
            arsch = (AnchorPane) loader.load();

            this.rootLayout.setCenter(arsch);

            //this.primaryStage.setScene(new Scene(arsch));
            //this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void initRootLayOut() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            this.primaryStage.setScene(new Scene(rootLayout));
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageAuthors() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/ManageAuthorsView.fxml"));
            manageAuthors = (AnchorPane) loader.load();

            this.rootLayout.setCenter(manageAuthors);

            ManageAuthorsController controller = (ManageAuthorsController) loader.getController();


            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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

    //public void loadAuthorAndBooks() {
    //  authorCollection = new ArrayList<>();
    //TODO: Load authors in list
    //}


    public void setAuthorCollection(AuthorCollection authorCollection) {
        this.authorCollection = authorCollection;
    }

    public void addToAuthorList(Author author) {
        authorCollection.addAuthor(author);
    }


    public void createTestData() {
        CreateData data = new CreateData();
        authorCollection = new AuthorCollection();
        authorCollection.setAuthorList(data.getAuthorCollection().getAuthorList());
    }

    public void removeAuthor(Author author) {
        authorCollection.removeAuthor(author);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
