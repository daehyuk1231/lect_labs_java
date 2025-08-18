package app.labs.ex01;

public class Subway implements Transportation {

	private int lineNumber;
	private int passangerCount;
	private int money;

	public Subway(int lineNumber) { // side effect : 부작용. 예측된 값과 다른 값이 나오는 경우.
		this.lineNumber = lineNumber;
		this.passangerCount = 0;
		this.money = 0;
	}
	
	// 오버로딩(컴파일시 적용)과 오버라이딩(실행시 적용)이 동시에 있을 경우 오버로딩 부분은 부모에서 해결.
	public void getIn(Student pass) {
		++this.passangerCount;
		this.money += 1400; // 생성자로 초기화
		pass.withdraw(1400);
		
		System.out.println(this.toString());
		System.out.println(pass.toString());
	}

	@Override  // 우선권을 갖음.
	public void getIn(Passanger pass) {
		++this.passangerCount;
		this.money += 1500; // 생성자로 초기화
		pass.withdraw(1500);
		System.out.println(this.toString());
		System.out.println(pass.toString());
	}

	@Override
	public void getOut(Passanger pass) {
		--this.passangerCount;
		System.out.println(this.toString());
		System.out.println(pass.toString());
	}

	@Override
	public String toString() {
		return "Subway [lineNumber=" + lineNumber + ", passangerCount=" + passangerCount + ", money=" + money + "]";
	}
}
