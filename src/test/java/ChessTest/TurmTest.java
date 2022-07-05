package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TurmTest {

    @Test
    void test_istZugMoeglichFürTurm() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Turm moveable = new Turm();
        boolean zug1Moeglich = moveable.istZugMoeglichFürTurm(0, 0, 0, 5, 1,  field.getFieldWithFigure());
        boolean zug2Moeglich = moveable.istZugMoeglichFürTurm(0, 5, 0, 0, 1,  field.getFieldWithFigure());
        boolean zug3Moeglich = moveable.istZugMoeglichFürTurm(0, 0, 5, 0, 1,  field.getFieldWithFigure());
        boolean zug4Moeglich = moveable.istZugMoeglichFürTurm(5, 0, 0, 0, 1,  field.getFieldWithFigure());
        boolean zug5Moeglich = moveable.istZugMoeglichFürTurm(0, 0, 0, 5, 2,  field.getFieldWithFigure());
        boolean zug6Moeglich = moveable.istZugMoeglichFürTurm(0, 5, 0, 0, 2,  field.getFieldWithFigure());
        boolean zug7Moeglich = moveable.istZugMoeglichFürTurm(0, 0, 5, 0, 2,  field.getFieldWithFigure());
        boolean zug8Moeglich = moveable.istZugMoeglichFürTurm(5, 0, 0, 0, 2,  field.getFieldWithFigure());
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
    void test_turmSchlaegtGegner() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(4, 4, "t");//Victim
        statusField.setFieldArray(5, 5, "T");//Victim
        Turm moveable = new Turm();
        boolean turm1SchlaegtGegner = moveable.istZugMoeglichFürTurm(2, 4, 4, 4, 1,  field.getFieldWithFigure());
        boolean turm2SchlaegtGegner = moveable.istZugMoeglichFürTurm(2, 5, 5, 5, 2,  field.getFieldWithFigure());
        assertThat(turm1SchlaegtGegner).isTrue();
        assertThat(turm2SchlaegtGegner).isTrue();
    }//[y=row][x=column]

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Turm moveable = new Turm();
        boolean move1IsValidMove = moveable.istZugMoeglichFürTurm(2, 0, 2, 7, 1,  field.getFieldWithFigure());
        boolean move2IsValidMove = moveable.istZugMoeglichFürTurm(4, 7, 4, 0, 2,  field.getFieldWithFigure());
        boolean move3IsValidMove = moveable.istZugMoeglichFürTurm(0, 2, 7, 2, 1,  field.getFieldWithFigure());
        boolean move4IsValidMove = moveable.istZugMoeglichFürTurm(7, 4, 0, 4, 2,  field.getFieldWithFigure());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFürTurm(7, 7, 5, 5, 1,  field.getFieldWithFigure());

        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();
    }

    @Test
    void testTurmGetPlayer(){
        WegFrei turm = new Turm();    // 0= not assined, 1= player 1, 2= player 2
        assertThat(turm.getPlayer()).isEqualTo(0);
    }

    @Test
    void testTurmSetPlayer(){
        WegFrei turm = new Turm();
        turm.setPlayer(1);
        assertThat(turm.getPlayer()).isEqualTo(1);
    }
    }
