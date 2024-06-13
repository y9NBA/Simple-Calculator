import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String input = "";
        String output = "";

        try (FileReader reader = new FileReader("input.txt")) {
            for (int c; (c = reader.read()) != -1; ) {
                input += (((char)c));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            String[] line = input.split(" ");

            double number1 = Double.parseDouble(line[0]);
            double number2 = Double.parseDouble(line[2]);

            String operation = line[1];

            if (!"-*/+".contains(operation)) {
                throw new Exception("Operation Error!");
            }

            if (number2 == 0) {
                throw new Exception("Error! Division by zero");
            }

            switch (operation) {
                case "+":
                    System.out.println(number1 + number2);
                    break;
                case "-":
                    System.out.println(number1 - number2);
                    break;
                case "*":
                    System.out.println(number1 * number2);
                    break;
                case "/":
                    System.out.println(number1 / number2);
                    break;
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error! Not number");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


