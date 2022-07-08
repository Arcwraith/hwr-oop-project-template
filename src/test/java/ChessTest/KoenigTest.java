package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import java.nio.file.WatchEvent;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class KoenigTest {

    @Test
    void test_istZugMoeglichFuerKoenig() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Koenig moveable = new Koenig();

        //Fix Moves
        boolean zug3Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 4, 3);
        boolean zug5Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 3, 2);
        boolean zug6Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 2, 3);
        boolean zug7Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 3, 4);
        boolean zug8Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 4, 3);

        assertThat(zug3Moeglich).isTrue();
        assertThat(zug5Moeglich).isTrue();
        assertThat(zug6Moeglich).isTrue();
        assertThat(zug7Moeglich).isTrue();
        assertThat(zug8Moeglich).isTrue();

    }

    @Test
    void test_KoenigSchlaegtGegner() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(4, 4, "b");
        statusField.setFieldArray(5, 5, "B");
        Koenig moveable = new Koenig();
        boolean koenig1SchlaegtGegner = moveable.koenigSchlaegtGegner(4, 4, 1, statusField.getFieldArray());
        boolean koenig2SchlaegtGegner = moveable.koenigSchlaegtGegner(5, 5, 2, statusField.getFieldArray());
        boolean koenig3SchlaetGegner = moveable.koenigSchlaegtGegner(5, 5, 0, statusField.getFieldArray());
        boolean koenig4SchlaetGegner = moveable.koenigSchlaegtGegner(3, 3, 1, statusField.getFieldArray());

        assertThat(koenig1SchlaegtGegner).isTrue();
        assertThat(koenig2SchlaegtGegner).isTrue();
        assertThat(koenig3SchlaetGegner).isFalse();
        assertThat(koenig4SchlaetGegner).isFalse();
    }

    @Test
    void test_isMoveValidMove() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Koenig moveable = new Koenig();
        boolean move1IsValidMove = moveable.istZugMoeglichFuerKoenig(0, 0, 1, 0);
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerKoenig(7, 7, 5, 5);

        statusField.setFieldArray(1, 1, "t");
        statusField.setFieldArray(2, 2, "T");

        boolean move2IsValidMove = moveable.isMoveValidMove(statusField.getFieldArray(), 0, 0, 1, 1, 1);
        boolean move3IsValidMove = moveable.isMoveValidMove(statusField.getFieldArray(), 3, 3, 2, 2, 2);

        assertThat(move1IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();
        assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
    }

    @Test
    void testKoenigGetPlayer() {
        WegFrei pferd = new Koenig();
        assertThat(pferd.getPlayer()).isEqualTo(0);
    }

    @Test
    void testKoenigSetPlayer() {
        WegFrei pferd = new Koenig();
        pferd.setPlayer(1);
        assertThat(pferd.getPlayer()).isEqualTo(1);
    }

    @Test
    void testKoenigGetBezeichnung() {
        WegFrei koenig = new Koenig();
        assertThat(koenig.getBezeichnung()).isEqualTo("K");
    }
}
