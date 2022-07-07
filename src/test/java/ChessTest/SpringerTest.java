package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpringerTest {

    @Test
    void test_istZugMoeglichFürSpringer() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Springer moveable = new Springer();
        boolean zug1Moeglich = moveable.istZugMoeglichFuerSpringer(3, 3, 6, 6, 1, statusField.getFieldArray());
        boolean zug2Moeglich = moveable.istZugMoeglichFuerSpringer(3, 3, 0, 0, 1, statusField.getFieldArray());
        boolean zug3Moeglich = moveable.istZugMoeglichFuerSpringer(3, 3, 6, 0, 1, statusField.getFieldArray());
        boolean zug4Moeglich = moveable.istZugMoeglichFuerSpringer(3, 3, 0, 6, 1, statusField.getFieldArray());
        boolean zug5Moeglich = moveable.istZugMoeglichFuerSpringer(4, 4, 0, 5, 2, statusField.getFieldArray());
        boolean zug6Moeglich = moveable.istZugMoeglichFuerSpringer(4, 4, 7, 7, 2, statusField.getFieldArray());
        boolean zug7Moeglich = moveable.istZugMoeglichFuerSpringer(4, 4, 7, 1, 2, statusField.getFieldArray());
        boolean zug8Moeglich = moveable.istZugMoeglichFuerSpringer(4, 4, 1, 7, 2, statusField.getFieldArray());

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
    void test_springerSchlaegtGegner() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(6, 6, "b");//Victim
        statusField.setFieldArray(1, 1, "B");//Victim
        Springer moveable = new Springer();
        boolean springer1SchlaegtGegner = moveable.istZugMoeglichFuerSpringer(3, 3, 6, 6, 1,  statusField.getFieldArray());
        boolean springer2SchlaegtGegner = moveable.istZugMoeglichFuerSpringer(3, 3, 1, 1, 2,  statusField.getFieldArray());
        assertThat(springer1SchlaegtGegner).isTrue();
        assertThat(springer2SchlaegtGegner).isTrue();
    }//[y=row][x=column]

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Springer moveable = new Springer();
        boolean move1IsValidMove = moveable.istZugMoeglichFuerSpringer(3, 3, 6, 6, 1, statusField.getFieldArray());
        boolean move2IsValidMove = moveable.istZugMoeglichFuerSpringer(3, 3, 0, 0, 2, statusField.getFieldArray());
        boolean move3IsValidMove = moveable.istZugMoeglichFuerSpringer(3, 3, 6, 0, 1, statusField.getFieldArray());
        boolean move4IsValidMove = moveable.istZugMoeglichFuerSpringer(3, 3, 0, 6, 2, statusField.getFieldArray());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerSpringer(7, 7, 5, 5, 1, statusField.getFieldArray());

        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();
    }

    @Test
    void testSpringerGetPlayer(){
        WegFrei springer = new Springer();    // 0= not assined, 1= player 1, 2= player 2
        assertThat(springer.getPlayer()).isEqualTo(0);
    }

    @Test
    void testSpringerSetPlayer(){
        WegFrei springer = new Springer();
        springer.setPlayer(1);
        assertThat(springer.getPlayer()).isEqualTo(1);
    }
}
