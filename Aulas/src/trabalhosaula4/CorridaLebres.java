package trabalhosaula4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CorridaLebres {

    public static void main(String[] args) throws InterruptedException {
        final MyThread runlebre1 = new MyThread("1");
        Thread lebre1 = new Thread(runlebre1);
        final MyThread runlebre2 = new MyThread("2");
        Thread lebre2 = new Thread(runlebre2);
        final MyThread runLebre3 = new MyThread("3");
        Thread lebre3 = new Thread(runLebre3);
        final MyThread runLebre4 = new MyThread("4");
        Thread lebre4 = new Thread(runLebre4);
        final MyThread runLebre5 = new MyThread("5");
        Thread lebre5 = new Thread(runLebre5);
        
        lebre1.start();
        lebre2.start();
        lebre3.start();
        lebre4.start();
        lebre5.start();

        lebre1.join();
        lebre2.join();
        lebre3.join();
        lebre4.join();
        lebre5.join();

        List<MyThread> colocacao = Arrays.asList(runlebre1, runlebre2, runLebre3);
        Collections.sort(colocacao);
        for (int i = 1; i <= colocacao.size(); i++) {
            System.out.println("###############################");
            final MyThread lebre = colocacao.get(i - 1);
            System.out.println("Lebre " + lebre.getName());
            System.out.println("Quantidade Saltos " + lebre.getQuantidadeSaltos());
            System.out.println("Colocacao " + i);
            System.out.println("Data chegada :" + lebre.getChegada());
            System.out.println("###############################");

        }
    }

}
