package ChessTest;

import Chess.Chessfield;
import Chess.ChessfieldStatus;
import Chess.Bauer;
import Chess.WegFrei;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class BauerTest {
    @Test
    void test_istZugMoeglichFürBauer() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        Bauer moveable = new Bauer();
        boolean zug1Moeglich = moveable.isMoveValidMove(field.getFieldWithFigure(),1, 1, 2, 1, 1);
        boolean zug3Moeglich = moveable.isMoveValidMove(field.getFieldWithFigure(),1, 6, 5, 1, 2);
        boolean zug2Moeglich = moveable.isMoveValidMove( field.getFieldWithFigure(),2, 1, 3, 2, 1);
        boolean zug4Moeglich = moveable.isMoveValidMove(field.getFieldWithFigure(),2, 6, 4, 2, 2);

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
        statusField.setFieldArray(3, 3, "b");//Victim
        statusField.setFieldArray(5, 5, "B");//Victim
        Bauer moveable = new Bauer();
        boolean bauer1SchlaegtGegner = moveable.isMoveValidMove(field.getFieldWithFigure(),2, 2, 3, 3, 1);
        boolean bauer2SchlaegtGegner = moveable.isMoveValidMove(field.getFieldWithFigure(),6, 6, 5, 5, 2);

        assertThat(bauer1SchlaegtGegner).isTrue();
        assertThat(bauer2SchlaegtGegner).isTrue();
    }//[y=row][x=column]

    @Test
    void testBauerGetPlayer(){
        WegFrei bauer = new Bauer();    // 0= not assined, 1= player 1, 2= player 2
        assertThat(bauer.getPlayer()).isEqualTo(0);
    }

    @Test
    void testBauerSetPlayer(){
        WegFrei bauer = new Bauer();
        bauer.setPlayer(1);
        assertThat(bauer.getPlayer()).isEqualTo(1);
    }
}
//expected true but is false line 45
/*
kleine Buchstaben unten, große sind oben
spieler 1== groß, move== nach unten +1
spieler 2== klein, move== nach oben -1
 */