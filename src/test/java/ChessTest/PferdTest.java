package ChessTest;

import Chess.Chessfield;
import Chess.ChessfieldStatus;
import Chess.Pferd;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PferdTest {

    @Test
    void test_istZugMoeglichFürPferd() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        Pferd moveable = new Pferd();
        boolean zug1Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 1, 2, 1,  field.getFieldWithFigure());
        boolean zug2Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 1, 4, 1,  field.getFieldWithFigure());
        boolean zug3Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 5, 2, 1,  field.getFieldWithFigure());
        boolean zug4Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 5, 4, 1,  field.getFieldWithFigure());
        boolean zug5Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 2, 5, 2,  field.getFieldWithFigure());
        boolean zug6Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 2, 1, 2,  field.getFieldWithFigure());
        boolean zug7Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 4, 5, 2,  field.getFieldWithFigure());
        boolean zug8Moeglich = moveable.istZugMoeglichFürPferd(3, 3, 4, 1, 2,  field.getFieldWithFigure());
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
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(4, 4, "b");//Victim
        statusField.setFieldArray(5, 5, "B");//Victim
        Pferd moveable = new Pferd();
        boolean turm1SchlaegtGegner = moveable.istZugMoeglichFürPferd(2, 3, 4, 4, 1,  field.getFieldWithFigure());
        boolean turm2SchlaegtGegner = moveable.istZugMoeglichFürPferd(7, 4, 5, 5, 2,  field.getFieldWithFigure());
        assertThat(turm1SchlaegtGegner).isTrue();
        assertThat(turm2SchlaegtGegner).isTrue();
    }//[y=row][x=column]

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        Pferd moveable = new Pferd();
        boolean move1IsValidMove = moveable.istZugMoeglichFürPferd(2, 0, 3, 2, 1,  field.getFieldWithFigure());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFürPferd(7, 7, 5, 5, 1,  field.getFieldWithFigure());

        assertThat(move1IsValidMove).isTrue();
        /*assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();*/
        assertThat(move5IsNotValidMove).isFalse();
    }
}
