package Chess;

public interface WegFrei {
    //Add int var for WhiteOrBlack to every Figure
    boolean isMoveValidMove(String [][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer);

    int getPlayer();
    void setPlayer(int player);
}