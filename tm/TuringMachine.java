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
    private ArrayList<TMState> machineStates;
    private Map<String, Transition[]> allMachineTransitions; // All the transitions in the machine
    private TMTape machineTape; // Tape associated with the machine
    private TMState currentState; // Where the head is pointing at
    private TMState haltingState; // Halting state should be the n-1 state (Last state in machine)

    // Constructor
    public TuringMachine(ArrayList<TMState> machineStates, int numSymbols,
            Map<String, Transition[]> allMachineTransitions) {

        this.machineStates = machineStates;
        this.allMachineTransitions = allMachineTransitions;
        this.machineTape = new TMTape();
        this.currentState = machineStates.get(0);
        this.haltingState = machineStates.get(machineStates.size() - 1);

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

        // Iterate over each state and its transitions
        for (TMState state : machineStates) {
            sb.append(state.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

}
