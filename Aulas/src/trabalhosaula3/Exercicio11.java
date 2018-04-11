package trabalhosaula3;

public class Exercicio11 {

	volatile int status = 1; // status inicial é 1, para saber que precisa imprimir o A

	public static void main(String[] args) {

		Exercicio11 exercicio11 = new Exercicio11();

		PrintA printA = new PrintA(exercicio11);
		PrintB printB = new PrintB(exercicio11);
		PrintC printC = new PrintC(exercicio11);

		printC.start();
		printA.start();
		printB.start();
	}

}
