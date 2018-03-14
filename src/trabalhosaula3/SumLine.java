package trabalhosaula3;

import java.util.stream.IntStream;

public class SumLine extends Thread {

	private int lineNumber;
	private int[] values;
	public static int sumTotal = 0;

	public SumLine(int lineNumber, int[] values) {
		this.lineNumber = lineNumber;
		this.values = values;
	}

	@Override
	public void run() {
		int sumLine = IntStream.of(getValues()).sum();
		incrementTotal(sumLine);
		System.out.println("Total linha " + lineNumber + ": " + sumLine);
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int[] getValues() {
		return values;
	}

	public void setValues(int[] values) {
		this.values = values;
	}

	public static synchronized void incrementTotal(int value) {
		sumTotal += value;
	}

}
