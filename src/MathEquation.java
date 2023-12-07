public class MathEquation {

    private double leftValue;
    private double rightValue;
    private char operator;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfAllResults;

    //Constructors
    MathEquation() {};
    MathEquation(char operator){
        this.operator = operator;
    }

    MathEquation(char operator, double leftValue, double rightValue){
        this(operator);
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    //getter functions
    double getLeftValue(){
        return leftValue;
    }

    double getRightValue() {
        return rightValue;
    }

    char getOperator() {
        return operator;
    }

    public void setLeftValue(double leftValue) {
        this.leftValue = leftValue;
    }

    //methods
    double execute() {
        result = switch (operator) {
            case 'a' -> leftValue + rightValue;
            case 's' -> leftValue - rightValue;
            case 'm' -> leftValue * rightValue;
            case 'd' -> rightValue != 0 ? leftValue / rightValue : 0.0d;
            default -> {
                System.out.println("Invalid operator:-" + operator);
                yield 0.0d;
            }
        };
        numberOfCalculations++;
        sumOfAllResults += result;
        return result;
    }

    void execute(double leftValue, double rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        execute();
    }


    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public static double getAverageResult(){
        return sumOfAllResults/numberOfCalculations;
    }
}
