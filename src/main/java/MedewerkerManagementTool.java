import java.util.ArrayList;
import java.util.Scanner;

public class MedewerkerManagementTool extends AbstractManagementTool{
    @Override
    public void printMenu() {
        ArrayList<String> opties = new ArrayList<String>();
        opties.add("Medewerkers Overzicht");
        opties.add("Medewerker Toevoegen");
        opties.add("Medewerker Verwijderen");
        opties.add("Medewerker Bewerker");
        opties.add("Terug Naar het overzicht");

        Menu.generateMenu(opties);
    }

    @Override
    public void toevoegen() {
        Scanner scanner = new Scanner(System.in);
        int medewerkerID = Main.medewerkers.size() + 1;

        System.out.print("Voer de naam in: ");
        String naam = scanner.nextLine();

        //functie quetion and check process
        boolean checkFunctie = false;
        String functie = "";

        //if the email is not valid ask the question agian
        while(!checkFunctie){
            System.out.print("Voer de functie in(bijvoorbeeld: developer): ");
            functie = scanner.nextLine();
            if(checker.checkFunctie(functie)){
                checkFunctie = true;
            }
        }

        //email quetion and check process
        boolean checkEmail = false;
        String email = "";

        //if the email is not valid ask the question agian
        while(!checkEmail){
            System.out.print("Voer het e-mailadres in: ");
            email = scanner.nextLine();
            if(checker.isEmail(email)){
                checkEmail = true;
            }
        }

        System.out.print("Voer het uurtarief in: ");
        double uurtarief = scanner.nextDouble();



        Medewerker nieuweMedewerker = new Medewerker(medewerkerID, naam, functie, email, uurtarief);
        Main.medewerkers.add(nieuweMedewerker);
        System.out.println(String.format("\n%s is toegevoegd met ID: %s", nieuweMedewerker.getNaam(), nieuweMedewerker.getMedewerkerID()));
    }

    @Override
    public void verwijderen() {
        Scanner scanner = new Scanner(System.in);
        boolean checkID = false;

        while(!checkID){
            System.out.print("Voer de Medewerker ID in: ");
            int medewerkerIdInput = scanner.nextInt();
            scanner.nextLine();

            if(Main.medewerkers.stream().anyMatch(medewerker -> medewerker.getMedewerkerID() == (medewerkerIdInput))){
                Main.medewerkers.removeIf(medewerker -> medewerker.getMedewerkerID() == medewerkerIdInput);
                checkID = true;

                System.out.println(String.format("Medewerker met ID %d verwijderd", medewerkerIdInput));
            }
        }
    }

    @Override
    public void bijwerken() {

    }

    @Override
    public void printOverzicht() {
        for(Medewerker medewerker: Main.medewerkers){
            System.out.println("(ID " + medewerker.getMedewerkerID() + ") " + medewerker.getNaam() + " | " + medewerker.getFunctie() + " | " + medewerker.getEmail());
        }
    }
}
