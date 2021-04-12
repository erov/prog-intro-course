package game;

public class Main {
    public static void main(String[] args) {
        final Game game = new Game(true, new RandomPlayer(), new RandomPlayer());
//        int resultTicTacToe = game.play(new TicTacToeBoard());
//        System.out.println("Game result: " + resultTicTacToe);
//        int resultMNK = game.play(new MNKBoard(10, 10, 5));
//        System.out.println("Game result: " + resultMNK);
        int resultRhombus = game.play(new RhombusBoard(7, 5));
        System.out.println("Game result: " + resultRhombus);
    }
}
