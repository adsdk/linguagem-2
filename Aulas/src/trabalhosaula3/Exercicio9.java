package trabalhosaula3;

public class Exercicio9 {

	public static void main(String[] args) throws InterruptedException {

		int[][] matriz = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = i + j;
			}
		}

		Thread arrThread[] = new Thread[4];
		for (int i = 0; i < 4; i++) {
			arrThread[i] = new SumLine(i, matriz[i]);
			arrThread[i].start();
		}

		for (int i = 0; i < 4; i++) {
			arrThread[i].join();
		}

		System.out.println("Total soma: " + SumLine.sumTotal);
	}

}
