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
 */
public class TMTape {

    Cell tapeHead;

    /**
     * @version 1.00, 4/11/25
     * Cell is a representation of a singular cell on a tape and meet the following criteria:
     *      1. A cell can be empty; this is represented by a value of "0" being stored
     *      2. When a next or previous cell is called that does not yet exist; it is created as an empty cell returned.
     * The Cell currently can only store int values with 0 representing an empty cell
     */
    private static class Cell {
        Cell next;
        Cell previous;
        int store;

        /**
         *
         */
        protected Cell() {
            this(0);
        }

        protected Cell(int store) {
            next = null;
            previous = null;
            this.store = store;
        }

        protected int getVal() {
            return store;
        }

        protected void updateVal(int store) {
            this.store = store;
        }

        protected Cell getNext() {
            if (next == null) {
                next = new Cell();
            }
            return next;
        }

        protected Cell getPrevious() {
            if (previous == null) {
                previous = new Cell();
            }
            return previous;
        }
    }

    public TMTape() {
        tapeHead = new Cell();
    }

    public TMTape(String str) {
        this();
        fill(str);
    }

    public int read() {
        return tapeHead.getVal();
    }

    public void write(int val) {
        tapeHead.updateVal(val);
    }

    public void move(char dir) {
        if (dir == 'R')
            tapeHead = tapeHead.getNext();
        else if (dir == 'L')
            tapeHead = tapeHead.getPrevious();
        else
            throw new IllegalArgumentException("Direction (dir) is invalid: use \"R\" for right or \"L\" for left.");

    }

    public void fill(String input) {
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '1':
                    tapeHead.updateVal(1);
                    break;
                case '2':
                    tapeHead.updateVal(2);
                    break;
                case '3':
                    tapeHead.updateVal(3);
                    break;
                case '4':
                    tapeHead.updateVal(4);
                    break;
                case '5':
                    tapeHead.updateVal(5);
                    break;
                case '6':
                    tapeHead.updateVal(6);
                    break;
                case '7':
                    tapeHead.updateVal(7);
                    break;
                case '8':
                    tapeHead.updateVal(8);
                    break;
                case '9':
                    tapeHead.updateVal(9);
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

    @Override
    public String toString() {
        while(read() != 0) //This loop allows toString to be called on the ending State regardless of where the head is
            move('L');
        move('R');
        StringBuilder out = new StringBuilder();
        while(read() != 0) {
            out.append(read());
            move('R');
        }
        return out.toString();
    }
}