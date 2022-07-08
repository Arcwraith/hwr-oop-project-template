package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LaeuferTest {

    @Test
    void test_istZugMoeglichFuerLaeufer() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Laeufer moveable = new Laeufer();
        boolean zug1Moeglich = moveable.istZugMoeglichFuerLaeufer(3, 3, 6, 6, statusField.getFieldArray());
        boolean zug2Moeglich = moveable.istZugMoeglichFuerLaeufer(3, 3, 0, 0, statusField.getFieldArray());
        boolean zug3Moeglich = moveable.istZugMoeglichFuerLaeufer(3, 3, 6, 0, statusField.getFieldArray());
        boolean zug4Moeglich = moveable.istZugMoeglichFuerLaeufer(3, 3, 0, 6, statusField.getFieldArray());
        boolean zug5Moeglich = moveable.istZugMoeglichFuerLaeufer(4, 4, 0, 5, statusField.getFieldArray());
        boolean zug6Moeglich = moveable.istZugMoeglichFuerLaeufer(4, 4, 7, 7, statusField.getFieldArray());
        boolean zug7Moeglich = moveable.istZugMoeglichFuerLaeufer(4, 4, 7, 1, statusField.getFieldArray());
        boolean zug8Moeglich = moveable.istZugMoeglichFuerLaeufer(4, 4, 1, 7, statusField.getFieldArray());

        boolean move1IsValidMove = moveable.istZugMoeglichFuerLaeufer(3, 3, 6, 6, statusField.getFieldArray());
        boolean move2IsValidMove = moveable.istZugMoeglichFuerLaeufer(3, 3, 0, 0, statusField.getFieldArray());
        boolean move3IsValidMove = moveable.istZugMoeglichFuerLaeufer(3, 3, 6, 0, statusField.getFieldArray());
        boolean move4IsValidMove = moveable.istZugMoeglichFuerLaeufer(3, 3, 0, 6, statusField.getFieldArray());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerLaeufer(7, 7, 5, 5, statusField.getFieldArray());

        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();

        assertThat(zug1Moeglich).isTrue();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();
        assertThat(zug5Moeglich).isFalse();
        assertThat(zug6Moeglich).isTrue();
        assertThat(zug7Moeglich).isTrue();
        assertThat(zug8Moeglich).isTrue();

    }

    @Test
    void testLaeuferSchlaegtGegner() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(6, 6, "b");
        statusField.setFieldArray(1, 1, "B");
        Laeufer moveable = new Laeufer();
        boolean springer1SchlaegtGegner = moveable.laeuferSchlaegtGegner(6, 6, 1, statusField.getFieldArray());
        boolean springer2SchlaegtGegner = moveable.laeuferSchlaegtGegner(1, 1, 1, statusField.getFieldArray());

        Chessfield chessfield = new Chessfield();
        ChessfieldStatus chessfieldStatus = new ChessfieldStatus();
        chessfield.setDefaultValue();
        chessfield.setDisplayedFieldToFieldStatus(chessfieldStatus);
        chessfieldStatus.setFieldArray(0, 0, "L");
        boolean springer3SchlaegtGegner = moveable.laeuferSchlaegtGegner(1, 1, 1, chessfieldStatus.getFieldArray());

        assertThat(springer1SchlaegtGegner).isTrue();
        assertThat(springer2SchlaegtGegner).isFalse();
        assertThat(springer3SchlaegtGegner).isFalse();
    }//[y=row][x=column]

    @Test
    void test_isMoveValidMove() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Laeufer moveable = new Laeufer();

        boolean isValide = moveable.isMoveValidMove(statusField.getFieldArray(), 2, 0, 1, 3, 1);

        field.setDefaultValue();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(2, 0, "L");
        statusField.setFieldArray(1, 3, "l");

        boolean isValide2 = moveable.isMoveValidMove(statusField.getFieldArray(), 2, 0, 1, 3, 1);

        assertThat(isValide).isTrue();
        assertThat(isValide2).isTrue();
    }

    @Test
    void testSpringerGetPlayer() {
        WegFrei springer = new Laeufer();
        assertThat(springer.getPlayer()).isEqualTo(0);
    }

    @Test
    void testSpringerSetPlayer() {
        WegFrei springer = new Laeufer();
        springer.setPlayer(1);
        assertThat(springer.getPlayer()).isEqualTo(1);
    }

    @Test
    void testSpringerGetBezeichnung() {
        WegFrei springer = new Laeufer();
        assertThat(springer.getBezeichnung()).isEqualTo("L");
    }
}
