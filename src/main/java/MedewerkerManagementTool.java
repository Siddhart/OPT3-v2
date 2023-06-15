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
        String email = "";

        //if the email is not valid ask the question agian
        while(!checker.isEmail(email)){
            System.out.print("Voer het e-mailadres in: ");
            email = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);

        boolean checkID = false;
        Medewerker medewerker = null;
        while(!checkID){
            System.out.print("Voer de Medewerker ID in: ");
            int medewerkerIdInput = scanner.nextInt();
            scanner.nextLine();

            medewerker = Main.medewerkers.stream().filter(m -> m.getMedewerkerID() == medewerkerIdInput).findFirst().orElse(null);
            if(medewerker != null){
                checkID = true;
            }
        }

        ArrayList<String> opties = new ArrayList<String>();
        opties.add("Naam");
        opties.add("Email");
        opties.add("Functie");
        opties.add("Uurtarief");
        Menu.generateMenu(opties);

        System.out.println("Welke data wilt u wijzigen? ");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        if(userInput == 1){
            System.out.print("Naam veranderen naar -> ");
            String newName = scanner.nextLine();
            medewerker.setNaam(newName);

            System.out.println("Naam gewijzigd naar " + newName);
        }else if(userInput == 2){
            System.out.print("Email veranderen naar -> ");
            String newEmail = scanner.nextLine();
            medewerker.setEmail(newEmail);

            System.out.println("Email gewijzigd naar " + newEmail);
        }else if(userInput == 3){
            System.out.print("Telefoonnummer veranderen naar -> ");
            String newFunctie = scanner.nextLine();
            medewerker.setFunctie(newFunctie);

            System.out.println("Functie gewijzigd naar " + newFunctie);
        }else if(userInput == 4){
            System.out.print("Uurtarief veranderen naar -> ");
            double newuurtarief = scanner.nextDouble();
            scanner.nextLine();
            medewerker.setUurTarief(newuurtarief);

            System.out.println("Uurtarief gewijzigd naar " + newuurtarief);
        }
    }

    @Override
    public void printOverzicht() {
        for(Medewerker medewerker: Main.medewerkers){
            System.out.println("(ID " + medewerker.getMedewerkerID() + ") " + medewerker.getNaam() + " | " + medewerker.getFunctie() + " | " + medewerker.getEmail() + " | " + String.format("€%.2f/uur", medewerker.getUurTarief()));
        }
    }
}
