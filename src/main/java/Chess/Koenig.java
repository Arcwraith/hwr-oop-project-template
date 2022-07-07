package Chess;

public class Koenig implements WegFrei {
    private int player =0;

    public boolean istZugMoeglichFuerKoenig(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        if (activePlayer==1 && isMoveValidMove(fieldWithFigure, columnOld,  rowOld,  rowNew,  columnNew,1) &&
                (fieldWithFigure[rowNew][columnNew].equals(" ") || koenigSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure))) {
            return true;}
        else {
            return activePlayer == 2 && isMoveValidMove(fieldWithFigure, columnOld, rowOld, rowNew, columnNew, 2) &&
                    fieldWithFigure[rowNew][columnNew].equals(" ") || koenigSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure);
        }
    }


    public boolean koenigSchlaegtGegner(int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        if (fieldWithFigure[rowNew][columnNew].equals(" ")) {return false;}
        if (activePlayer == 1) {
            if (!checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                return true;
            }
        }
        if (activePlayer == 2) {
            return checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew]);
        }
        return false;
    }

    @Override
    public boolean isMoveValidMove(String [][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer) {
        return ((rowNew == rowOld + 1 && columnNew == columnOld) || (rowNew == rowOld - 1 && columnNew == columnOld) || (columnNew == columnOld + 1 && rowNew == rowOld) || (columnNew == columnOld - 1 && rowNew == rowOld));
    }

    @Override
    public void setPlayer(int player){
        this.player = player;
    }

    @Override
    public int getPlayer(){
        return this.player;
    }
}