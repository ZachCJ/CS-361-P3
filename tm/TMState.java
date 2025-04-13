package tm;

import java.util.ArrayList;

/**
 * Represents a single state in a Turing Machine.
 * Each state can have zero or more transitions to other states.
 * 
 * @author Zach Johnston, Antonio hernandez
 */
public class TMState {

    // Instance variables
    private int stateNumber; // State number

    /**
     * A list of transitions that this state can take.
     */
    private ArrayList<Transition> stateTransitions;

    // ** Constructor
    /**
     * Constructs a new TMState
     *
     * @param stateNumber     the identifier for this state
     * @param numberOfSymbols the number of symbols (not used currently)
     */
    public TMState(int stateNumber) {
        this.stateNumber = stateNumber;
        this.stateTransitions = new ArrayList<>();
    }

    /**
     * Adds a new transition to this state's list of transitions.
     *
     * @param newTransition the transition to add
     * @return true if the transition was added successfully
     */
    public boolean addTransition(Transition newTransition) {
        return this.stateTransitions.add(newTransition);
    }

    /**
     * Gets the transitions associated with this state
     *
     * @return state's full list of transitions
     */
    public ArrayList<Transition> getTransitions() {
        return this.stateTransitions;
    }

    /**
     * Gets the states transition for a given symbol
     * 
     * @param symbolIndex - Symbol we want the transition for
     * @return String of the the transition for the given symbol
     */
    public Transition getTransitionForSymbol(int symbol) {
        return stateTransitions.get(symbol);
    }

    /**
     * Returns whether the state is the halting state or not
     * 
     * @param totalStates - total number of states in the TM
     * @return Boolean representing if this is the halting state or not
     */
    public boolean isHaltingState(int totalStates) {
        return this.stateNumber == totalStates - 1;
    }

    /**
     * Returns a string representation of the state and all its transitions.
     *
     * @return a string representing this state and its transitions
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("State ").append(stateNumber).append(" Transitions:\n");
        for (int i = 0; i < stateTransitions.size(); i++) {
            Transition t = stateTransitions.get(i);
            sb.append("  Transition On ").append(i).append(": ");
            sb.append("NextState=").append(t.getNextState()).append(", ");
            sb.append("WriteSymbol=").append(t.getWriteSymbol()).append(", ");
            sb.append("Move=").append(t.getMove()).append("\n");
        }
        return sb.toString();
    }

    // Methods

}
