package game;

public class RhombusBoard extends MNKBoard {
    public RhombusBoard(int d, int k) {
        super(d, (d - 1) / 2 * 2 + 1, k);
        int leftBorder = (d - 1) / 2;
        int delta = 1;
        for (int r = 0; r < getN() / 2; r++) {
            for (int c = 0; c < leftBorder; c++) {
                cells[r][c] = cells[r][getM() - 1 - c] = Cell.N;
                cells[getN() - 1 - r][c] = cells[getN() - 1 - r][getM() - 1 - c] = Cell.N;
            }
            emptyCellsCounter -= (leftBorder) * 4;
            leftBorder--;
        }
    }
}
