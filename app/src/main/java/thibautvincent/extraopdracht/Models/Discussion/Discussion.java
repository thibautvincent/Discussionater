package thibautvincent.extraopdracht.Models.Discussion;

import com.google.gson.annotations.Expose;

/**
 * Created by Thibaut on 8/24/16.
 */
public class Discussion {

    @Expose private String vraag;

    @Expose private String compensatie;

    @Expose private int opgelost;

    @Expose private int gewonnen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Expose private int id;

    @Expose private String mijnAntwoord;

    @Expose private String vriendAntwoord;


    public String getMijnAntwoord() {
        return mijnAntwoord;
    }

    public void setMijnAntwoord(String mijnAntwoord) {
        this.mijnAntwoord = mijnAntwoord;
    }

    public String getVriendAntwoord() {
        return vriendAntwoord;
    }

    public void setVriendAntwoord(String vriendAntwoord) {
        this.vriendAntwoord = vriendAntwoord;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getCompensatie() {
        return compensatie;
    }

    public void setCompensatie(String compensatie) {
        this.compensatie = compensatie;
    }

    public int getOpgelost() {
        return opgelost;
    }

    public void setOpgelost(int opgelost) {
        this.opgelost = opgelost;
    }

    public int getGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(int gewonnen) {
        this.gewonnen = gewonnen;
    }
}
