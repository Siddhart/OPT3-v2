import java.util.Scanner;



public abstract class AbstractManagementTool{


    //class spliten en inlveren in herkansing map codesmells
    //abstract template
    //printer - wijziging
    //klant - medewerker - project

    Checks checker = new Checks();
    public void start(){
        printMenu();
        krijgGebruikerInput();
        printOverzicht();
    }

    public int krijgGebruikerInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kies je optie: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
//        voerGekozenOptieUit(choice);
    }

    public void printMenu(){};
    public void printOverzicht(){};
}
