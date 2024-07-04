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

            // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
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
