package app.labs.ex01;

public class PassangerImpl implements Passanger {

	private int regNumber;
	private String name;
	private int money;

	public PassangerImpl(int regNumber, String name) {
		this.regNumber = regNumber;
		this.name = name;
	}

	public PassangerImpl(int regNumber, String name, int money) {
		this(regNumber, name);
		this.money = money;
	}

	@Override
	public void withdraw(int amount) {
		this.money -= amount;
	}

	@Override
	public void deposit(int amount) {
		this.money += amount;
	}

	@Override
	public String toString() {
		return "PassangerImpl [regNumber=" + regNumber + ", name=" + name + ", money=" + money + "]";
	}
}
