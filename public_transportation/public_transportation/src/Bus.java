public class Bus extends Transport {
    private final int lineNumber;

    public Bus(int lineNumber, int baseFare) {
        super(lineNumber + "번버스", baseFare);
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() { return lineNumber; }
}
