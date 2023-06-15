import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project implements Subject{
    private int projectID;
    private String projectnaam;
    private String beschrijving;
    private LocalDate startdatum;
    private LocalDate einddatum;
    private int klantID;
    private int managerID;
    private double budget;

    private double restGeld;
    private List<UrenDeclaratie> urenDeclaraties;
    private List<Observer> observers;

    public Project(int projectID, String projectnaam, String beschrijving, int budget, LocalDate startdatum, LocalDate einddatum, int klantID, int projectManagerID) {
        this.projectID = projectID;
        this.projectnaam = projectnaam;
        this.beschrijving = beschrijving;
        this.budget = budget;
        this.restGeld = budget;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.klantID = klantID;
        this.managerID = projectManagerID;

        this.urenDeclaraties = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addUrenDeclaratie(UrenDeclaratie declaratie) {
        urenDeclaraties.add(declaratie);
        updateBudget();
        notifyObservers();
    }

    private void updateBudget() {
        double totaleDeclaraties = 0;
        for(UrenDeclaratie uur: urenDeclaraties){
            totaleDeclaraties += (uur.getUren() * uur.getUurtarief());
        }

        restGeld = (budget - totaleDeclaraties);
    }

    public int getProjectID() {
        return projectID;
    }

    public double getRestGeld(){
        return restGeld;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectnaam() {
        return projectnaam;
    }

    public void setProjectnaam(String projectnaam) {
        this.projectnaam = projectnaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getBudget(){
        return budget;
    }

    public void setBudget(int budget){
        this.budget = budget;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public LocalDate getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(LocalDate startdatum) {
        this.startdatum = startdatum;
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(LocalDate einddatum) {
        this.einddatum = einddatum;
    }

    public int getKlantID() {
        return klantID;
    }

    public int getProjectmanagerID(){
        return managerID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }


    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}