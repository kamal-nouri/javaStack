import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Project> projectList = new ArrayList<Project>();

    public Portfolio() {

    }

    public ArrayList<Project> getProjectList() {
        return this.projectList;
    }

    public void setProjectList(Project newProj) {
        this.projectList.add(newProj);
    }

    public double getPortfolioCost() {
        double sum = 0.0;
        for (int i = 0; i < this.projectList.size(); i++) {
            sum += this.projectList.get(i).getInitialCost();
        }
        return sum;
    }

    public void showPortfolio() {
        for (int i = 0; i < this.projectList.size(); i++) {
            System.out.println(this.projectList.get(i).elevatorPitch());
        }
        System.out.println(this.getPortfolioCost());
    }

}
