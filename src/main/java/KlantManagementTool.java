import java.util.ArrayList;
import java.util.Scanner;

public class KlantManagementTool extends AbstractManagementTool implements WijzigInterface, PrintInterface{

    public void voerGekozenOptieUit(int choice) {
        switch (choice) {
            case 1:
                printOverzicht();
                break;
            case 2:
                toevoegen();
                break;
            case 3:
                bijwerken();
                break;
            case 4:
                verwijderen();
                break;
            case 5:
                break;
            default:
                krijgGebruikerInput();
                break;
        }
    }

    public void printMenu() {
        ArrayList<String> opties = new ArrayList<String>();
        opties.add("Klanten Overzicht");
        opties.add("Klanten Toevoegen");
        opties.add("Klanten Bewerker");
        opties.add("Klanten Verwijderen");
        opties.add("Terug Naar het overzicht");

        Menu.generateMenu(opties, "--- Klanten Beheren ---");
    }


    public void toevoegen() {
        Scanner scanner = new Scanner(System.in);
        int klantID = Main.klanten.size() + 1;

        System.out.print("Voer de naam in: ");
        String naam = scanner.nextLine();

        //email quetion and check process
        String email = "";

        //if the email is not valid ask the question agian
        while(!checker.isEmail(email)){
            System.out.print("Voer het e-mailadres in: ");
            email = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);

        boolean checkID = false;
        Klant klant = null;
        while(!checkID){
            System.out.print("Voer de Klant ID in: ");
            int klantIdInput = scanner.nextInt();
            scanner.nextLine();

            klant = Main.klanten.stream().filter(k -> k.getKlantID() == klantIdInput).findFirst().orElse(null);
            if(klant != null){
                checkID = true;
            }
        }

        ArrayList<String> opties = new ArrayList<String>();
        opties.add("Naam");
        opties.add("Email");
        opties.add("Telefoonnummer");
        Menu.generateMenu(opties, "--- Gegevens Beheren ---");

        System.out.println("Welke data wilt u wijzigen? ");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        if(userInput == 1){
            System.out.print("Naam veranderen naar -> ");
            String newName = scanner.nextLine();
            klant.setNaam(newName);

            System.out.println("Naam gewijzigd naar " + newName);
        }else if(userInput == 2){
            System.out.print("Email veranderen naar -> ");
            String newEmail = scanner.nextLine();
            klant.setEmail(newEmail);

            System.out.println("Email gewijzigd naar " + newEmail);
        }else if(userInput == 3){
            System.out.print("Telefoonnummer veranderen naar -> ");
            String newTelefoonNummer = scanner.nextLine();
            klant.setTelefoonnummer(newTelefoonNummer);

            System.out.println("Telefoonnummer gewijzigd naar " + newTelefoonNummer);
        }
    }

    @Override
    public void printOverzicht() {
        for(Klant klant: Main.klanten){
            System.out.println("(ID " + klant.getKlantID() + ") " + klant.getNaam() + " | " + klant.getEmail() + " | " + klant.getTelefoonnummer());
        }
    }
}
