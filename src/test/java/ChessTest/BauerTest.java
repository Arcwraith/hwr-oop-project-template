package ChessTest;

import Chess.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class BauerTest {
    @Test
    void test_istZugMoeglichFuerBauer() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();

        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        WegFrei moveable = new Bauer();

        boolean zug1Moeglich = moveable.isMoveValidMove(statusField.getFieldArray(), checkIfMoveable.convertLetterToInteger("A"), 1, 3, checkIfMoveable.convertLetterToInteger("A"), 1);
        boolean zug3Moeglich = moveable.isMoveValidMove(statusField.getFieldArray(), checkIfMoveable.convertLetterToInteger("A"), 6, 5, checkIfMoveable.convertLetterToInteger("A"), 2);
        boolean zug2Moeglich = moveable.isMoveValidMove(statusField.getFieldArray(), checkIfMoveable.convertLetterToInteger("C"), 1, 3, checkIfMoveable.convertLetterToInteger("C"), 1);
        boolean zug4Moeglich = moveable.isMoveValidMove(statusField.getFieldArray(), checkIfMoveable.convertLetterToInteger("C"), 6, 4, checkIfMoveable.convertLetterToInteger("C"), 2);

        assertThat(zug1Moeglich).isTrue();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();
    }

    @Test
    void test_hasNotMovedJet() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Bauer moveable = new Bauer();
        boolean notMovedJet1 = moveable.hasNotMovedJet(1, 1, 1, statusField.getFieldArray());
        boolean notMovedJet2 = moveable.hasNotMovedJet(6, 6, 2, statusField.getFieldArray());

        assertThat(notMovedJet1).isTrue();
        assertThat(notMovedJet2).isTrue();
    }

    @Test
    void test_bauerSchlaegtGegner() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(3, 3, "b");
        statusField.setFieldArray(5, 5, "B");
        WegFrei moveable = new Bauer();
        boolean bauer1SchlaegtGegner = moveable.isMoveValidMove(statusField.getFieldArray(), 2, 2, 3, 3, 1);
        boolean bauer2SchlaegtGegner = moveable.isMoveValidMove(statusField.getFieldArray(), 6, 6, 5, 5, 2);

        statusField.setFieldArray(3, 3, " ");
        statusField.setFieldArray(5, 5, " ");

        boolean bauer1SchleagtNicht = moveable.isMoveValidMove(statusField.getFieldArray(), 2, 2, 3, 3, 1);
        boolean bauer2SchleagtNicht = moveable.isMoveValidMove(statusField.getFieldArray(), 6, 6, 5, 5, 2);

        statusField.setFieldArray(3, 2, "B");

        boolean bauer3SchleagtNicht = moveable.isMoveValidMove(statusField.getFieldArray(), 2, 2, 3, 2, 1);

        assertThat(bauer1SchlaegtGegner).isTrue();
        assertThat(bauer2SchlaegtGegner).isTrue();
        assertThat(bauer1SchleagtNicht).isFalse();
        assertThat(bauer2SchleagtNicht).isFalse();
        assertThat(bauer3SchleagtNicht).isFalse();
    }

    @Test
    void testBauerGetPlayer() {
        WegFrei bauer = new Bauer();
        assertThat(bauer.getPlayer()).isEqualTo(0);
    }

    @Test
    void testBauerSetPlayer() {
        WegFrei bauer = new Bauer();
        bauer.setPlayer(1);
        assertThat(bauer.getPlayer()).isEqualTo(1);
    }

    @Test
    void testBauerGetBezeichnung() {
        WegFrei bauer = new Bauer();
        assertThat(bauer.getBezeichnung()).isEqualTo("B");
    }
}