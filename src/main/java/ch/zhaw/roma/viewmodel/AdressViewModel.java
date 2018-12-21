package ch.zhaw.roma.viewmodel;

import ch.zhaw.roma.model.Adress;
import javafx.beans.property.SimpleObjectProperty;

public class AdressViewModel {

    private SimpleObjectProperty<Adress> adress = new SimpleObjectProperty<Adress>(this, "adress");

    public Adress getAdress() {
        return adress.get();
    }

    public SimpleObjectProperty<Adress> adressProperty() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress.set(adress);
    }
}
