import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Checks {

    public boolean checkProject(String start, String end, ArrayList<Klant> klanten, int klantID,ArrayList<Medewerker> medewerkers, int medewerkerID){
        return (CheckDate(start, end) && checkKlant(klanten, klantID) != null && checkMedewerker(medewerkers, medewerkerID) != null);
    }

    public boolean CheckDate(String start, String end) {
        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ISO_LOCAL_DATE);

        return endDate.isAfter(startDate);
    }


    public String projectTag(int budget){
        if(budget <= 1000){
            return "klein";
        }else if(budget > 1000 && budget < 5000){
            return "normaal";
        }

        return "groot";
    }

    public Klant checkKlant(ArrayList<Klant> klanten, int klantID){
        for(Klant klant : klanten){
            if(klant.getKlantID() == klantID){
                return klant;
            }
        }
        return null;
    }

    public Medewerker checkMedewerker(ArrayList<Medewerker> medewerkers, int medewerkerID){
        for(Medewerker medewerker : medewerkers){
            if(medewerker.getMedewerkerID() == medewerkerID){
                return medewerker;
            }
        }
        return null;
    }

    public boolean checkEmailEnFunctie(String emailInput, String functieInput){
        return isEmail(emailInput ) && isAllLowercase(functieInput);
    }

    public boolean checkFunctie(String f){
        return isAllLowercase(f);
    }

    public boolean checkValidDatum(String input) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(input, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean projectCheck(int budget, String startDate, String endDate, int medewerkerID, ArrayList<Medewerker> medewerkers, int klantID, ArrayList<Klant> klanten){
        if(budget <= 0) return false;
        if(Medewerker.getMedewerker(medewerkerID, medewerkers) == null) return false;
        if(Klant.getKlant(klantID, klanten) == null) return false;
        if(!CheckDate(startDate, endDate)) return false;

        return true;
    }

    public boolean isEmail(String str) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (str == null)
            return false;
        return pattern.matcher(str).matches();
    }

    public boolean isAllLowercase(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (!Character.isLowerCase(c) || Character.isWhitespace(c) || !Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}
