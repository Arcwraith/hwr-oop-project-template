package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TurmTest {

    @Test
    void test_istZugMoeglichFuerTurm() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Turm moveable = new Turm();

        statusField.setFieldArray(0,1," ");
        statusField.setFieldArray(0,2," ");
        statusField.setFieldArray(0,3," ");
        statusField.setFieldArray(0,4," ");
        statusField.setFieldArray(0,5," ");

        boolean zug1Moeglich = moveable.istZugMoeglichFuerTurm(0,0,0,0,statusField.getFieldArray());
        boolean zug2Moeglich = moveable.istZugMoeglichFuerTurm(0,5,0,0,statusField.getFieldArray());

        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);

        boolean zug3Moeglich = moveable.istZugMoeglichFuerTurm(0,0,1,1,statusField.getFieldArray());
        boolean zug4Moeglich = moveable.istZugMoeglichFuerTurm(5,0,0,0,statusField.getFieldArray());

        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(0,1," ");
        statusField.setFieldArray(0,2," ");
        statusField.setFieldArray(0,3," ");
        statusField.setFieldArray(0,4," ");
        statusField.setFieldArray(0,5," ");

        boolean zug5Moeglich = moveable.istZugMoeglichFuerTurm(0,0,5,0,statusField.getFieldArray());
        boolean zug6Moeglich = moveable.istZugMoeglichFuerTurm(0,5,0,0,statusField.getFieldArray());

        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(0,1," ");
        statusField.setFieldArray(0,2," ");
        statusField.setFieldArray(0,3," ");
        statusField.setFieldArray(0,4," ");
        statusField.setFieldArray(0,5," ");

        boolean zug7Moeglich = moveable.istZugMoeglichFuerTurm(0,0,0,5,statusField.getFieldArray());
        boolean zug8Moeglich = moveable.istZugMoeglichFuerTurm(5,0,0,0,statusField.getFieldArray());

        assertThat(zug1Moeglich).isFalse();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isFalse();
        assertThat(zug4Moeglich).isTrue();
        assertThat(zug5Moeglich).isTrue();
        assertThat(zug6Moeglich).isTrue();
        assertThat(zug7Moeglich).isTrue();
        assertThat(zug8Moeglich).isTrue();

        boolean move1IsValidMove = moveable.istZugMoeglichFuerTurm(2,0,2,7,statusField.getFieldArray());
        boolean move2IsValidMove = moveable.istZugMoeglichFuerTurm(4,7,7,2,statusField.getFieldArray());
        boolean move3IsValidMove = moveable.istZugMoeglichFuerTurm(0,2,7,2,statusField.getFieldArray());
        boolean move4IsValidMove = moveable.istZugMoeglichFuerTurm(7,4,0,4,statusField.getFieldArray());
        boolean move5IsNotValidMove = moveable.istZugMoeglichFuerTurm(7,7,5,5,statusField.getFieldArray());


        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValidMove).isFalse();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isFalse();
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
        boolean turm1SchlaegtGegner = moveable.turmSchlaegtGegner(4,4 ,1,statusField.getFieldArray());
        boolean turm2SchlaegtGegner = moveable.turmSchlaegtGegner(5,5 ,2,statusField.getFieldArray());

        statusField.setFieldArray(5, 5, "T");//Victim
        boolean turm3SchlaegtGegner = moveable.turmSchlaegtGegner(5,5 ,1,statusField.getFieldArray());


        assertThat(turm1SchlaegtGegner).isTrue();
        assertThat(turm2SchlaegtGegner).isTrue();
        assertThat(turm3SchlaegtGegner).isFalse();
    }

    @Test
    void test_isMoveValidMove() {
        Chessfield chessfield = new Chessfield();
        ChessfieldStatus chessfieldStatus = new ChessfieldStatus();
        chessfield.setupFigureArrays();
        chessfield.setDisplayedFieldToFieldStatus(chessfieldStatus);
        WegFrei turm = new Turm();
        chessfieldStatus.setFieldArray(0,0,"T");
        boolean isValide = turm.isMoveValidMove(chessfieldStatus.getFieldArray(),0,0,0,5,1);
        boolean isValide2 = turm.isMoveValidMove(chessfieldStatus.getFieldArray(),0,0,5,5,2);

        chessfieldStatus.setFieldArray(0,1,"T");
        chessfieldStatus.setFieldArray(1,1,"t");
        boolean isValide3 = turm.isMoveValidMove(chessfieldStatus.getFieldArray(), 0,1,1,1,1);

        assertThat(isValide).isTrue();
        assertThat(isValide2).isFalse();
        assertThat(isValide3).isTrue();
    }

    @Test
    void testTurmGetPlayer() {
        WegFrei turm = new Turm();    // 0= not assined, 1= player 1, 2= player 2
        assertThat(turm.getPlayer()).isEqualTo(0);
    }

    @Test
    void testTurmSetPlayer() {
        WegFrei turm = new Turm();
        turm.setPlayer(1);
        assertThat(turm.getPlayer()).isEqualTo(1);
    }

    @Test
    void testTurmGetBezeichnung() {
        WegFrei turm = new Turm();
        assertThat(turm.getBezeichnung()).isEqualTo("T");
    }
}
