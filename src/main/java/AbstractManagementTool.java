import java.util.Scanner;

interface PrintInterface{
    void printMenu();
    void printOverzicht();
}

interface WijzigInterface{
    void toevoegen();
    void verwijderen();
}


public abstract class AbstractManagementTool implements PrintInterface, WijzigInterface {

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
            default:
                System.out.println("Invalid choice. Please try again.");
                voerGekozenOptieUit(-1);
        }
    }
}
