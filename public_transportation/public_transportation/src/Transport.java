public abstract class Transport {
    protected final String name;
    protected final int baseCost;
    protected int profit = 0;

    protected Transport(String name, int baseCost) {
        this.name = name;
        this.baseCost = baseCost;
    }

    public String getName() { return name; }
    public int getBaseCost() { return baseCost; }
    public int getProfit() { return profit; }

    public int calculateCost(Passenger p) {
        return DiscountPolicy.discountedCost(baseCost, p.getType());
    }

    public void addProfit(int amount) {
        profit += amount;
    }
}