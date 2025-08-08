// File: LambdaInterfaceDemo.java
@FunctionalInterface
interface Calculator {
    int operate(int a, int b); // abstract method
}

public class LambdaInterfaceDemo {
    public static void main(String[] args) {
        // Implementing the abstract method using Lambda Expression
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> a - b;

        System.out.println("Addition: " + add.operate(10, 5));
        System.out.println("Multiplication: " + multiply.operate(10, 5));
        System.out.println("Subtraction: " + subtract.operate(10, 5));
    }
}
