package trabalhosaula3;

public class PrintA extends Thread {

	final Exercicio11 exercicio11;

	public PrintA(Exercicio11 exercicio11) {
		this.exercicio11 = exercicio11;
	}

	@Override
	public void run() {

		synchronized (exercicio11) {
			System.out.print("A");
			exercicio11.status = 2;
			exercicio11.notifyAll();
		}

	}

}
