import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectManagementTool extends AbstractManagementTool implements WijzigInterface, PrintInterface{

    public void voerGekozenOptieUit(int choice) {
        switch (choice) {
            case 1:
                printOverzicht();
                break;
            case 2:
                bijwerken();
                break;
            case 3:
                verwijderen();
                break;
            case 4:
                toevoegen();
                break;
            case 5:
                break;
            default:
                krijgGebruikerInput();
                break;
        }
    }


    @Override
    public void printMenu() {
        ArrayList<String> opties = new ArrayList<String>();
        opties.add("Projecten Overzicht");
        opties.add("Project Bewerker");
        opties.add("Project Toevoegen");
        opties.add("Project Verwijderen");
        opties.add("Terug Naar het overzicht");

        Menu.generateMenu(opties, "--- Projecten Beheren ---");
    }

    @Override
    public void toevoegen() {
        Scanner scanner = new Scanner(System.in);
        int projectID = Main.projecten.size() + 1;

        System.out.print("Voer de naam in: ");
        String naam = scanner.nextLine();

        System.out.print("Voer de beschrijving in: ");
        String beschrijving = scanner.nextLine();

        System.out.print("Voer het budget in: ");
        double budget = scanner.nextDouble();
        scanner.nextLine();

        boolean checkStartDatum = false;
        LocalDate startDatum = null;
        while(!checkStartDatum){
            System.out.print("Voer de startdatum in (YYYY-MM-DD): ");
            String startDatumInput = scanner.nextLine();

            if(checker.checkValidDatum(startDatumInput)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                startDatum = LocalDate.parse(startDatumInput, formatter);
                checkStartDatum = true;
            }
        }

        boolean checkEindDatum = false;
        LocalDate eindDatum = null;
        while(!checkEindDatum){
            System.out.print("Voer de einddatum in (YYYY-MM-DD): ");
            String EindDatumInput = scanner.nextLine();

            if(checker.checkValidDatum(EindDatumInput)){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                eindDatum = LocalDate.parse(EindDatumInput, formatter);
                checkEindDatum = true;
            }
        }

        System.out.print("Voer de Klant ID in: ");
        int klantID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Voer de Project Manager(Werknemer) ID in: ");
        int projectManagerID = scanner.nextInt();
        scanner.nextLine();

        Project nieuwProject = new Project(projectID, naam, beschrijving, budget, startDatum, eindDatum, klantID, projectManagerID);
        Main.projecten.add(nieuwProject);
        System.out.println(String.format("\n%s is toegevoegd met ID: %s", nieuwProject.getProjectnaam(), nieuwProject.getProjectID()));
    }

    @Override
    public void verwijderen() {
        Scanner scanner = new Scanner(System.in);
        boolean checkID = false;

        while(!checkID){
            System.out.print("Voer het Project ID in: ");
            int projectIdInput = scanner.nextInt();
            scanner.nextLine();

            if(Main.projecten.stream().anyMatch(project -> project.getProjectID() == (projectIdInput))){
                Main.projecten.removeIf(project -> project.getProjectID() == projectIdInput);
                checkID = true;

                System.out.println(String.format("Project met ID %d verwijderd", projectIdInput));
            }
        }
    }

    @Override
    public void bijwerken() {
        Scanner scanner = new Scanner(System.in);

        boolean checkID = false;
        Project project = null;
        while(!checkID){
            System.out.print("Voer het Project ID in: ");
            int projectIdInput = scanner.nextInt();
            scanner.nextLine();

            project = Main.projecten.stream().filter(p -> p.getKlantID() == projectIdInput).findFirst().orElse(null);
            if(project != null){
                checkID = true;
            }
        }

        ArrayList<String> opties = new ArrayList<String>();
        opties.add("Naam");
        opties.add("Beschrijving");
        opties.add("Budget");
        Menu.generateMenu(opties, "--- Gegevens Beheren ---");

        System.out.println("Welke data wilt u wijzigen? ");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        if(userInput == 1){
            System.out.print("Naam veranderen naar -> ");
            String newName = scanner.nextLine();
            project.setProjectnaam(newName);

            System.out.println("Naam gewijzigd naar " + newName);
        }else if(userInput == 2){
            System.out.print("Beschrijving veranderen naar -> ");
            String newBeschrijving = scanner.nextLine();
            project.setBeschrijving(newBeschrijving);

            System.out.println("Beschrijving gewijzigd naar " + newBeschrijving);
        }else if(userInput == 3){
            System.out.print("Budget veranderen naar -> ");
            int newBudget = scanner.nextInt();
            scanner.nextLine();
            project.setBudget(newBudget);

            System.out.println("Budget gewijzigd naar " + newBudget);
        }
    }

    public void urenDeclareren(){
        Scanner scanner = new Scanner(System.in);

        boolean checkMedewerker = false;
        Medewerker selectedmedewerker = null;
        while(!checkMedewerker){
            System.out.print("Voer je medewerker ID in: ");
            int medewerkerInput = scanner.nextInt();

            if(Main.medewerkers.stream().anyMatch(medewerker -> medewerker.getMedewerkerID() == medewerkerInput)){
                selectedmedewerker = Main.medewerkers.stream().filter(medewerker -> medewerker.getMedewerkerID() == medewerkerInput).findFirst().orElse(null);
                checkMedewerker = true;
            }
        }

        printOverzicht();

        boolean checkProject = false;
        Project selectedProject = null;
        while(!checkProject){
            System.out.print("Voer het ID in van het project: ");
            int projectIdInput = scanner.nextInt();

            if(Main.projecten.stream().anyMatch(project -> project.getProjectID() == (projectIdInput))){
                selectedProject = Main.projecten.stream().filter(project -> project.getProjectID() == projectIdInput).findFirst().orElse(null);
                checkProject = true;
            }
        }

        System.out.print("Hoeveel hele wil je declareren? ");
        int uren = scanner.nextInt();
        scanner.nextLine();

        UrenDeclaratie urenDeclaratie = new UrenDeclaratie(uren , selectedmedewerker);
        selectedProject.addUrenDeclaratie(urenDeclaratie);
    }

    @Override
    public void printOverzicht() {
        for(Project project: Main.projecten){
            System.out.println("(ID " + project.getProjectID() + ") " + project.getProjectnaam() + " | " + String.format("%.2f%% resterend", (project.getRestGeld() / project.getBudget() * 100)) + " | DEADLINE: " + project.getEinddatum());
            System.out.println("       " + project.getBeschrijving());
        }
    }
}
