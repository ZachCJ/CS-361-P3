package tm;

import java.io.*;
import java.util.*;

// import tm.TMState;

/**
 * Main driver class that runs the simulation
 * 
 * @author Zach Johnston, Antonio Hernandez
 */
public class TMSimulator {

    public static void main(String[] args) {
        int numberOfStates = 0;
        int numberOfSymbols;
        ArrayList<String> transitions = new ArrayList<>();
        String inputString = ""; // if blank machine starts with empty tape

        // Getting input file name
        String fileName = args[0];

        // Reading data from input file
        try {
            File inputFile = new File(fileName);
            Scanner scanner = new Scanner(inputFile);

            numberOfStates = scanner.nextInt();
            numberOfSymbols = scanner.nextInt();

            // Read the rest of the file
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                transitions.add(data);
            }

            scanner.close();

            // checking if the last line was blank or input
            String lastLine = transitions.get(transitions.size() - 1);
            if (!lastLine.contains(",")) {
                inputString = lastLine;
            }
            System.out.println("First line total number of state: " + numberOfStates);
            System.out.println("Second line number of symbols in alphabet Σ: " + numberOfSymbols);
            System.out.println("Transitions: ");
            for (String string : transitions) {
                System.out.println(string);
            }
            System.out.println("Last line input string: " + inputString);

        } catch (Exception e) {
            System.err.println("Error reading file");
            e.printStackTrace();
        }
        // Check that file was read correctly TODO

        // for (int i = 0; i < numberOfStates; i++) {
        // TMState state = new TMState(i);

        // System.out.println(state.toString());
        // }

    }

}
