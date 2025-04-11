package tm;

/**
 * @author Zach Johnston, Antonio Herndanez
 * @version 1.00, 04/11/25
 * TMTape is a representation of a Turing Machine's tape
 *      This tape is based off of a Double-Linked List but needs nuances as a Turing Machine requires a tape that is:
 *          1. Bi-Infinite
 *          2. Moves left and right
 *          3. Cells contain one symbol
 *          4. Cells need to be able to be empty and traversable
 *  This implementation only a singular tape head that is used for navigating the tape.
 *  Note: The private Cell class is at the bottom of the class
 */
public class TMTape {

    Cell tapeHead;

    /**
     * Constructor
     *  Creates a new empty tape
     */
    public TMTape() {
        tapeHead = new Cell();
    }

    /**
     * Constructor
     *  Creates a new tape that has a string loaded onto it
     * @param str - a string that loads onto the tape.
     */
    public TMTape(String str) {
        this();
        fill(str);
    }

    /**
     * Reads the current value of the Cell at the tape head
     * @return - the value stored in the Cell of the tape head
     */
    public int read() {
        return tapeHead.getVal();
    }

    /**
     * Writes a value into the current Cell of the tape head
     * @param val - the value to write into the cell
     * @exception IllegalArgumentException - Occurs if the value fed is not valid for the Turing machine i.e
     *      - the value is not an integer 0-9 (inclusive)
     */
    public void write(int val) {
        if(val < 0 || val > 9)
            throw new IllegalArgumentException("INVALID INPUT VALUE: val is: \"" + val + "\". Valid input values are integers 0-9 (inclusive");
        tapeHead.setVal(val);
    }

    /**
     * Moves the tape head left or right
     * @param dir - the character 'R' for move right (next), or the character 'L' for left (previous).
     * @exception IllegalArgumentException - if the character is not 'R' or 'L' is invalid therefore the exception is thrown.
     */
    public void move(char dir) {
        if (dir == 'R')
            tapeHead = tapeHead.getNext();
        else if (dir == 'L')
            tapeHead = tapeHead.getPrevious();
        else
            throw new IllegalArgumentException("Direction (dir) is invalid: use \"R\" for right or \"L\" for left.");

    }

    /**
     * This method takes an input string and fills the tape with that string.
     *  The head is moved to the beginning of the string.
     * TODO: Make recursive?
     * @param input - a string of symbols to fill the tape
     * @exception IllegalArgumentException - Occurs if the value fed from the string is not valid for the Turing machine i.e
     *      - the value is any character that is not a digit.
     */
    public void fill(String input) {
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '1':
                    write(1);
                    break;
                case '2':
                    write(2);
                    break;
                case '3':
                    write(3);
                    break;
                case '4':
                    write(4);
                    break;
                case '5':
                    write(5);
                    break;
                case '6':
                    write(6);
                    break;
                case '7':
                    write(7);
                    break;
                case '8':
                    write(8);
                    break;
                case '9':
                    write(9);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid character at index: " + i + "of the input string: \"" + input + "\". Valid characters are 0-9");
            }
            move('R');
        }
        //Returning head to start of string
        for(int i = 0; i < input.length(); i++) {
            move('L');
        }
    }

    /**
     * Overridden toString
     *      Builds a string that encompasses the values store on the tape in order then
     *      Note: This method only works if the head is on the string, it will provide feedback if it is not.
     * @return - the string stored on the tape
     */
    @Override
    public String toString() {
        if(tapeHead.next == null || tapeHead.previous == null)
            return "Move head onto string";
        while(read() != 0)
            move('L');
        StringBuilder out = new StringBuilder();
        while(read() != 0) {
            out.append(read());
            move('R');
        }
        return out.toString();
    }

    /**
     * @version 1.00, 4/11/25
     * Cell is a representation of a singular cell on a tape and meet the following criteria:
     *      1. A cell can be empty; this is represented by a value of "0" being stored
     *      2. When a next or previous cell is called that does not yet exist; it is created as an empty cell returned.
     * The Cell currently can only store int values with 0 representing an empty cell
     */
    private static class Cell {
        protected Cell next;
        protected Cell previous;
        private int store;

        /**
         * Constructor
         *  Creates an empty cell
         */
        protected Cell() {
            next = null;
            previous = null;
            this.store = 0;
        }

        /**
         * Constructor
         *   Could be used for a recursive fill potentially
         *   Creates a new cell setting the value, next cell, and previous cell.
         * @param store - the value to store
         * @param previous - the previous Cell in the tape
         * @param next - the next cell in the tape
         */
        protected Cell(int store, Cell previous, Cell next) {
            this(previous, next);
            this.store = store;
        }

        /**
         * Private Constructor
         *      Intended for growing the tape when next and previous is called.
         *          The new Cell will always be empty.
         * @param previous - the previous Cell in the tape
         * @param next - the next cell in the tape
         */
        private Cell(Cell previous, Cell next) {
            store = 0;
            this.previous = previous;
            this.next = next;
        }

        /**
         * Get Method
         *  Gives the value stored in the cell
         * @return - the integer saved in store.
         */
        protected int getVal() {
            return store;
        }

        /**
         * Get Method
         *  Returns the next cell.
         *      If the next cell doesn't yet exist it creates a new empty cell.
         * @return - the next cell of the tape
         */
        protected Cell getNext() {
            if (next == null) {
                next = new Cell(this, null);
            }
            return next;
        }

        /**
         * Get Method
         *  Returns the previous cell.
         *      If the previous cell doesn't yet exist it creates a new empty cell.
         * @return - the next cell of the tape
         */
        protected Cell getPrevious() {
            if (previous == null) {
                previous = new Cell(null,this);
            }
            return previous;
        }

        /**
         * Set Method
         *  Sets a new store value for the cell
         * @param store - an integer to be stored
         */
        protected void setVal(int store) {
            this.store = store;
        }
    }
}