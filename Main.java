public class Main {

    public static void printMatrix(Integer[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Integer[][] matrix = new Integer[][] {
            {2, 4, 6, 8},
            {1, 2, 3, 4},
            {2, 4, 8, 16},
            {3, 6, 9, 12}
        };

        System.out.println("My matrix:");
        printMatrix(matrix);

        Thread pool[] = new MyThread[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            pool[i] = new MyThread(i, matrix);
            pool[i].start();
        }

    }

}

class MyThread extends Thread {

    private Integer id;
    private Integer[][] matrix;

    public MyThread(Integer id, Integer[][] matrix) {
        this.id = id;
        this.matrix = matrix;
    }

    public void setMatrix(Integer[][] matrix) {
        this.matrix = matrix;
    }

    private Integer sumMatrixLine() {
        Integer sum = 0;
        for(int i = 0; i < matrix[id].length; i++) {
            sum += matrix[id][i];
        }
        return sum;
    }

    public void run() {
        System.out.println("My thread name is: " + id + " sum: " + sumMatrixLine());
    }

}


