package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class DameTest {

    @Test
    void test_istZugMoeglichFuerDame() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        boolean zug1Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 6, 6,  statusField.getFieldArray());
        boolean zug2Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 0, 0,  statusField.getFieldArray());
        boolean zug3Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 6, 0,  statusField.getFieldArray());
        boolean zug4Moeglich = moveable.istZugMoeglichFuerDame(3, 3, 0, 6,  statusField.getFieldArray());
        boolean zug5Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 0, 5,  statusField.getFieldArray());
        boolean zug6Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 7, 7,  statusField.getFieldArray());
        boolean zug7Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 7, 1,  statusField.getFieldArray());
        boolean zug8Moeglich = moveable.istZugMoeglichFuerDame(4, 4, 1, 7,  statusField.getFieldArray());

        assertThat(zug1Moeglich).isTrue();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();
        assertThat(zug5Moeglich).isFalse();
        assertThat(zug6Moeglich).isTrue();
        assertThat(zug7Moeglich).isTrue();
        assertThat(zug8Moeglich).isTrue();

        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(0,1," ");
        statusField.setFieldArray(0,2," ");
        statusField.setFieldArray(0,3," ");
        statusField.setFieldArray(0,4," ");
        statusField.setFieldArray(0,5," ");

        boolean zug9Moeglich = moveable.istZugMoeglichFuerDame(0, 0, 0, 5,   statusField.getFieldArray());
        boolean zug10Moeglich = moveable.istZugMoeglichFuerDame(0, 5, 0, 0,   statusField.getFieldArray());

        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(0,1," ");
        statusField.setFieldArray(0,2," ");
        statusField.setFieldArray(0,3," ");
        statusField.setFieldArray(0,4," ");
        statusField.setFieldArray(0,5," ");

        boolean zug11Moeglich = moveable.istZugMoeglichFuerDame(0, 0, 5, 0,   statusField.getFieldArray());
        boolean zug12Moeglich = moveable.istZugMoeglichFuerDame(5, 0, 0, 0,   statusField.getFieldArray());

        assertThat(zug9Moeglich).isTrue();
        assertThat(zug10Moeglich).isTrue();
        assertThat(zug11Moeglich).isTrue();
        assertThat(zug12Moeglich).isTrue();
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
        boolean dame1SchlaegtGegner = moveable.isMoveValidMove(statusField.getFieldArray(),3, 3, 6, 6, 1);
        boolean dame2SchlaegtGegner = moveable.isMoveValidMove(statusField.getFieldArray(),3, 3, 1, 1, 2);
        assertThat(dame1SchlaegtGegner).isTrue();
        assertThat(dame2SchlaegtGegner).isTrue();

        statusField.setFieldArray(4, 4, "t");//Victim
        statusField.setFieldArray(5, 5, "T");//Victim
        boolean dame3SchlaegtGegner = moveable.istZugMoeglichFuerDame(2, 4, 4, 4,   statusField.getFieldArray());
        boolean dame4SchlaegtGegner = moveable.istZugMoeglichFuerDame(2, 5, 5, 5,   statusField.getFieldArray());
        assertThat(dame3SchlaegtGegner).isTrue();
        assertThat(dame4SchlaegtGegner).isTrue();

        statusField.setFieldArray(5, 5, "t");//Victim
        boolean dame5SchlaegtGegnerNicht = moveable.dameSchlaegtGegner(5,5,2, statusField.getFieldArray());

        statusField.setFieldArray(6,6," ");
        boolean dame6SchlaegtNicht = moveable.dameSchlaegtGegner(6,6,2, statusField.getFieldArray());

        assertThat(dame5SchlaegtGegnerNicht).isFalse();
        assertThat(dame6SchlaegtNicht).isFalse();
    }//[y=row][x=column]

    @Test
    void test_isMoveValidMove(){
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Dame moveable = new Dame();
        boolean move1IsValidMove = moveable.isMoveValidMove(statusField.getFieldArray(),3, 3, 6, 6,  1);
        boolean move2IsValidMove = moveable.isMoveValidMove(statusField.getFieldArray(),3, 3, 0, 0,  1);
        boolean move3IsValidMove = moveable.isMoveValidMove(statusField.getFieldArray(),3, 3, 6, 0,   1);
        boolean move4IsValidMove = moveable.isMoveValidMove(statusField.getFieldArray(),3, 3, 0, 6,   1);
        boolean move5IsNotValidMove = moveable.isMoveValidMove(statusField.getFieldArray(),7, 7, 5, 5, 1);

        assertThat(move1IsValidMove).isTrue();
        assertThat(move2IsValidMove).isTrue();
        assertThat(move3IsValidMove).isTrue();
        assertThat(move4IsValidMove).isTrue();
        assertThat(move5IsNotValidMove).isTrue();

        boolean move6IsValidMove = moveable.istZugMoeglichFuerDame(2, 0, 2, 7,   statusField.getFieldArray());
        boolean move7IsValidMove = moveable.istZugMoeglichFuerDame(4, 7, 4, 0,   statusField.getFieldArray());
        boolean move8IsValidMove = moveable.istZugMoeglichFuerDame(0, 2, 7, 2,   statusField.getFieldArray());
        boolean move9IsValidMove = moveable.istZugMoeglichFuerDame(7, 4, 0, 4,   statusField.getFieldArray());
        boolean move10IsNotValidMove = moveable.istZugMoeglichFuerDame(7, 7, 5, 5,   statusField.getFieldArray());

        assertThat(move6IsValidMove).isTrue();
        assertThat(move7IsValidMove).isTrue();
        assertThat(move8IsValidMove).isTrue();
        assertThat(move9IsValidMove).isTrue();
        assertThat(move10IsNotValidMove).isTrue();
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

    @Test
    void testDameGetBezeichnung(){
        WegFrei dame = new Dame();
        assertThat(dame.getBezeichnung()).isEqualTo("D");
    }
}

