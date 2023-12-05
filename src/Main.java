import java.time.LocalDateTime;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        double[] leftValues = {99.0d, 101.0d, 2.0d, 298.0d};
        double[] rightValues = {121.0d, 32.0d, 40.0d, 42.0d};
        char[] operators = {'a', 's', 'm', 'd'};
        double[] results = new double[operators.length];
        MathEquation[] equations = new MathEquation[4];
        for (int i = 0; i < 4; i++) {
            equations[i] = new MathEquation(operators[i], leftValues[i], rightValues[i]);
        }
        if(args.length == 0){
            for(MathEquation equation:equations){
                System.out.println("Solution for the equation is "+ equation.execute());
            }
        } else if(args[0].charAt(0) == 'w'){
            giveDateAndTime();
        }
        else if(args.length == 1 && args[0].equals("interactive")){
            calculateInteractively();
        }
        else if (args.length == 3) {
            cmd_calc(args);
        }
        else{
            System.out.println("Enter 2 values and a valid operator");
        }
    }

    static void giveDateAndTime(){
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

    }
    private static void cmd_calc(String[] args) {
        double leftValue = Double.parseDouble(args[1]);
        double rightValue = Double.parseDouble(args[2]);
        char operator = args[0].charAt(0);

        System.out.println(calculate(leftValue, rightValue, operator));
    }

    private static double calculate(double leftValue, double rightValue, char operator) {
        double result;
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
        return result;
    }

    static void calculateInteractively() {
        System.out.println("Enter 2 numbers and an operator");
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        calculateUsingParts(parts);

    }

    static private void calculateUsingParts(String[] parts) {
        char operator = operatorFromString(parts[0]);
        double leftValue = valueFromString(parts[1]);
        double rightValue = valueFromString(parts[2]);
        double result = calculate(leftValue, rightValue, operator);
        String ans = String.format("%.2f %c %.2f = %.2f", leftValue, operatorToSymbol(operator), rightValue, result);
        System.out.println(ans);
    }

    static char operatorToSymbol(char operator){
        char[] operatorList = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        for(int i=0;i<4;i++){
            if(operator == operatorList[i]) return symbols[i];
        }
        return ' ';
    }
    static char operatorFromString(String input){
        return input.charAt(0);
    }

    static double valueFromString(String stringValue){
        String[] ref = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0;i<ref.length; i++){
            if(stringValue.equals(ref[i])) return i;
        }
        return Double.parseDouble(stringValue);
    }

}