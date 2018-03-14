package trabalhosaula3;

public class PrintB extends Thread {

	final Exercicio11 exercicio11;

	public PrintB(Exercicio11 exercicio11) {
		this.exercicio11 = exercicio11;
	}

	@Override
	public void run() {

		synchronized (exercicio11) {
			while (exercicio11.status != 2) {
				try {
					exercicio11.wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.print("B");
			exercicio11.status = 3;
			exercicio11.notifyAll();
		}

	}

}
