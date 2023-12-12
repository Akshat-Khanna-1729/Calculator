import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            processFile(reader);
        }
//        catch(IOException ex) {
//            System.out.println("Error reading file - " + ex.getMessage());
//        }
        catch(Exception ex) {
            System.out.println("Error processing file - " + ex.getMessage());
        }
//        dynamicInteractivity();
    }

    private static void processFile(BufferedReader reader) throws IOException {
        String inputLine = null;
        while((inputLine = reader.readLine()) != null)
            try {
                System.out.println(inputLine);
                performOperation(inputLine);
            } catch(InvalidStatementException ex) {
                System.out.println(ex.getMessage() + " - " + inputLine);
                writeInvalidStatementExceptionToLog(ex, inputLine);

            }
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


    private static void performOperation(String input) throws InvalidStatementException {
        try{
            String[] parts = input.split(" ");
            if(parts.length != 3) throw new InvalidStatementException("Statement must have 3 parts: operator, left value, right value");
            MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
            double leftVal = valueFromWord(parts[1]);
            double rightVal = valueFromWord(parts[2]);

            CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
            calculation.calculate();
            System.out.println("Operation performed: " + operation);
            System.out.println(calculation.getResult());
        } catch (InvalidStatementException ex){
            throw ex;
        } catch (Exception ex) {
            throw new InvalidStatementException("Error:- ", ex);
        }
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

    static int valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        int value = -1;
        for(int index = 0; index < numberWords.length; index++) {
            if(word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        if(value == -1d)
            value = Integer.parseInt(word);

        return value;
    }

    static void writeInvalidStatementExceptionToLog(InvalidStatementException ex, String inputLine) {
        System.err.println("");
        System.err.println("*********************************");
        System.err.println("Information written to log system");
        System.err.println("*********************************");

        System.err.println(ex.getMessage() + " - " + inputLine);
        if(ex.getCause() != null)
            System.err.println("  caused by " + ex.getCause());
        ex.printStackTrace(System.err);
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