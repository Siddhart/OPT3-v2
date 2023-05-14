import java.util.ArrayList;

public class Klant {
    private int klantID;
    private String naam;
    private String email;
    private String telefoonnummer;

    public Klant(){}

    public Klant(int klantID, String naam, String email, String telefoonnummer) {
        this.klantID = klantID;
        this.naam = naam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
    }

    public int getKlantID() {
        return klantID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }


    public static Klant getKlant(int klantID, ArrayList<Klant> klanten){
        for(Klant k : klanten){
            if(k.getKlantID() == klantID){
                return k;
            }
        }

        return null;
    }
}