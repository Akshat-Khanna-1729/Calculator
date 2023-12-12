public class Divider extends CalculateBase implements MathProcess{

    public Divider() {};
    public Divider(double leftValue, double rightValue){
        super(leftValue, rightValue);
    }

    @Override
    public void calculate(){
        if(getRightValue() == 0) {
            throw new IllegalArgumentException("Zero rightVal not permitted with divide operation");
        }
        double result = getRightValue()!=0?(getLeftValue() / getRightValue()):0.0d;
        setResult(result);
    };

    @Override
    public String getKeyword() {
        return "divide";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        calculate();
        return getResult();

    }
}
