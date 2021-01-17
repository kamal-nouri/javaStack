import java.util.*;

public class PrjectTest {
    public static void main(String[] args) {
        // Project first=new Project("kamal","good",50.0);
        // String name =first.getName();
        // // System.out.println(name);
        // String shit =first.elevatorPitch();
        // System.out.println(shit);
        // Project proj1 = new Project();
        Project proj3 = new Project("comp1", "this", 5.00);
        Project proj2 = new Project("comp2", "this", 9.00);
        Project proj4 = new Project("comp4", "this", 7.00);

        Portfolio port = new Portfolio();
        port.setProjectList(proj3);
        port.setProjectList(proj2);
        port.setProjectList(proj4);

        System.out.println(port.getPortfolioCost());


    }
}
