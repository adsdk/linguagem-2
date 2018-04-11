package trabalhosaula4;

public class Pong extends Thread {

    public static boolean pongDone = true;

    @Override
    public void run() {
        while (true) {
            if (Ping.pingDone) {
                System.out.println("Pong");
                Ping.pingDone = false;
                pongDone = true;
            }
        }
    }

}
