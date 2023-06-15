import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public ArrayList<Klant> klanten;
    public ArrayList<Project> projecten;
    public ArrayList<Medewerker> medewerkers;

    public Main() {
        klanten = new ArrayList<Klant>(Arrays.asList(
                new Klant(1, "Sidd Ghogli", "siddhartssg@gmail.com", "+31 628819729"),
                new Klant(2, "Klant twee", "klant_twee@gmail.com", "+31 612345678"),
                new Klant(3, "Klant drie", "klant_drie@gmail.com", "+31 698765432")
        ));

        medewerkers = new ArrayList<Medewerker>(Arrays.asList(
                new Medewerker(4, "Medewerker een", "manager", "+31 623456789", 50),
                new Medewerker(5, "Medewerker twee", "developer", "+31 634567890", 35),
                new Medewerker(6, "Medewerker drie", "designer", "+31 645678901", 25)
        ));

        projecten = new ArrayList<Project>(Arrays.asList(
                new Project(7, "Project 1", "Klein Project", 2000, LocalDate.parse("2023-04-15", DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.parse("2023-05-20", DateTimeFormatter.ISO_LOCAL_DATE), 1, 4),
                new Project(8, "Project 2", "Groot Project", 50000, LocalDate.parse("2023-01-23", DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.parse("2023-08-12", DateTimeFormatter.ISO_LOCAL_DATE), 2, 5)
        ));
    }

    public static void main(String[] args) {
        Main crmApplicatie = new Main();

        for(Project p : crmApplicatie.projecten){
            new ProjectObserver(p);
        }

        crmApplicatie.projecten.get(1).addUrenDeclaratie(new UrenDeclaratie(2, crmApplicatie.medewerkers.get(0)));
        crmApplicatie.projecten.get(0).addUrenDeclaratie(new UrenDeclaratie(2, crmApplicatie.medewerkers.get(0)));

        crmApplicatie.start();
    }

    public void start() {
        boolean programmaActief = true;
        Scanner scanner = new Scanner(System.in);

        while (programmaActief) {
            toonMenu();
            int keuze = scanner.nextInt();
            scanner.nextLine(); // Om de resterende invoerbuffer te verwijderen

            switch (keuze) {
                case 1:
                    voegKlantToe(scanner);
                    break;
                case 2:
                    voegProjectToe(scanner);
                    break;
                case 3:
                    voegMedewerkerToe(scanner);
                    break;
                case 4:
                    toonKlanten();
                    break;
                case 5:
                    toonProjecten();
                    break;
                case 6:
                    toonMedewerkers();
                    break;
                case 7:
                    urenDeclareren();
                    break;
                case 8:
                    programmaActief = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }

        scanner.close();
    }

    private void toonMenu() {
        System.out.println("Selecteer een optie:");
        System.out.println("1. Klant toevoegen");
        System.out.println("2. Project toevoegen");
        System.out.println("3. Medewerker toevoegen");
        System.out.println("4. Klanten weergeven");
        System.out.println("5. Projecten weergeven");
        System.out.println("6. Medewerkers weergeven");
        System.out.println("7. Uren Declareren");
        System.out.println("8. Afsluiten");
    }

    private void voegKlantToe(Scanner scanner) {
        System.out.println("Voer de klant-ID in:");
        int klantID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Voer de naam in:");
        String naam = scanner.nextLine();

        System.out.println("Voer het e-mailadres in:");
        String email = scanner.nextLine();

        System.out.println("Voer het telefoonnummer in:");
        String telefoonnummer = scanner.nextLine();

        Klant klant = new Klant(klantID, naam, email, telefoonnummer);
        klanten.add(klant);
        System.out.println("Klant toegevoegd.");
    }

    private void voegProjectToe(Scanner scanner) {
        System.out.println("Voer het project-ID in:");
        int projectID = scanner.nextInt();
        scanner.nextLine();

        //project manager/ klantid / datum check
        System.out.println("Voer de projectnaam in:");
        String projectnaam = scanner.nextLine();

        System.out.println("Voer de projectbeschrijving in:");
        String beschrijving = scanner.nextLine();

        System.out.println("Voer het budget in:");
        int budget = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Voer de klant-ID in:");
        int klantID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Voer de medewerker-ID in:");
        int medewerkerID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Voer de startdatum in (YYYY-MM-DD):");
        String startdatumStr = scanner.nextLine();
        LocalDate startdatum = LocalDate.parse(startdatumStr, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("Voer de einddatum in (YYYY-MM-DD):");
        String einddatumStr = scanner.nextLine();
        LocalDate einddatum = LocalDate.parse(einddatumStr, DateTimeFormatter.ISO_LOCAL_DATE);

        Project project = new Project(projectID, projectnaam, beschrijving, budget, startdatum, einddatum, klantID,medewerkerID);
        new ProjectObserver(project);
        projecten.add(project);
        System.out.println("Project toegevoegd.");
    }

    private void voegMedewerkerToe(Scanner scanner) {
        System.out.println("Voer de medewerker-ID in:");
        int medewerkerID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Voer de voornaam in:");
        String voornaam = scanner.nextLine();

        System.out.println("Voer de achternaam in:");
        String achternaam = scanner.nextLine();

        System.out.println("Voer de functie in:");
        String functie = scanner.nextLine();

        System.out.println("Voer het e-mailadres in:");
        String email = scanner.nextLine();

        System.out.println("Voer het uurtarief in:");
        Double uurTarief = scanner.nextDouble();

        Medewerker medewerker = new Medewerker(medewerkerID, (voornaam + " " + achternaam), functie, email, uurTarief);
        medewerkers.add(medewerker);
        System.out.println("Medewerker toegevoegd.");
    }

    private void toonKlanten() {
        System.out.println("Klantenlijst:");
        for (Klant klant : klanten) {
            System.out.println("ID: " + klant.getKlantID() + ", Naam: " + klant.getNaam() + ", E-mail: " + klant.getEmail() + ", Telefoonnummer: " + klant.getTelefoonnummer());
        }
    }

    private void toonProjecten() {
        System.out.println("Projectenlijst:");
        for (Project project : projecten) {
            System.out.println("ID: " + project.getProjectID() + ", Klant: " + project.getKlantID() + ", " +project.getProjectmanagerID() + ", Naam: " + project.getProjectnaam() + ", Beschrijving: " + project.getBeschrijving() + ", Startdatum: " + project.getStartdatum() + ", Einddatum: " + project.getEinddatum());
        }
    }

    private void toonMedewerkers() {
        System.out.println("Medewerkerslijst:");
        for (Medewerker medewerker : medewerkers) {
            System.out.println("ID: " + medewerker.getMedewerkerID() + ", " + medewerker.getFunctie() + ", Naam: " + medewerker.getNaam() + ", E-mail: " + medewerker.getEmail());
        }
    }

    private void urenDeclareren(){
        //TODO code hierzo toevoegen
        //input is de medewerkerID, ProjectID en het aantal uur. Daarna toevoegen aan UrenDeclaratie in Project Class
    }
}