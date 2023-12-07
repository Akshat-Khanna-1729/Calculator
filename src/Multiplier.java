public class Multiplier extends CalculateBase implements MathProcess{

    public Multiplier() {};
    public Multiplier(double leftValue, double rightValue){
        super(leftValue, rightValue);
    }

    @Override
    public void calculate(){
        double result = getLeftValue() * getRightValue();
        setResult(result);
    };

    @Override
    public String getKeyword() {
        return "multiply";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        calculate();
        return getResult();
    }
}
