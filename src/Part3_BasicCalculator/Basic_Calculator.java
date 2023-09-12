package Part3_BasicCalculator;
import java.util.Scanner;
public class Basic_Calculator {
    public static void main(String[] args) {
        InfiniteCalculations();
    }
    public static double Add(double a, double b) {
        return a + b;
    }

    public static double Subtract(double a, double b) {
        return a - b;
    }

    public static double Divide(double a, double b) {
        return a / b;
    }

    public static double Multiply(double a, double b) {
        return a * b;
    }
    public static double GetUserInput(String UserMessage){
        Scanner userScan = new Scanner(System.in);
        double Result;
        System.out.println(UserMessage);

        Result = userScan.nextDouble();
        return Result;
    }
    public static String GetUserOperation(String UserMessage,double secondOp){
        Scanner userScan = new Scanner(System.in);
        String operation="";
        System.out.println(UserMessage);
        boolean OperationFlag = false;
        while(!OperationFlag) {
            operation = userScan.nextLine();
            if (operation.contains("+")){
                operation = "+";
                OperationFlag = true;
            }
            else if (operation.contains("add")){
                operation = "+";
                OperationFlag = true;
            }
            else if (operation.contains("-")){
                operation = "-";
                OperationFlag = true;
            }
            else if (operation.contains("sub")){
                operation = "-";
                OperationFlag = true;
            }
            else if (operation.contains("/")){
                if (secondOp == 0) {
                    System.out.println("Sorry, no dividing by zero");
                    System.exit(0);
                }
                operation = "/";
                OperationFlag = true;
            }
            else if (operation.contains("div")){
                if (secondOp == 0) {
                    System.out.println("Sorry, no dividing by zero");
                    System.exit(0);
                }
                operation = "/";
                OperationFlag = true;
            }
            else if (operation.contains("*")){
                operation = "*";
                OperationFlag = true;
            }
            else if (operation.contains("mul")){
                operation = "*";
                OperationFlag = true;
            }
            else{
                System.out.println("I do not understand");
            }
        }
        return operation;

    }
    public static double Calculate(double a, double b, String Operand){
        double Result = switch (Operand) {
            case "+" -> Add(a, b);
            case "-" -> Subtract(a, b);
            case "/" -> Divide(a, b);
            case "*" -> Multiply(a, b);
            default -> 0;
        };
        return Result;
    }
    public static boolean GetUserYes(String UserMessage){
        Scanner userScan = new Scanner(System.in);
        String UserString="";
        boolean Result = false;
        System.out.println(UserMessage);
        boolean OperationFlag = false;
        while(!OperationFlag) {
            UserString = userScan.nextLine();
            if (UserString.toLowerCase().contains("y")){
                Result = true;
                OperationFlag = true;
            }
            else if (UserString.toLowerCase().contains("n")){
                Result = false;
                OperationFlag = true;
            }
            else{
                System.out.println("I do not understand, please enter y/n.");
            }
        }
        return Result;

    }
    public static void InfiniteCalculations(){
        boolean ContinueFlag = true;
        double firstOp;
        double secondOp;
        double ResultOfCalculation=0;
        boolean UsePreviousResult = false;
        while (ContinueFlag)  {
            if (UsePreviousResult) {
                firstOp = ResultOfCalculation;
            }
            else {
                firstOp = GetUserInput("Please, input the first operand");
            }
            secondOp = GetUserInput("Please, input the second operand");
            String operation = GetUserOperation("Please, input the desired operation",secondOp);
            ResultOfCalculation = Calculate(firstOp, secondOp, operation);
            System.out.printf("The result of calculation is %.2f \n",ResultOfCalculation);

            ContinueFlag = GetUserYes(" Would You like to calculate once more?");
            if (ContinueFlag) {
                UsePreviousResult = GetUserYes("Would You like to use previous result as an operand?");
            }
            else {
                UsePreviousResult = false;
            }
        }
    }
}
