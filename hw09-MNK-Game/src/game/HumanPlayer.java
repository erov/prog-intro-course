package game;

import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayer(final PrintStream out, final Scanner in) {
        if (out == null || in == null) {
            throw new IllegalArgumentException("Error: I/O stream does not exist");
        }
        this.out = out;
        this.in = in;
    }

    public HumanPlayer() {
        this(System.out, new Scanner(System.in));
    }

    private Integer nextInt() {
        if (in.hasNextInt()) {
            return in.nextInt();
        }
        if (in.hasNextLine()) {
            String str;
            do {
                str = in.nextLine();
            } while (str.equals(""));
            return null;
        }
        throw new EmptyStackException();
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
            out.println("Position");
            out.println(position);
            out.println(cell + "'s move");
            out.println("Enter row and column");

            Integer row = null, col = null;
            while (row == null || col == null) {
                row = nextInt();
                if (row == null) {
                    out.println("Invalid cell's address, try again");
                    continue;
                }
                col = nextInt();
                if (col == null) {
                    out.println("Invalid cell's address, try again");
                }
            }

            in.nextLine();

            final Move move = new Move(row, col, cell);
            if (position.isValid(move)) {
                return move;
            }
            out.println("Move " + move + " is invalid, try again");
        }
    }
}
