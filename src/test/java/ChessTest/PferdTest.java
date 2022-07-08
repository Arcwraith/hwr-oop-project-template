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
        boolean zug1Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 1, 2);
        boolean zug2Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 1, 4);
        boolean zug3Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 5, 2);
        boolean zug4Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 5, 4);
        boolean zug5Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 2, 5);
        boolean zug6Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 2, 1);
        boolean zug7Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 4, 5);
        boolean zug8Moeglich = moveable.istZugMoeglichFuerPferd(3, 3, 4, 1);

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


        boolean pferd1SchlaegtGegner = moveable.pferdSchlaegtGegner(4,4,1,statusField.getFieldArray());
        boolean pferd2SchlaegtGegner = moveable.pferdSchlaegtGegner(5,5,2,statusField.getFieldArray());

        statusField.setFieldArray(5, 5, " ");
        boolean pferd3SchleagtGegner = moveable.pferdSchlaegtGegner(5,5,2,statusField.getFieldArray());

        statusField.setFieldArray(5, 5, "B");
        boolean willNeverHappen = moveable.pferdSchlaegtGegner(5,5,0, statusField.getFieldArray());


        assertThat(pferd1SchlaegtGegner).isTrue();
        assertThat(pferd2SchlaegtGegner).isTrue();
        assertThat(pferd3SchleagtGegner).isFalse();
        assertThat(willNeverHappen).isFalse();
    }

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Pferd moveable = new Pferd();

        boolean move1IsValidMove = moveable.istZugMoeglichFuerPferd(2,0,3,2);
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerPferd(7, 7, 5, 5);

        statusField.setFieldArray(5,5,"b");
        boolean move2IsValideMove = moveable.isMoveValidMove(statusField.getFieldArray(),5,5,3,4,1);
        statusField.setFieldArray(5,5,"B");
        boolean move3IsValideMove = moveable.isMoveValidMove(statusField.getFieldArray(),5,5,3,4,2);

        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValideMove).isTrue();
        assertThat(move3IsValideMove).isTrue();
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

    @Test
    void testPferdGetBezeichnung(){
        WegFrei pferd = new Pferd();
        assertThat(pferd.getBezeichnung()).isEqualTo("S");
    }
}
