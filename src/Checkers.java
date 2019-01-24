import java.util.ArrayList;
public class Checkers {

    private CheckerBoard gameBoard; //represents the board for a checkers game
    private ArrayList<CheckerPiece> blues;//lists all of the blue pieces on the board
    private ArrayList<CheckerPiece> golds;//lists all of the gold pieces on the board
    private final CheckerPiece.PieceColor blue = CheckerPiece.PieceColor.Blue;
    private final CheckerPiece.PieceColor gold = CheckerPiece.PieceColor.Gold;

    public Checkers() {
        this.gameBoard = new CheckerBoard();
        this.blues = new ArrayList<>();
        this.golds = new ArrayList<>();
        int current1 = 0;
        int current2 = 0;
        for (int j = 0; j<8; j++) {
            for (int i = 0; i<=2; i++) {
                if (current1%2==1) {
                    this.golds.add(new CheckerPiece(i, j, CheckerPiece.PieceColor.Gold, false));
                }
                current1++;
            }
            for (int i = 5; i<=7; i++) {
                if (current2%2==0) {
                    this.blues.add(new CheckerPiece(i, j, CheckerPiece.PieceColor.Blue, false));
                }
                current2++;
            }
        }
    }

    public boolean isClear(int x, int y) {
        if (x<0 || y<0) return false;
        for (CheckerPiece c : this.blues) if (c.getRowIndex()==x && c.getColIndex()==y) return false;
        for (CheckerPiece c : this.golds) if (c.getRowIndex()==x && c.getColIndex()==y) return false;
        return true;
    }

    public void movePieceLeft(CheckerPiece c) {
        if (c.getPieceColor()==gold) {
            if (this.isClear(c.getRowIndex()-1, c.getColIndex()-1)) {
                this.golds.add(c.move(CheckerPiece.Direction.Left));
                this.golds.remove(c);
            }
        } else {
            if (this.isClear(c.getRowIndex()+1, c.getColIndex()+1)) { // from the other perspective
                this.blues.add(c.moveBack(CheckerPiece.Direction.Right));
                this.blues.remove(c);
            }
        }
    }

    public void movePieceRight(CheckerPiece c) {
        if (c.getPieceColor()==gold) {
            if (this.isClear(c.getRowIndex()-1, c.getColIndex()+1)) {
                this.golds.add(c.move(CheckerPiece.Direction.Right));
                this.golds.remove(c);
            }
        } else {
            if (this.isClear(c.getRowIndex()+1, c.getColIndex()-1)) { // from the other perspective
                this.blues.add(c.moveBack(CheckerPiece.Direction.Left));
                this.blues.remove(c);
            }
        }
    }

    public static void main(String[] args) {
        Checkers ch = new Checkers();
        for (CheckerPiece blue : ch.blues) System.out.println(blue);
        System.out.println();
        for (CheckerPiece gold : ch.golds) System.out.println(gold);
    }

}