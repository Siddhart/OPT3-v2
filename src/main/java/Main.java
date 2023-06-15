import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static ArrayList<Klant> klanten = new ArrayList<Klant>(Arrays.asList(
            new Klant(1, "Sidd Ghogli", "siddhartssg@gmail.com", "+31 628819729"),
            new Klant(2, "Klant twee", "klant_twee@gmail.com", "+31 612345678"),
            new Klant(3, "Klant drie", "klant_drie@gmail.com", "+31 698765432")
    ));

    public static ArrayList<Project> projecten = new ArrayList<Project>(Arrays.asList(
            new Project(1, "Project 1", "Klein Project", 2000, LocalDate.parse("2023-04-15", DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.parse("2023-05-20", DateTimeFormatter.ISO_LOCAL_DATE), 1, 4),
            new Project(2, "Project 2", "Groot Project", 50000, LocalDate.parse("2023-01-23", DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.parse("2023-08-12", DateTimeFormatter.ISO_LOCAL_DATE), 2, 5)
    ));

    public static ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>(Arrays.asList(
            new Medewerker(1, "Medewerker een", "manager", "+31 623456789", 50),
            new Medewerker(2, "Medewerker twee", "developer", "+31 634567890", 35),
            new Medewerker(3, "Medewerker drie", "designer", "+31 645678901", 25)
    ));


    public static void main(String[] args) {
//        TEST OBSERVER PATTERN
//        crmApplicatie.projecten.get(1).addUrenDeclaratie(new UrenDeclaratie(2, crmApplicatie.medewerkers.get(0)));
//        crmApplicatie.projecten.get(0).addUrenDeclaratie(new UrenDeclaratie(2, crmApplicatie.medewerkers.get(0)));

        Menu menu = new Menu();
        menu.showMenu();
    }
}