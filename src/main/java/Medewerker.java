import java.util.ArrayList;

public class Medewerker {
    private int medewerkerID;
    private String naam;
    private String functie;
    private String email;


    public Medewerker(){}

    public Medewerker(int medewerkerID, String naam, String functie, String email) {
        this.medewerkerID = medewerkerID;
        this.naam = naam;
        this.functie = functie;
        this.email = email;
    }

    public int getMedewerkerID() {
        return medewerkerID;
    }

    public void setMedewerkerID(int medewerkerID) {
        this.medewerkerID = medewerkerID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Medewerker getMedewerker(int medewerkerID, ArrayList<Medewerker> medewerker){
        for(Medewerker m : medewerker){
            if(m.getMedewerkerID() == medewerkerID){
                return m;
            }
        }

        return null;
    }
}