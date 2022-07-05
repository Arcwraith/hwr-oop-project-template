package Chess;

public class ChessfieldStatus {
    private final String[][] field = new String[8][8];
    private WegFrei [][] fieldOfFigures = new WegFrei[8][8];    //Filed with figures

    public WegFrei[][] getWegFreiArray(){return this.fieldOfFigures;}   //Ersetzen des field array komplett !

    public void setWegFreiArray(int xPos, int yPos, WegFrei figure){
        fieldOfFigures[xPos][yPos]=figure;
    }
    public String[][] getFieldArray() {
        return this.field;
    }

    public void setFieldArray(int xPos, int yPos, String figure) {
        field[yPos][xPos] = figure;
    }
}
