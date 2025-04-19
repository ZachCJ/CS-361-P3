package tm;

import java.util.ArrayList;
import java.util.Map;

/**
 * TuringMachine a representation of a turing machine
 * 
 * @author Zach Johnston, Antonio Hernandez
 */
public class TuringMachine {
    // Instance Variables
    private ArrayList<TMState> machineStates;
    private Map<String, Transition[]> allMachineTransitions; // All the transitions in the machine
    public TMTape machineTape; // Tape associated with the machine
    private TMState currentState; // Where the head is pointing at
    private TMState haltingState; // Halting state should be the n-1 state (Last state in machine)

    // Constructor

    /**
     * Initializes a turing machine based on the params
     *
     * @param machineStates - the states of the turing machine
     * @param numSymbols - the number of symbols the turing machine will have
     * @param allMachineTransitions - A map of the transitions between the states
     * @param intputString - the starting string of the tape of the turing machine
     */
    public TuringMachine(ArrayList<TMState> machineStates, int numSymbols,
            Map<String, Transition[]> allMachineTransitions, String intputString) {

        this.machineStates = machineStates;
        this.allMachineTransitions = allMachineTransitions;
        this.machineTape = new TMTape(intputString);
        this.currentState = machineStates.get(0);
        this.haltingState = machineStates.get(machineStates.size() - 1);

    }

    // Class Methods

    /**
     * This method advances the turing machine by one transition
     *
     * @return returns true if step ends on a halt state, and false otherwise
     */
    public boolean step() {
        int currentSymbol = machineTape.read();
        // DEBUG:
        //System.out.println("Current State: " + currentState.getStateName());

        Transition[] transitions = allMachineTransitions.get(Integer.toString(currentState.getStateName()));
        // DEBUG:
        //System.out.println("Current Symbol Transitions: ");
        //for (Transition transition : transitions) {
        //    System.out.println(transition);
        //}

        // If there are not transitions should be in halting state
        if (transitions == null) {
            return true;

        }
        // Get next transition based on current symbol
        Transition nextTransition = transitions[currentSymbol];
        // DEBUG:
        //System.out.println("Transition: " + nextTransition.toString());

        // writing to tape:
        machineTape.write(nextTransition.getWriteSymbol());
        // DEBUG
        //System.out.println("Writing: " + nextTransition.getWriteSymbol());

        // move head
        if (nextTransition.getMove() == 'L') {
            machineTape.move('L');
        } else {
            machineTape.move('R');
        }
        // DEBUG
        //System.out.println("Moving: " + nextTransition.getMove());

        // Change state
        currentState = machineStates.get(nextTransition.getNextState());
        // DEBUG
        //System.out.println("Updated State: " + currentState.getStateName());

        // Halt if in halting state
        return currentState.getStateName() == haltingState.getStateName();
    }

    /**
     * Returns a string representation of the Turing Machine,
     * including the current state, halting state, tape contents,
     * and all state transitions.
     *
     * @return a string describing the machine's configuration and transitions
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Turing Machine ===\n");
        sb.append("Current State: ").append(currentState != null ? currentState.getStateName() : "null").append("\n");
        sb.append("Halting State: ").append(haltingState != null ? haltingState.getStateName() : "null").append("\n");
        sb.append("Tape: ").append(machineTape != null ? machineTape.toString() : "null").append("\n\n");

        sb.append("States and Transitions:\n");

        // Iterate over each state and its transitions
        for (TMState state : machineStates) {
            sb.append(state.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

}
