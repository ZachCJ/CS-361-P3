package tm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tm.TMState;
import tm.TMTape;

/**
 * TuringMachine a representation of a turing machine
 * 
 * @author Zach Johnston, Antonio Hernandez
 */
public class TuringMachine {
    // Instance Variables
    private Map<Integer, TMState> machineStates; // All states in machine
    private ArrayList<String> allMachineTransitions;
    private TMTape machineTape; // Tape associated with the machine
    private TMState currentState;
    private TMState haltingState;

    // Constructor
    public TuringMachine(int numStates, int numSymbols, ArrayList<String> allMachineTransitions) {
        this.machineStates = new HashMap<>();
        this.allMachineTransitions = allMachineTransitions;

        // Initialize states
        for (int i = 0; i < numStates; i++) {
            TMState newState = new TMState(i);
            machineStates.put(i, newState);
        }
        // add each states transitions
    }

    // Class Methods

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
        for (Map.Entry<Integer, TMState> entry : machineStates.entrySet()) {
            TMState value = entry.getValue();
            sb.append(value.toString());
        }

        return sb.toString();
    }

}
