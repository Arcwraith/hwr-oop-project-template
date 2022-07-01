package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class DameTest {

    @Test
    void test_istZugMoeglichFürDame() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        boolean zug1Moeglich = moveable.istZugMoeglichFürDame(3, 3, 6, 6, 1,  field.getFieldWithFigure());
        boolean zug2Moeglich = moveable.istZugMoeglichFürDame(3, 3, 0, 0, 1,  field.getFieldWithFigure());
        boolean zug3Moeglich = moveable.istZugMoeglichFürDame(3, 3, 6, 0, 1,  field.getFieldWithFigure());
        boolean zug4Moeglich = moveable.istZugMoeglichFürDame(3, 3, 0, 6, 1,  field.getFieldWithFigure());
        boolean zug5Moeglich = moveable.istZugMoeglichFürDame(4, 4, 0, 5, 2,  field.getFieldWithFigure());
        boolean zug6Moeglich = moveable.istZugMoeglichFürDame(4, 4, 7, 7, 2,  field.getFieldWithFigure());
        boolean zug7Moeglich = moveable.istZugMoeglichFürDame(4, 4, 7, 1, 2,  field.getFieldWithFigure());
        boolean zug8Moeglich = moveable.istZugMoeglichFürDame(4, 4, 1, 7, 2,  field.getFieldWithFigure());

        assertThat(zug1Moeglich).isTrue();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();
        assertThat(zug5Moeglich).isTrue();
        assertThat(zug6Moeglich).isTrue();
        assertThat(zug7Moeglich).isTrue();
        assertThat(zug8Moeglich).isTrue();

        boolean zug9Moeglich = moveable.istZugMoeglichFürDame(0, 0, 0, 5, 1,  field.getFieldWithFigure());
        boolean zug10Moeglich = moveable.istZugMoeglichFürDame(0, 5, 0, 0, 1,  field.getFieldWithFigure());
        boolean zug11Moeglich = moveable.istZugMoeglichFürDame(0, 0, 5, 0, 1,  field.getFieldWithFigure());
        boolean zug12Moeglich = moveable.istZugMoeglichFürDame(5, 0, 0, 0, 1,  field.getFieldWithFigure());
        boolean zug13Moeglich = moveable.istZugMoeglichFürDame(0, 0, 0, 5, 2,  field.getFieldWithFigure());
        boolean zug14Moeglich = moveable.istZugMoeglichFürDame(0, 5, 0, 0, 2,  field.getFieldWithFigure());
        boolean zug15Moeglich = moveable.istZugMoeglichFürDame(0, 0, 5, 0, 2,  field.getFieldWithFigure());
        boolean zug16Moeglich = moveable.istZugMoeglichFürDame(5, 0, 0, 0, 2,  field.getFieldWithFigure());

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
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        statusField.setFieldArray(6, 6, "b");//Victim
        statusField.setFieldArray(1, 1, "B");//Victim
        boolean dame1SchlaegtGegner = moveable.istZugMoeglichFürDame(3, 3, 6, 6, 1,  field.getFieldWithFigure());
        boolean dame2SchlaegtGegner = moveable.istZugMoeglichFürDame(3, 3, 1, 1, 2,  field.getFieldWithFigure());
        assertThat(dame1SchlaegtGegner).isTrue();
        assertThat(dame2SchlaegtGegner).isTrue();

        statusField.setFieldArray(4, 4, "t");//Victim
        statusField.setFieldArray(5, 5, "T");//Victim
        boolean dame3SchlaegtGegner = moveable.istZugMoeglichFürDame(2, 4, 4, 4, 1,  field.getFieldWithFigure());
        boolean dame4SchlaegtGegner = moveable.istZugMoeglichFürDame(2, 5, 5, 5, 2,  field.getFieldWithFigure());
        assertThat(dame3SchlaegtGegner).isTrue();
        assertThat(dame4SchlaegtGegner).isTrue();
    }//[y=row][x=column]

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        boolean move1IsValidMove = moveable.istZugMoeglichFürDame(3, 3, 6, 6, 1,  field.getFieldWithFigure());
        boolean move2IsValidMove = moveable.istZugMoeglichFürDame(3, 3, 0, 0, 2,  field.getFieldWithFigure());
        boolean move3IsValidMove = moveable.istZugMoeglichFürDame(3, 3, 6, 0, 1,  field.getFieldWithFigure());
        boolean move4IsValidMove = moveable.istZugMoeglichFürDame(3, 3, 0, 6, 2,  field.getFieldWithFigure());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFürDame(7, 7, 5, 5, 1,  field.getFieldWithFigure());

        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();

        boolean move6IsValidMove = moveable.istZugMoeglichFürDame(2, 0, 2, 7, 1,  field.getFieldWithFigure());
        boolean move7IsValidMove = moveable.istZugMoeglichFürDame(4, 7, 4, 0, 2,  field.getFieldWithFigure());
        boolean move8IsValidMove = moveable.istZugMoeglichFürDame(0, 2, 7, 2, 1,  field.getFieldWithFigure());
        boolean move9IsValidMove = moveable.istZugMoeglichFürDame(7, 4, 0, 4, 2,  field.getFieldWithFigure());
        boolean move10IsNotValidMove = moveable.istZugMoeglichFürDame(7, 7, 5, 5, 1,  field.getFieldWithFigure());

        assertThat(move6IsValidMove).isTrue();
        assertThat(move7IsValidMove).isTrue();
        assertThat(move8IsValidMove).isTrue();
        assertThat(move9IsValidMove).isTrue();
        assertThat(move10IsNotValidMove).isFalse();
    }
}

