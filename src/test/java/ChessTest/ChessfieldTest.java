package ChessTest;
import Chess.Chessfield;
import Chess.ChessfieldStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChessfieldTest {

    @Test
    void testOfSetupFigureArray() {
        Chessfield chessfield = new Chessfield();
        chessfield.setupFigureArray();
        String[][] second = chessfield.getFieldWithFigure();
        String[][] emptyArray = new String[8][8];
        assertThat(second).isNotEqualTo(emptyArray);
    }

    @Test
    void testOfDisplayFieldWithFiguresAndSetDisplayFieldToStatusField(){
        Chessfield chessfield = new Chessfield();
        ChessfieldStatus status = new ChessfieldStatus();
        //Chessfield chessfield = new Chessfield();
        PrintStream ps = chessfield.displayFieldWithFigures();
        System.out.println("\n" +
                " A  B  C  D  E  F  G  H\n" +
                "|T||S||L||D||K||L||S||T| 1\n" +
                "|B||B||B||B||B||B||B||B| 2\n" +
                "| || || || || || || || | 3\n" +
                "| || || || || || || || | 4\n" +
                "| || || || || || || || | 5\n" +
                "| || || || || || || || | 6\n" +
                "|b||b||b||b||b||b||b||b| 7\n" +
                "|t||s||l||k||d||l||s||t| 8");
        PrintStream compare = System.out;
        assertThat(ps).isEqualTo(compare);

        String[][] field = chessfield.getFieldWithFigure();
        chessfield.setDisplayedFieldToFieldStatus(status);
        String[][] statusField = status.getFieldArray();
        assertThat(field).isEqualTo(statusField);
    }
    @Test
    void testGetFieldWithFigure(){
        Chessfield chessfield = new Chessfield();
        String[][] field = new String[8][8];
        assertThat(field).isEqualTo(chessfield.getFieldWithFigure());
    }
}