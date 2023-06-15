import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu{

    KlantManagementTool kmt = new KlantManagementTool();
    MedewerkerManagementTool mmt = new MedewerkerManagementTool();
    ProjectManagementTool pmt = new ProjectManagementTool();

    boolean isRunning = true;

    public Menu(){

    }

    public void showMenu(){
        while (isRunning){
            ArrayList<String> opties = new ArrayList<String>();
            opties.add("Klanten Beheren");
            opties.add("Medewerkers Beheren");
            opties.add("Projecten Beheren");
            opties.add("Uren Declareren");
            opties.add("Sluit Applicatie");

            Menu.generateMenu(opties);

            handleGebruikerKeuze(opties.size());
        }
    }

    public void handleGebruikerKeuze(int l){
        Scanner scanner = new Scanner(System.in);
        int gekozenOptie = scanner.nextInt();
        scanner.nextLine();

        if(gekozenOptie == 1){
            kmt.printMenu();
            kmt.krijgGebruikerInput();
        }else if(gekozenOptie == 2){
            mmt.printMenu();
            mmt.krijgGebruikerInput();
        }else if(gekozenOptie == 3){
            pmt.printMenu();
            pmt.krijgGebruikerInput();
        }else if(gekozenOptie == 4){
            pmt.urenDeclareren();
        }else if (gekozenOptie == l){
            isRunning = false;
        }
    }


    public static void generateMenu(ArrayList<String> opties){
        int optieCounter = 1;
        System.out.println("\n");
        for (String optie : opties){
            System.out.println(optieCounter++ + ". " + optie);
        }

        System.out.print("\nKies een optie: ");
    }
}
