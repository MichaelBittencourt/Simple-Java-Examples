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

    }

}

class Lebre extends Thread {

    private Integer id;
    private Integer jump;
    private static Random randJump = new Random();

    public Lebre(Integer id) {
        this.id = id;
        jump = randJump.nextInt() % 20;
        jump = jump < 0 ? -jump : jump;
    }

    public void run() {
        try {
            Thread.sleep(jump * 100);
        } catch(Exception e) { }

        System.out.println("Lebre: " + id + " pulo: " + jump);
    }

}


