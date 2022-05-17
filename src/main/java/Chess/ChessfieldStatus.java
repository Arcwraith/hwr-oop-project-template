package Chess;

public class ChessfieldStatus {
    private final String[][] field = new String[8][8];

    public String[][] getFieldArray() {
        return this.field;
    }

    public void setFieldArray(int xPos, int yPos, String figure) {
        field[yPos][xPos] = figure;
    }
}
