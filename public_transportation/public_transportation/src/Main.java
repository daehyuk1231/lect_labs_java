//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int BUS_COST = 1000;
        final int SUBWAY_COST = 1500;

        Bus bus100 = new Bus(100, BUS_COST);
        Bus bus200 = new Bus(200, BUS_COST);
        Subway subway = new Subway("지하철", SUBWAY_COST);

        Passenger p1 = new Passenger("승객1", 10_000, PassengerType.STUDENT);
        Passenger p2 = new Passenger("승객2", 15_000, PassengerType.SENIOR);

        p1.ride(bus100);
        p1.ride(bus200);
        p1.ride(subway);

        p2.ride(bus100);
        p2.ride(bus200);

        System.out.printf("%s 매출: %,d원%n", bus100.getName(), bus100.getProfit());
        System.out.printf("%s 매출: %,d원%n", bus200.getName(), bus200.getProfit());
        System.out.printf("%s 매출: %,d원%n", subway.getName(), subway.getProfit());

        System.out.printf("%s 잔액: %,d원%n", p1.getName(), p1.getBalance());
        System.out.printf("%s 잔액: %,d원%n", p2.getName(), p2.getBalance());
    }
}