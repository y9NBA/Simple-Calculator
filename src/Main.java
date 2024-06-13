import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String data = "";

        try (FileReader reader = new FileReader("input.txt")) {
            for (int c; (c = reader.read()) != -1; ) {
                data += ((char)c);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        String[] input = data.split("\n");
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String[] line = input[i].split(" ");
            String outline = input[i].substring(0, input[i].length()-1) + " = ";

            try {
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
                        outline += number1 + number2;
                        break;
                    case "-":
                        outline += number1 - number2;
                        break;
                    case "*":
                        outline += number1 * number2;
                        break;
                    case "/":
                        outline += number1 / number2;
                        break;
                }
            } catch (NumberFormatException ex) {
                outline += "Error! Not number";
            } catch (Exception ex) {
                outline += ex.getMessage();
            }

            output.add(outline + "\n");
        }

        try (FileWriter writer = new FileWriter("output.txt", false)) {
            for (String item: output) {
                writer.write(item);
            }

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


