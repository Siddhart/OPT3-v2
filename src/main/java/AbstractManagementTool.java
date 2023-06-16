import java.util.Scanner;



public abstract class AbstractManagementTool implements PrintInterface, WijzigInterface {


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


    public void krijgGebruikerInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kies je optie: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        voerGekozenOptieUit(choice);
    }

    public void voerGekozenOptieUit(int choice) {
        switch (choice) {
            case 1:
                printOverzicht();
                break;
            case 2:
                toevoegen();
                break;
            case 3:
                verwijderen();
                break;
            case 4:
                bijwerken();
                break;
            case 5:
                break;
            default:
                krijgGebruikerInput();
                break;
        }
    }
}
