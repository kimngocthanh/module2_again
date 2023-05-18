package ss10.bai2.model;

import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    private String idFacturer;
    private String nameFacrure;
    private String nation;

    public Manufacturer() {

    }

    public Manufacturer(String idFacturer, String nameFacrure, String nation) {
        this.idFacturer = idFacturer;
        this.nameFacrure = nameFacrure;
        this.nation = nation;
    }

    public String getIdFacturer() {
        return idFacturer;
    }

    public void setIdFacturer(String idFacturer) {
        this.idFacturer = idFacturer;
    }

    public String getNameFacrure() {
        return nameFacrure;
    }

    public void setNameFacrure(String nameFacrure) {
        this.nameFacrure = nameFacrure;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "idFacturer='" + idFacturer + '\'' +
                ", nameFacrure='" + nameFacrure + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }
}
