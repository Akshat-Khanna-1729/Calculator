public class Subtractor extends CalculateBase implements MathProcess {

    public Subtractor() {
    }

    public Subtractor(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        double result = getLeftValue() - getRightValue();
        setResult(result);
    }

    ;

    @Override
    public String getKeyword() {
        return "subtract";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        calculate();
        return getResult();
    }
}
