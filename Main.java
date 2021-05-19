import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        System.out.print("Numero de Lebres: ");
        Integer amountOfThreads = sc.nextInt();

        Thread pool[] = new Lebre[amountOfThreads];
        for (int i = 0; i < amountOfThreads; i++) {
            pool[i] = new Lebre(i);
            pool[i].start();
        }
        while (Lebre.QTD_FINISH < amountOfThreads);
        System.out.println("Todos terminaram");
    }

}

class Lebre extends Thread {

    private static Random randJump = new Random();
    private static Integer first;
    public static Integer QTD_FINISH = 0;
    public static final Integer RACER_LENGTH = 100;
    public static Integer MAX_JUMP = 20;

    private Integer id;
    private Integer position;

    public void updatePosition() {
        Integer jump = randJump.nextInt() % MAX_JUMP + 1;
        jump = jump < 0 ? -jump : jump;
        this.position += jump;
    }

    public Lebre(Integer id) {
        this.id = id;
        this.position = 0;
    }

    private static void updateFirst(Integer id) {
        if (first == null) {
            first = id;
        }
    }

    private static void incrementAmount() {
        QTD_FINISH++;
    }

    public void run() {
        do {
            this.updatePosition();
            System.out.println("Lebre[" + id + "] = " + this.position);
        } while(this.position < RACER_LENGTH);
        Lebre.updateFirst(id);
        System.out.println("Lebre[" + id + "] Terminou");
    }
}


