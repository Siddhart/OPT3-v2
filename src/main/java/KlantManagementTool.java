import java.util.ArrayList;
import java.util.Scanner;

public class KlantManagementTool extends AbstractManagementTool{
    @Override
    public void printMenu() {
        ArrayList<String> opties = new ArrayList<String>();
        opties.add("Klanten Overzicht");
        opties.add("Klanten Toevoegen");
        opties.add("Klanten Verwijderen");
        opties.add("Klanten Bewerker");
        opties.add("Terug Naar het overzicht");

        Menu.generateMenu(opties);
    }

    @Override
    public void toevoegen() {
        Scanner scanner = new Scanner(System.in);
        int klantID = Main.klanten.size() + 1;

        System.out.print("Voer de naam in: ");
        String naam = scanner.nextLine();

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


        System.out.print("Voer het telefoonnummer in: ");
        String telefoonnummer = scanner.nextLine();

        //create a new klant and add it to list in the main class
        Klant klant = new Klant(klantID, naam, email, telefoonnummer);
        Main.klanten.add(klant);

        //send a message to the user that the klatn has been added to the list
        System.out.println(String.format("\n%s is toegevoegd met ID: %s", klant.getNaam(), klant.getKlantID()));
    }

    @Override
    public void verwijderen() {
        Scanner scanner = new Scanner(System.in);
        boolean checkID = false;

        while(!checkID){
            System.out.print("Voer de Klant ID in: ");
            int klantIdInput = scanner.nextInt();
            scanner.nextLine();

            if(Main.klanten.stream().anyMatch(klant -> klant.getKlantID() == (klantIdInput))){
                Main.klanten.removeIf(klant -> klant.getKlantID() == klantIdInput);
                checkID = true;

                System.out.println(String.format("Klant met ID %d verwijderd", klantIdInput));
            }
        }
    }

    @Override
    public void bijwerken() {

    }

    @Override
    public void printOverzicht() {
        for(Klant klant: Main.klanten){
            System.out.println("(ID " + klant.getKlantID() + ") " + klant.getNaam() + " | " + klant.getEmail() + " | " + klant.getTelefoonnummer());
        }
    }
}
