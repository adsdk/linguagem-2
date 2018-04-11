package trabalhosaula4;

public class Thread1 extends Thread {

    @Override
    public void run() {
        while (Exercicio14.index + 1 < 100) {
            Exercicio14.incrementIndex();
            Exercicio14.arrGlobal[Exercicio14.index] = Exercicio14.index;
        }
    }

}
