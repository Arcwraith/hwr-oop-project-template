package ChessTest;
import Chess.Chessfield;
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
}