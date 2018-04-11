package trabalhosaula4;

public class Exercicio14 {

    static int arrGlobal[] = new int[100];
    static int index = -1;

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        for (int i : arrGlobal) {
            System.out.println(i);
        }
    }

    public static synchronized void incrementIndex() {
        index++;
    }
}
