package ChessTest;

import Chess.Chessfield;
import Chess.ChessfieldStatus;
import Chess.Bauer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class BauerTest {
    @Test
    void test_istZugMoeglichFürBauer() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        Bauer moveable = new Bauer();
        boolean zug1Moeglich = moveable.istZugMoeglichFürBauer(1, 1, 2, 1, 1, statusField, field.getFieldWithFigure());
        boolean zug3Moeglich = moveable.istZugMoeglichFürBauer(6, 1, 5, 1, 2, statusField, field.getFieldWithFigure());
        boolean zug2Moeglich = moveable.istZugMoeglichFürBauer(1, 2, 3, 2, 1, statusField, field.getFieldWithFigure());
        boolean zug4Moeglich = moveable.istZugMoeglichFürBauer(6, 2, 4, 2, 2, statusField, field.getFieldWithFigure());

        assertThat(zug1Moeglich).isTrue();
        assertThat(zug2Moeglich).isTrue();
        assertThat(zug3Moeglich).isTrue();
        assertThat(zug4Moeglich).isTrue();

    }

    @Test
    void test_hasNotMovedJet() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArray();
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
        field.setupFigureArray();
        field.setDisplayedFieldToFieldStatus(statusField);
        statusField.setFieldArray(3, 3, "b");//Victim
        statusField.setFieldArray(5, 5, "B");//Victim
        Bauer moveable = new Bauer();
        boolean bauer1SchlaegtGegner = moveable.istZugMoeglichFürBauer(2, 2, 3, 3, 1, statusField, field.getFieldWithFigure());
        boolean bauer2SchlaegtGegner = moveable.istZugMoeglichFürBauer(6, 6, 5, 5, 2, statusField, field.getFieldWithFigure());

        assertThat(bauer1SchlaegtGegner).isTrue();
        assertThat(bauer2SchlaegtGegner).isTrue();
    }//[y=row][x=column]
}
//expected true but is false line 45
/*
kleine Buchstaben unten, große sind oben
spieler 1== groß, move== nach unten +1
spieler 2== klein, move== nach oben -1
 */