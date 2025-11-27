package simulation;

/**
 * Hello world!
 *
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation();
        simulation.run(12,12,900);
    }
}
