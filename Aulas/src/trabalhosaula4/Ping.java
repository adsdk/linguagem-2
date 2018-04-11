package trabalhosaula4;

public class Ping extends Thread {

    public static boolean pingDone = false;

    @Override
    public void run() {
        while (true) {
            if (Pong.pongDone) {
                System.out.println("Ping");
                Pong.pongDone = false;
                pingDone = true;
            }
        }
    }

}
