package trabalhosaula3;

public class PrintName extends Thread {

	private String value;

	public PrintName(String value) {
		this.value = value;
	}

	@Override
	public void run() {
		System.out.println(getValue());
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
