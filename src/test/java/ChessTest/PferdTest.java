package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PferdTest {

    @Test
    void test_istZugMoeglichFuerPferd() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Pferd moveable = new Pferd();
        boolean zug1Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 1, 2, 1,  statusField.getFieldArray());
        boolean zug2Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 1, 4, 1,  statusField.getFieldArray());
        boolean zug3Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 5, 2, 1,  statusField.getFieldArray());
        boolean zug4Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 5, 4, 1,  statusField.getFieldArray());
        boolean zug5Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 2, 5, 2,  statusField.getFieldArray());
        boolean zug6Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 2, 1, 2,  statusField.getFieldArray());
        boolean zug7Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 4, 5, 2,  statusField.getFieldArray());
        boolean zug8Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 4, 1, 2,  statusField.getFieldArray());
        assertThat(zug1Moeglich).isTrue();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();
        assertThat(zug5Moeglich).isTrue();
        assertThat(zug6Moeglich).isTrue();
        assertThat(zug7Moeglich).isTrue();
        assertThat(zug8Moeglich).isTrue();

    }

    @Test
    void test_pferdSchlaegtGegner() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(4, 4, "b");//Victim
        statusField.setFieldArray(5, 5, "B");//Victim
        Pferd moveable = new Pferd();
        boolean pferd1SchlaegtGegner = moveable.istZugMoeglichFuerPferd(2, 3, 4, 4, 1,  statusField.getFieldArray());
        boolean pferd2SchlaegtGegner = moveable.istZugMoeglichFuerPferd(7, 4, 5, 5, 2,  statusField.getFieldArray());

        assertThat(pferd1SchlaegtGegner).isTrue();
        assertThat(pferd2SchlaegtGegner).isTrue();
    }

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Pferd moveable = new Pferd();
        boolean move1IsValidMove = moveable.istZugMoeglichFuerPferd(2, 0, 3, 2, 1,  statusField.getFieldArray());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerPferd(7, 7, 5, 5, 1,  statusField.getFieldArray());

        assertThat(move1IsValidMove).isTrue();
        /*assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();*/
        assertThat(move5IsNotValidMove).isFalse();
    }

    @Test
    void testPferdGetPlayer(){
        WegFrei pferd = new Pferd();    // 0= not assined, 1= player 1, 2= player 2
        assertThat(pferd.getPlayer()).isEqualTo(0);
    }

    @Test
    void testPferdSetPlayer(){
        WegFrei pferd = new Pferd();
        pferd.setPlayer(1);
        assertThat(pferd.getPlayer()).isEqualTo(1);
    }
}
