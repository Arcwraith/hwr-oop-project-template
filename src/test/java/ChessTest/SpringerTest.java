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
        boolean zug1Moeglich = moveable.istZugMoeglichFürSpringer(3, 3, 6, 6, 1,  field.getFieldWithFigure());
        boolean zug2Moeglich = moveable.istZugMoeglichFürSpringer(3, 3, 0, 0, 1,  field.getFieldWithFigure());
        boolean zug3Moeglich = moveable.istZugMoeglichFürSpringer(3, 3, 6, 0, 1,  field.getFieldWithFigure());
        boolean zug4Moeglich = moveable.istZugMoeglichFürSpringer(3, 3, 0, 6, 1,  field.getFieldWithFigure());
        boolean zug5Moeglich = moveable.istZugMoeglichFürSpringer(4, 4, 0, 5, 2,  field.getFieldWithFigure());
        boolean zug6Moeglich = moveable.istZugMoeglichFürSpringer(4, 4, 7, 7, 2,  field.getFieldWithFigure());
        boolean zug7Moeglich = moveable.istZugMoeglichFürSpringer(4, 4, 7, 1, 2,  field.getFieldWithFigure());
        boolean zug8Moeglich = moveable.istZugMoeglichFürSpringer(4, 4, 1, 7, 2,  field.getFieldWithFigure());

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
        boolean springer1SchlaegtGegner = moveable.istZugMoeglichFürSpringer(3, 3, 6, 6, 1,  field.getFieldWithFigure());
        boolean springer2SchlaegtGegner = moveable.istZugMoeglichFürSpringer(3, 3, 1, 1, 2,  field.getFieldWithFigure());
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
        boolean move1IsValidMove = moveable.istZugMoeglichFürSpringer(3, 3, 6, 6, 1,  field.getFieldWithFigure());
        boolean move2IsValidMove = moveable.istZugMoeglichFürSpringer(3, 3, 0, 0, 2,  field.getFieldWithFigure());
        boolean move3IsValidMove = moveable.istZugMoeglichFürSpringer(3, 3, 6, 0, 1,  field.getFieldWithFigure());
        boolean move4IsValidMove = moveable.istZugMoeglichFürSpringer(3, 3, 0, 6, 2,  field.getFieldWithFigure());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFürSpringer(7, 7, 5, 5, 1,  field.getFieldWithFigure());

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
