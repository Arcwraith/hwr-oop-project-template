package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

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
        boolean zug3Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 4, 3, 1, statusField.getFieldArray());
        boolean zug4Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 3, 4, 1, statusField.getFieldArray());
        boolean zug5Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 3, 2, 2, statusField.getFieldArray());
        boolean zug6Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 2, 3, 2, statusField.getFieldArray());
        boolean zug7Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 3, 4, 2, statusField.getFieldArray());
        boolean zug8Moeglich = moveable.istZugMoeglichFuerKoenig(3, 3, 4, 3, 2, statusField.getFieldArray());

        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();
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
        statusField.setFieldArray(4, 4, "b");//Victim
        statusField.setFieldArray(5, 5, "B");//Victim
        Koenig moveable = new Koenig();
        boolean pferd1SchlaegtGegner = moveable.istZugMoeglichFuerKoenig(4, 3, 4, 4, 1, statusField.getFieldArray());
        boolean pferd2SchlaegtGegner = moveable.istZugMoeglichFuerKoenig(5, 4, 5, 5, 2, statusField.getFieldArray());

        assertThat(pferd1SchlaegtGegner).isTrue();
        assertThat(pferd2SchlaegtGegner).isTrue();
    }

    @Test
    void test_isMoveValidMove() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Koenig moveable = new Koenig();
        boolean move1IsValidMove = moveable.istZugMoeglichFuerKoenig(0, 0, 1, 0, 1, statusField.getFieldArray());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerKoenig(7, 7, 5, 5, 1, statusField.getFieldArray());

        assertThat(move1IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();
    }

    @Test
    void testKoenigGetPlayer() {
        WegFrei pferd = new Koenig();    // 0= not assined, 1= player 1, 2= player 2
        assertThat(pferd.getPlayer()).isEqualTo(0);
    }

    @Test
    void testKoenigSetPlayer() {
        WegFrei pferd = new Koenig();
        pferd.setPlayer(1);
        assertThat(pferd.getPlayer()).isEqualTo(1);
    }
}
