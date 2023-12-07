public class DynamicHelper {
    private final MathProcess[] handlers;
    public DynamicHelper(MathProcess[] handlers){
        this.handlers = handlers;
    }

    void process(String statement){
        String[] parts = statement.split(MathProcess.SEPARATOR);
        String keyword = parts[0];
        double leftValue = Double.parseDouble(parts[1]);
        double rightValue = Double.parseDouble(parts[2]);

        MathProcess theHandler = null;
        for(MathProcess handler: handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyword())){
                theHandler = handler;
                break;
            }
        }

        if(theHandler != null){
            double result = theHandler.doCalculation(leftValue, rightValue);
            System.out.println("Result = " + result);
        } else{
            System.out.println("Enter a valid operator");
        }
    }

}
