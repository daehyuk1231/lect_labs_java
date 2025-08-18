public class Passenger {
    private final String name;
    private int balance;
    private final PassengerType type;

    public Passenger(String name, int balance, PassengerType type) {
        this.name = name;
        this.balance = balance;
        this.type = type;
    }

    public String getName() { return name; }
    public int getBalance() { return balance; }
    public PassengerType getType() { return type; }

    public void ride(Transport transport) {
        int cost = transport.calculateCost(this);
        balance -= cost;
        transport.addProfit(cost);
    }
}