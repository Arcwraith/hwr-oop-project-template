package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class DameTest {

    @Test
    void test_istZugMoeglichFürDame() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        boolean zug1Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 6, 6, 1, statusField.getFieldArray());
        boolean zug2Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 0, 0, 1, statusField.getFieldArray());
        boolean zug3Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 6, 0, 1, statusField.getFieldArray());
        boolean zug4Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 0, 6, 1, statusField.getFieldArray());
        boolean zug5Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 0, 5, 2, statusField.getFieldArray());
        boolean zug6Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 7, 7, 2, statusField.getFieldArray());
        boolean zug7Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 7, 1, 2, statusField.getFieldArray());
        boolean zug8Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 1, 7, 2, statusField.getFieldArray());

        assertThat(zug1Moeglich).isTrue();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();
        assertThat(zug5Moeglich).isTrue();
        assertThat(zug6Moeglich).isTrue();
        assertThat(zug7Moeglich).isTrue();
        assertThat(zug8Moeglich).isTrue();

        boolean zug9Moeglich = moveable.istZugMoeglichFuerDame(0, 0, 0, 5, 1,  statusField.getFieldArray());
        boolean zug10Moeglich = moveable.istZugMoeglichFuerDame(0, 5, 0, 0, 1,  statusField.getFieldArray());
        boolean zug11Moeglich = moveable.istZugMoeglichFuerDame(0, 0, 5, 0, 1,  statusField.getFieldArray());
        boolean zug12Moeglich = moveable.istZugMoeglichFuerDame(5, 0, 0, 0, 1,  statusField.getFieldArray());
        boolean zug13Moeglich = moveable.istZugMoeglichFuerDame(0, 0, 0, 5, 2,  statusField.getFieldArray());
        boolean zug14Moeglich = moveable.istZugMoeglichFuerDame(0, 5, 0, 0, 2,  statusField.getFieldArray());
        boolean zug15Moeglich = moveable.istZugMoeglichFuerDame(0, 0, 5, 0, 2,  statusField.getFieldArray());
        boolean zug16Moeglich = moveable.istZugMoeglichFuerDame(5, 0, 0, 0, 2,  statusField.getFieldArray());

        assertThat(zug9Moeglich).isTrue();
        assertThat(zug10Moeglich).isTrue();
        assertThat(zug11Moeglich).isTrue();
        assertThat(zug12Moeglich).isTrue();
        assertThat(zug13Moeglich).isTrue();
        assertThat(zug14Moeglich).isTrue();
        assertThat(zug15Moeglich).isTrue();
        assertThat(zug16Moeglich).isTrue();
    }

    @Test
    void test_sameSchlaegtGegner() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        statusField.setFieldArray(6, 6, "b");//Victim
        statusField.setFieldArray(1, 1, "B");//Victim
        boolean dame1SchlaegtGegner = moveable.istZugMoeglichFuerDame(3, 3, 6, 6, 1, statusField.getFieldArray());
        boolean dame2SchlaegtGegner = moveable.istZugMoeglichFuerDame(3, 3, 1, 1, 2, statusField.getFieldArray());
        assertThat(dame1SchlaegtGegner).isTrue();
        assertThat(dame2SchlaegtGegner).isTrue();

        statusField.setFieldArray(4, 4, "t");//Victim
        statusField.setFieldArray(5, 5, "T");//Victim
        boolean dame3SchlaegtGegner = moveable.istZugMoeglichFuerDame(2, 4, 4, 4, 1,  statusField.getFieldArray());
        boolean dame4SchlaegtGegner = moveable.istZugMoeglichFuerDame(2, 5, 5, 5, 2,  statusField.getFieldArray());
        assertThat(dame3SchlaegtGegner).isTrue();
        assertThat(dame4SchlaegtGegner).isTrue();
    }//[y=row][x=column]

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        boolean move1IsValidMove = moveable.istZugMoeglichFuerDame(3, 3, 6, 6, 1,  statusField.getFieldArray());
        boolean move2IsValidMove = moveable.istZugMoeglichFuerDame(3, 3, 0, 0, 2,  statusField.getFieldArray());
        boolean move3IsValidMove = moveable.istZugMoeglichFuerDame(3, 3, 6, 0, 1,  statusField.getFieldArray());
        boolean move4IsValidMove = moveable.istZugMoeglichFuerDame(3, 3, 0, 6, 2,  statusField.getFieldArray());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerDame(7, 7, 5, 5, 1,  statusField.getFieldArray());

        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();

        boolean move6IsValidMove = moveable.istZugMoeglichFuerDame(2, 0, 2, 7, 1,  statusField.getFieldArray());
        boolean move7IsValidMove = moveable.istZugMoeglichFuerDame(4, 7, 4, 0, 2,  statusField.getFieldArray());
        boolean move8IsValidMove = moveable.istZugMoeglichFuerDame(0, 2, 7, 2, 1,  statusField.getFieldArray());
        boolean move9IsValidMove = moveable.istZugMoeglichFuerDame(7, 4, 0, 4, 2,  statusField.getFieldArray());
        boolean move10IsNotValidMove = moveable.istZugMoeglichFuerDame(7, 7, 5, 5, 1,  statusField.getFieldArray());

        assertThat(move6IsValidMove).isTrue();
        assertThat(move7IsValidMove).isTrue();
        assertThat(move8IsValidMove).isTrue();
        assertThat(move9IsValidMove).isTrue();
        assertThat(move10IsNotValidMove).isFalse();
    }

    @Test
    void testDameGetPlayer(){
        WegFrei dame = new Dame();    // 0= not assined, 1= player 1, 2= player 2
        assertThat(dame.getPlayer()).isEqualTo(0);
    }

    @Test
    void testDameSetPlayer(){
        WegFrei dame = new Dame();
        dame.setPlayer(1);
        assertThat(dame.getPlayer()).isEqualTo(1);
    }
}

