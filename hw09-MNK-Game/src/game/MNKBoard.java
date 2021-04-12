package game;

import java.util.Arrays;
import java.util.Map;

public class MNKBoard implements Board, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    private final int k;
    protected final Cell[][] cells;
    private Cell turn;
    protected int emptyCellsCounter = 0;

    public MNKBoard(int m, int n, int k) {
        if (n <= 0 || m <= 0 || k <= 0) {
            throw new IllegalArgumentException("m-n-k arguments should be natural numbers");
        }
        emptyCellsCounter = n * m;
        this.cells = new Cell[n][m];
        this.k = k;
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public int getN() {
        return cells.length;
    }

    @Override
    public int getM() {
        return cells[0].length;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public Cell getCell() {
        return turn;
    }

    @Override
    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;
        }
        cells[move.getRow()][move.getColumn()] = move.getValue();
        emptyCellsCounter--;
        Result result = getResult(move);
        if (result == Result.UNKNOWN) {
            turn = turn == Cell.X ? Cell.O : Cell.X;
        }
        return result;
    }

    private static final int[] directX = {0, 1, 1, 1}, directY = {1, 1, 0, -1};
    private Result getResult(Move move) {
        int maxCnt = 0;
        for (int i = 0; i < 4; i++) {
            maxCnt = Math.max(maxCnt, getLineResult(move, directX[i], directY[i]));
            if (maxCnt >= k) {
                return Result.WIN;
            }
        }
        if (emptyCellsCounter == 0) {
            return Result.DRAW;
        } else {
            return maxCnt >= 4 ? Result.EXTRA : Result.UNKNOWN;
        }
    }

    private int getLineResult(Move move, int dx, int dy) {
        return getVectorResult(move, dx, dy) + getVectorResult(move, -dx, -dy) - 1;
    }

    private int getVectorResult(Move move, int dx, int dy) {
        int cnt = 0;
        int x = move.getRow(), y = move.getColumn();
        while (0 <= x && x < getN() && 0 <= y && y < getM() && cells[x][y] == move.getValue()) {
            cnt++;
            x += dx;
            y += dy;
        }
        return cnt;
    }

    @Override
    public boolean isValid(final Move move) {
        return move != null && 0 <= move.getRow() && move.getRow() < getN()
                && 0 <= move.getColumn() && move.getColumn() < getM()
                && cells[move.getRow()][move.getColumn()] == Cell.E
                && turn == move.getValue();
    }

    @Override
    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    @Override
    public String toString() {
        final int lenN = Integer.toString(getN()).length();
        final int lenM = Integer.toString(getM()).length();

        final StringBuilder sb = new StringBuilder(String.format("%" + lenN + "s ", " "));
        for (int c = 0; c < getM(); c++) {
            sb.append(String.format("%" + lenM + "d ", c));
        }

        for (int r = 0; r < getN(); r++) {
            sb.append("\n");
            sb.append(String.format("%" + lenN + "d ", r));
            for (int c = 0; c < getM(); c++) {
                char current = cells[r][c] == Cell.N ? ' ' : SYMBOLS.get(cells[r][c]);
                sb.append(String.format("%" + lenM + "s ", current));
            }
        }
        return sb.toString();
    }
}
