public class Adder extends CalculateBase implements MathProcess{

    public Adder() {};
    public Adder(double leftValue, double rightValue){
        super(leftValue, rightValue);
    }

    @Override
    public void calculate(){
        double result = getLeftValue() + getRightValue();
        setResult(result);
    };

    @Override
    public String getKeyword() {
        return "add";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        calculate();
        return getResult();
    }
}
