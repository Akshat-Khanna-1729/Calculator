public class PowerOf extends CalculateBase implements MathProcess{
    @Override
    public void calculate() {
        double result = Math.pow(getLeftValue(), getRightValue());
        setResult(result);
    }

    public PowerOf() {
    }

    public PowerOf(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        calculate();
        return getResult();
    }
}
