import java.time.LocalDate;

public class Project {
    private int projectID;
    private String projectnaam;
    private String beschrijving;
    private LocalDate startdatum;
    private LocalDate einddatum;
    private int klantID;
    private int managerID;
    private int budget;

    public Project(int projectID, String projectnaam, String beschrijving, int budget, LocalDate startdatum, LocalDate einddatum, int klantID, int projectManagerID) {
        this.projectID = projectID;
        this.projectnaam = projectnaam;
        this.beschrijving = beschrijving;
        this.budget = budget;
        this.startdatum = startdatum;
        this.einddatum = einddatum;
        this.klantID = klantID;
        this.managerID = projectManagerID;
    }

    public int getProjectID() {
        return projectID;
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

    public int getBudget(){
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
}