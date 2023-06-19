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

            Menu.generateMenu(opties, "--- Menu ---");

            handleGebruikerKeuze(opties.size());
        }
    }

    public void handleGebruikerKeuze(int l){
        Scanner scanner = new Scanner(System.in);
        int gekozenOptie = scanner.nextInt();
        scanner.nextLine();

        if(gekozenOptie == 1){
            int choice = kmt.start();
            kmt.voerGekozenOptieUit(choice);
        }else if(gekozenOptie == 2){
            int choice = mmt.start();
            mmt.voerGekozenOptieUit(choice);
        }else if(gekozenOptie == 3){
            int choice = pmt.start();
            pmt.voerGekozenOptieUit(choice);
        }else if(gekozenOptie == 4){
            pmt.urenDeclareren();
        }else if (gekozenOptie == l){
            isRunning = false;
        }
    }


    public static void generateMenu(ArrayList<String> opties, String menuTitle){
        int optieCounter = 1;
        System.out.println("\n");
        System.out.println(menuTitle);
        for (String optie : opties){
            System.out.println(optieCounter++ + ". " + optie);
        }

        System.out.print("\nKies een optie: ");
    }
}
