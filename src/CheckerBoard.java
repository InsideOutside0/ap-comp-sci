public class CheckerBoard {

    private CheckerSquare[][] board;

    public CheckerBoard() {
        board = new CheckerSquare[8][8];
        int current = 0;
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<8; j++) {
                if (current % 2 == 0) board[i][j] = new CheckerSquare(CheckerSquare.BoardColor.Red);
                else board[i][j] = new CheckerSquare(CheckerSquare.BoardColor.Black);
                current++;
            }
        }
    }

    public CheckerSquare[][] getBoard() {
        return board;
    }
}