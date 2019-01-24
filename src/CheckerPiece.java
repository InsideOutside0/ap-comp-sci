public class CheckerPiece {

    enum PieceColor {
        Blue, Gold,
    }

    enum Direction {
        Left, Right,
    }

    private int rowIndex;
    private int colIndex;
    private PieceColor pieceColor;
    private boolean isKing;

    public CheckerPiece(int row, int col, PieceColor color, boolean isKing) {
        this.rowIndex = row;
        this.colIndex = col;
        this.pieceColor = color;
        this.isKing = isKing;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColIndex() {
        return colIndex;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public String toString() {
        return rowIndex + ", " + colIndex + ", " + pieceColor;
    }

    public CheckerPiece move(Direction d) {
        switch (d) {
            case Left:
                return new CheckerPiece(rowIndex-1, colIndex-1, pieceColor, isKing);
            case Right:
                return new CheckerPiece(rowIndex-1, colIndex+1, pieceColor, isKing);
            default:
                return new CheckerPiece(rowIndex, colIndex, pieceColor, isKing);
        }
    }

    public CheckerPiece moveBack(Direction d) {
        switch (d) {
            case Left:
                return new CheckerPiece(rowIndex+1, colIndex-1, pieceColor, isKing);
            case Right:
                return new CheckerPiece(rowIndex+1, colIndex+1, pieceColor, isKing);
            default:
                return new CheckerPiece(rowIndex, colIndex, pieceColor, isKing);
        }
    }

    public CheckerPiece jump(Direction d) {
        switch (d) {
            case Left:
                return new CheckerPiece(rowIndex-2, colIndex-2, pieceColor, isKing);
            case Right:
                return new CheckerPiece(rowIndex-2, colIndex+2, pieceColor, isKing);
            default:
                return new CheckerPiece(rowIndex, colIndex, pieceColor, isKing);
        }
    }

    public CheckerPiece jumpBack(Direction d) {
        switch (d) {
            case Left:
                return new CheckerPiece(rowIndex+2, colIndex-2, pieceColor, isKing);
            case Right:
                return new CheckerPiece(rowIndex+2, colIndex+2, pieceColor, isKing);
            default:
                return new CheckerPiece(rowIndex, colIndex, pieceColor, isKing);
        }
    }
}
