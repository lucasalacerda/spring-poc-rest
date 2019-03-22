package hello;

public class MathOperation {

    private final long id;
    private final double numberOne;
    private final double numberTwo;


    public MathOperation(long id, double numberOne, double numberTwo) {
        this.id = id;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public long getId() {
        return id;
    }

    public double getNumberOne() {
        return numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public double sumNumber() {
        return this.numberOne + this.numberTwo;
    }
}
