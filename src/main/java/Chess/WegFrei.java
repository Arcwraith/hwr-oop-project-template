package Chess;

public interface WegFrei {

    boolean isMoveValidMove(String [][] fieldWithFigure, int columnOld, int rowOld, int rowNew, int columnNew, int activePlayer);

    int getPlayer();
    void setPlayer(int player);

    String getBezeichnung();
}