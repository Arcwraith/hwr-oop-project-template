package Chess;

public class Koenig implements WegFrei {
    private int player =0;

    public boolean istZugMoeglichFürKoenig(int rowOld, int columnOld, int rowNew, int columnNew, int activePlayer, String fieldWithFigure[][]) {
        if (activePlayer==1 && isMoveValidMove(fieldWithFigure, columnOld,  rowOld,  rowNew,  columnNew,1) &&
                fieldWithFigure[rowNew][columnNew].equals(" ") || koenigSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure)) {
            return true;}
        else {
            if (activePlayer==2 && isMoveValidMove(fieldWithFigure, columnOld,  rowOld,  rowNew,  columnNew,2) &&
                    fieldWithFigure[rowNew][columnNew].equals(" ") || koenigSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure)) {
                return true;}
        }
        return false;
    }


    public boolean koenigSchlaegtGegner( int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        if (fieldWithFigure[rowNew][columnNew].equals(" ")) {return false;}
        if (activePlayer == 1) {
            if (!checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                //sind gr0ße Buchstaben
                return true;
            }
        }
        if (activePlayer == 2) {
            if (checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                //sind kleine Buchstaben
                //sind kleine Buchstaben
                //sind kleine Buchstaben
                //sind kleine Buchstaben
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isMoveValidMove(String [][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer) {
        if ((rowNew == rowOld + 1 || rowNew== rowOld -1) && (columnNew == columnOld + 1 || columnNew == columnOld - 1)) {
            return true;
        }
        return false;
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