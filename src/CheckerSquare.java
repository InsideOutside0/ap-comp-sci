public class CheckerSquare {

    enum BoardColor { // it is unwise to use strings for conditional input, constants like enums are better
        Red, Black,
    }

    private BoardColor color;

    public CheckerSquare(BoardColor colorOfSquare) {
        color = colorOfSquare;
    }

    public BoardColor getColor() {
        return color;
    }

}
