package Chess;

public class Turm implements WegFrei {
    private int player = 0;
    private String bezeichnung = "T";

    public boolean istZugMoeglichFuerTurm(int rowOld, int columnOld, int rowNew, int columnNew, String[][] fieldWithFigure) {
        for (int i = 1; i < 8; i++) {
            for (int j = columnOld + 1; j < columnNew; j++) {
                if (columnNew == columnOld + i && rowNew == rowOld && fieldWithFigure[rowNew][j].equals(" ")) {
                    return true;
                }
            }
            for (int j = columnOld - 1; j > columnNew; j--) {
                if (columnNew == columnOld - i && rowNew == rowOld && fieldWithFigure[rowNew][j].equals(" ")) {
                    return true;
                }
            }
            for (int j = rowOld + 1; j < rowNew; j++) {
                if (columnNew == columnOld && rowNew == rowOld + i && fieldWithFigure[j][columnNew].equals(" ")) {
                    return true;
                }
            }
            for (int j = rowOld - 1; j > rowNew; j--) {
                if (columnNew == columnOld && rowNew == rowOld - i && fieldWithFigure[j][columnNew].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean turmSchlaegtGegner(int rowNew, int columnNew, int activePlayer, String[][] fieldWithFigure) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        if (fieldWithFigure[rowNew][columnNew].equals(" ")) {
            return false;
        }
        if (activePlayer == 1) {
            if (!checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew])) {
                //sind gr0ße Buchstaben
                return true;
            }
        }
        if (activePlayer == 2) {
            //sind kleine Buchstaben
            return checkIfMoveable.isUpper(fieldWithFigure[rowNew][columnNew]);
        }
        return false;
    }

    @Override
    public boolean isMoveValidMove(String[][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer) {
        if ((activePlayer == 1 && istZugMoeglichFuerTurm(rowOld, columnOld, rowNew, columnNew, fieldWithFigure) && fieldWithFigure[rowNew][columnNew].equals(" ")) || (turmSchlaegtGegner(rowNew, columnNew, 1, fieldWithFigure))) {
            return true;
        } else {
            return (activePlayer == 2 && istZugMoeglichFuerTurm(rowOld, columnOld, rowNew, columnNew, fieldWithFigure) && fieldWithFigure[rowNew][columnNew].equals(" ")) || (turmSchlaegtGegner(rowNew, columnNew, 2, fieldWithFigure));
        }
    }

    @Override
    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public int getPlayer() {
        return this.player;
    }

    @Override
    public String getBezeichnung() {
        return bezeichnung;
    }
}