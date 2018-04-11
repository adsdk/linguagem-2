package trabalhosaula3;

import java.util.Date;

public class PrintTime extends Thread {

	public static int countTime;

	@Override
	public void run() {
		while (countTime < 5) {
			System.out.println(new Date());
			incrementCount();
			try {
				this.sleep(10000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}

	public static synchronized void incrementCount() {
		countTime++;
	}
}
