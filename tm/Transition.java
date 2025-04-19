package tm;

import java.util.StringTokenizer;

/**
 * Represents a single transition in a Turing Machine.
 * A transition defines the next state, the symbol to write,
 * and the direction to move the tape head.
 * 
 * @author Zach Johnston, Antonio Hernandez
 */
public class Transition {
    // ** Instance Variables
    private int nextState; // State that the machine transitions to
    private int writeSymbol; // Symbol the machine will write to the cell
    private char move; // Direction, either L or R to move the tape head to

    private int transitionOnSymbol;

    // ** Constructor
    /**
     * Constructs a new Transition from a string input.
     * The input should be formatted as "nextState,writeSymbol,move".
     *
     * @param transition the comma-separated string representing the transition
     */
    public Transition(String transition, int onSymbol) {
        // Symbol to transition on
        this.transitionOnSymbol = onSymbol;

        // Parse input transition using StringTokenizer
        StringTokenizer st = new StringTokenizer(transition, ",");
        this.nextState = Integer.parseInt(st.nextToken());
        this.writeSymbol = Integer.parseInt(st.nextToken());
        this.move = st.nextToken().charAt(0);
    }

    // ** Class Methods
    /**
     * Returns the next state that the machine will transition to.
     *
     * @return the next state
     */
    public int getNextState() {
        return nextState;
    }

    /**
     * Returns the symbol to be written on the tape.
     *
     * @return the symbol to write
     */
    public int getWriteSymbol() {
        return writeSymbol;
    }

    /**
     * Returns the direction the tape head should move ("L" or "R").
     *
     * @return the move direction
     */
    public char getMove() {
        return move;
    }

    /**
     * Returns the symbol this transition is associated with
     *
     * @return the transition on symbol
     */
    public int getTransitionOnSymbol() {
        return this.transitionOnSymbol;
    }

    @Override
    public String toString() {
        return "On symbol " + transitionOnSymbol + " => " +
                "NextState=" + nextState + ", Write=" + writeSymbol + ", Move=" + move;
    }

}
