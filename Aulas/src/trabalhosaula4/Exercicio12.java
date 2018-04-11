package trabalhosaula4;

public class Exercicio12 {

    public static void main(String[] args) throws InterruptedException {

        Ping ping = new Ping();
        Pong pong = new Pong();

        ping.start();
        pong.start();
        
    }

}
