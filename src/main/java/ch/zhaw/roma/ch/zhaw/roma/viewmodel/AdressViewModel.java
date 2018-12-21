package ch.zhaw.roma.ch.zhaw.roma.viewmodel;


import javafx.beans.property.SimpleStringProperty;

public class AdressViewModel {

    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleStringProperty street1 = new SimpleStringProperty();
    private SimpleStringProperty street2 = new SimpleStringProperty();
    private SimpleStringProperty zipCode = new SimpleStringProperty();
    private SimpleStringProperty city = new SimpleStringProperty();

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }


    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getStreet1() {
        return street1.get();
    }

    public SimpleStringProperty street1Property() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1.set(street1);
    }

    public String getStreet2() {
        return street2.get();
    }

    public SimpleStringProperty street2Property() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2.set(street2);
    }

    public String getZipCode() {
        return zipCode.get();
    }

    public SimpleStringProperty zipCodeProperty() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }
}
