package tm;

import java.io.*;
import java.util.*;
import tm.TuringMachine;

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
        ArrayList<TMState> machineStates = new ArrayList<>();
        ArrayList<String> transitions = new ArrayList<>();
        Map<String, Transition[]> stateTransitions = new HashMap<>();
        String inputString = ""; // if blank machine starts with empty tape

        // Getting input file name
        String fileName = args[0];

        // Reading data from input file
        try {
            File inputFile = new File(fileName);
            Scanner scanner = new Scanner(inputFile);

            numberOfStates = scanner.nextInt();
            numberOfSymbols = scanner.nextInt();
            scanner.nextLine();
            // Read the rest of the file
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                transitions.add(data);
            }

            scanner.close();

            // checking if the last line was blank or input
            String lastLine = transitions.get(transitions.size() - 1);
            // IF the last line in the input file is not blank set input to it
            // and remove it from transitions array
            if (!lastLine.contains(",")) {
                inputString = lastLine;
                transitions.remove(transitions.size() - 1);
            }

            // Map state and their corresponding transitions
            int start = 0;
            int state = 0;
            // Loop through all the transitions and map state to them
            while (start < transitions.size()) {
                // Create New State
                TMState newState = new TMState(state);

                Transition[] transitionArray = new Transition[numberOfSymbols + 1];
                int end = Math.min(start + (numberOfSymbols + 1), transitions.size());
                ArrayList<String> subArray = new ArrayList<>(transitions.subList(start, end));

                // Make each transition String into a Transition
                for (int i = 0; i < transitionArray.length; i++) {
                    Transition newTransition = new Transition(subArray.get(i), i);
                    // Add transition to state
                    newState.addTransition(newTransition);
                    transitionArray[i] = newTransition;

                }
                start = end;
                machineStates.add(newState);
                stateTransitions.put(Integer.toString(state), transitionArray);
                state++;
            }
            // Add halting state
            machineStates.add(new TMState(numberOfStates - 1));

            TuringMachine turingMachine = new TuringMachine(machineStates,
                    numberOfSymbols, stateTransitions, inputString);

            // DEBUG Machine has been correctly instantiated

            //System.out.println(turingMachine.toString());
            //System.out.println("Machine input: " + inputString);
            boolean isHalted = false;

            // Run simulation until the machine is in a halted state
            while (!isHalted) {
                isHalted = turingMachine.step();
                //System.out.println("----------------------------------------------");
            }
            System.out.println("Simulation ended: ");
            // Print out tape:
            System.out.println("output: \n" + turingMachine.machineTape.toString());
            System.out.println("output length: " + turingMachine.machineTape.getSize());
        } catch (Exception e) {
            System.err.println("Error reading file");
            e.printStackTrace();
        }
    }

}
