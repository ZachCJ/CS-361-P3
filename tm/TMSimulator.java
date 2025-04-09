package tm;

import java.io.*;
import java.util.*;

/**
 * Main driver class that runs the simulation
 * 
 * @author Zach johnson, Antonio hernandez
 */
public class TMSimulator {
    public int numberOfState;
    public int numberOfSymbols;
    // ? Transitions
    public String inputString; // if blank machine starts with empty tape

    public static void main(String[] args) {
        String fileName = args[0];

        // Reading in input file
        System.out.println("Filename =>" + args[0]);

        try {
            File inputFile = new File(fileName);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Error reading file");
            e.printStackTrace();
        }

    }

}
