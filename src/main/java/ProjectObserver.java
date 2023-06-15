public class ProjectObserver implements Observer {
    private Project project;

    public ProjectObserver(Project project) {
        this.project = project;
        project.registerObserver(this);
    }

    public void update(Project project) {
        double newBudget = project.getRestGeld();
//        System.out.println("Nieuw budget voor " + project.getProjectnaam() + ": " + newBudget);
        System.out.println(project.getProjectnaam() + ": " + newBudget + " van " + project.getBudget() + "("+ String.format("%.2f", (newBudget / project.getBudget()) * 100) +"%)"+ " resterend!");
    }
}