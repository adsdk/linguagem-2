package trabalhosaula3;

public class PrintC extends Thread {

	final Exercicio11 exercicio11;

	public PrintC(Exercicio11 exercicio11) {
		this.exercicio11 = exercicio11;
	}

	@Override
	public void run() {

		synchronized (exercicio11) {
			while (exercicio11.status != 3) {
				try {
					exercicio11.wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.println("C");
		}

	}

}
