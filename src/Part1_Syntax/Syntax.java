package Part1_Syntax;

import java.util.Scanner;

public class Syntax {
    public static void main(String[] args) {
        print("Method");
        Scanner userScanner = new Scanner(System.in);
        print("Input an integer. A method will add a two to your integer, then return it");
        System.out.println(plusTwo(userScanner.nextInt()));
        print("Input a variable. The method will put it through series of calculations and return it.");
        System.out.println(MultiOperation(userScanner.nextInt()));
    }

    public static void print(String str) {
        //this method simplifies System.Out.Println(), and is a "void" method, thus it doesn't need a "return" statement
        System.out.println(str);
    }

    public static int plusTwo(int userInput) {
        //this method add a 2 to user input, then return it
        int UserPlusTwo = userInput + 2;
        return UserPlusTwo;
    }

    public static int MultiOperation(int userInput) {
        int inputAddition = Add(userInput, 5);
        int inputSubtraction = Subtract(userInput, 6);
        int inputDividing = Divide(userInput, 2);
        int inputMultiplication = Multiply(userInput, 8);
        return inputAddition + inputSubtraction + inputDividing + inputMultiplication;
    }

    public static int Add(int a, int b) {
        return a + b;
    }

    public static int Subtract(int a, int b) {
        return a - b;
    }

    public static int Divide(int a, int b) {
        return a / b;
    }

    public static int Multiply(int a, int b) {
        return a * b;
    }
}
