import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.IOException;

public class ParenSymmetry {


    public Boolean isBalanced(String stringtoTest) {
        // implement this method
        int balanced = 0;

        for(int i = 0; i <stringtoTest.length(); i++){
            char currentChar = stringtoTest.charAt(i);

            if(currentChar == '('){
                balanced++;
            } else if (currentChar == ')') {
                balanced--;
            }
        }
        return balanced == 0;
    }

    public void checkFile(String filename) {
        // open file named filename
        try {
            Scanner fileIn = new Scanner(new File("TestStrings0.txt"));

            while (fileIn.hasNextLine()) {
                //Read one line
                String line = fileIn.nextLine();
                //Check if the line is balanced using isBalance() method
                boolean balanced = isBalanced(line);
                //Print if that string is balanced or not, returns either true or false
                System.out.println(line + " -> " + balanced);
            }
        }
        catch (IOException e){
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) {

        ParenSymmetry ps = new ParenSymmetry();

        // Calls file
        ps.checkFile("TestStrings0.txt");

        // Calls method isBalanced and returns a boolean
        Boolean b0 = ps.isBalanced("()");

        // Calls method printResult
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
