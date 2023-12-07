import java.time.LocalDateTime;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        double[] leftValues = {99.0d, 101.0d, 2.0d, 298.0d};
//        double[] rightValues = {121.0d, 32.0d, 40.0d, 42.0d};
//        char[] operators = {'a', 's', 'm', 'd'};
//        double[] results = new double[operators.length];
//        MathEquation[] equations = new MathEquation[4];
//        for (int i = 0; i < 4; i++) {
//            equations[i] = new MathEquation(operators[i], leftValues[i], rightValues[i]);
//        }
//        if(args.length == 0){
//            for(MathEquation equation:equations){
//                System.out.println("Solution for the equation is "+ equation.execute());
//            }
//        } else if(args[0].charAt(0) == 'w'){
//            giveDateAndTime();
//        }
//        else if (args.length == 3) {
//            performOperation(args);
//        }
//        else{
//            System.out.println("Enter 2 values and a valid operator");
//        }
        performMoreCalculations();
//        executeInteractively();
        dynamicInteractivity();
    }

    private static void dynamicInteractivity() {
        DynamicHelper helper = new DynamicHelper(new MathProcess[] {
                new Adder(),
                new Multiplier(),
                new Subtractor(),
                new Divider(),
                new PowerOf()
        });
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        helper.process(userInput);

    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());
    }

    private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal) {
        CalculateBase calculation = switch (operation) {
            case ADD -> new Adder(leftVal, rightVal);
            case SUBTRACT -> new Subtractor(leftVal, rightVal);
            case MULTIPLY -> new Multiplier(leftVal, rightVal);
            case DIVIDE -> new Divider(leftVal, rightVal);
            case POWEROF -> new PowerOf(leftVal, rightVal);
        };

        return calculation;
    }

    private static void performMoreCalculations() {
        CalculateBase[] calculations = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        System.out.println();
        System.out.println("Array Calculations");

        for (CalculateBase calculation : calculations) {
            calculation.calculate();
            System.out.println("result = " + calculation.getResult());
        }
    }

    static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {
        calculation.setLeftValue(leftVal);
        calculation.setRightValue(rightVal);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

    static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overloaded result with ints: " + equationOverload.getResult());
    }

    static void giveDateAndTime() {
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

    }


}