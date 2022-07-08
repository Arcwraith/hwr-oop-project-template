package Chess;

public class ChessfieldStatus {
    private final String[][] field = new String[8][8];
    private final WegFrei[][] fieldOfFigures = new WegFrei[8][8];

    public WegFrei[][] getWegFreiArray() {
        return this.fieldOfFigures;
    }   //Should replace the fieldOfFigures in the whole project, but time missing!

    public void setWegFreiArray(int xPos, int yPos, WegFrei figure) {
        fieldOfFigures[xPos][yPos] = figure;
    }

    public String[][] getFieldArray() {
        return this.field;
    }

    public void setFieldArray(int yPos, int xPos, String figure) {
        field[yPos][xPos] = figure;
    }
}
