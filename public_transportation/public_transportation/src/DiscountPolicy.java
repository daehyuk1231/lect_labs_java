public final class DiscountPolicy {
    private DiscountPolicy() {}

    public static int discountedCost(int baseCost, PassengerType type) {
        return switch (type) {
            case STUDENT -> Math.max(0, baseCost - 100);
            case SENIOR -> baseCost * 80 / 100;
            case CHILD -> baseCost * 50 / 100;
            default -> baseCost;
        };
    }
}
