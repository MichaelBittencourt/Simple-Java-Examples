public class Main {

    public static void main(String[] args) {

        int a = 1;
        int b = 100212;
        short d = 32767;
        short c = (short) a;
        short e = (short) d;

        System.out.println(c);
        System.out.println(e);

        Thread pool[] = new MyThread[5];
        for (int i = 0; i < 5; i++) {
            pool[i] = new MyThread(i);
            pool[i].start();
        }

    }

}

class MyThread extends Thread {

    private Integer id;

    public MyThread(Integer id) {
        this.id = id;
    }

    public void run() {
        System.out.println("My thread name is: " + id);
    }

}


