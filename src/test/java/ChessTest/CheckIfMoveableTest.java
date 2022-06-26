package ChessTest;

import Chess.CheckIfMoveable;
import Chess.Chessfield;
import Chess.ChessfieldStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckIfMoveableTest {
    @Test
    void testConvertLetterToInteger(){
        CheckIfMoveable moveable = new CheckIfMoveable();

        int test1 = moveable.convertLetterToInteger("A");
        int test2 = moveable.convertLetterToInteger("B");
        int test3 = moveable.convertLetterToInteger("C");
        int test4 = moveable.convertLetterToInteger("D");
        int test5 = moveable.convertLetterToInteger("E");
        int test6 = moveable.convertLetterToInteger("F");
        int test7 = moveable.convertLetterToInteger("G");
        int test8 = moveable.convertLetterToInteger("H");

        assertThat(test1).isEqualTo(0);
        assertThat(test2).isEqualTo(1);
        assertThat(test3).isEqualTo(2);
        assertThat(test4).isEqualTo(3);
        assertThat(test5).isEqualTo(4);
        assertThat(test6).isEqualTo(5);
        assertThat(test7).isEqualTo(6);
        assertThat(test8).isEqualTo(7);
    }

    @Test   //Parameterised Test for P1 and P2
    void test_CheckIfKoodinatesBelongToActivePlayer(){
            Chessfield field = new Chessfield();
            ChessfieldStatus statusField = new ChessfieldStatus();
            field.setupFigureArray();
            field.setDisplayedFieldToFieldStatus(statusField);
            CheckIfMoveable moveable = new CheckIfMoveable();
            boolean belongsToP1 = moveable.checkIfKoodinatesBelongToActivePlayer("A",1,1, statusField);
            assertThat(belongsToP1).isTrue();
    }

 //  @Test
 //  void testIsValideMove(){
 //      CheckIfMoveable moveable = new CheckIfMoveable();
 //      ChessfieldStatus fieldStatus = new ChessfieldStatus();
 //      Chessfield field = new Chessfield();
 //      field.setupFigureArray();
 //      field.setDisplayedFieldToFieldStatus(fieldStatus);
 //      boolean isValide = moveable.checkIfKoodinatesBelongToActivePlayer("A",1, field.getActivePlayer());
 //      assertThat(isValide).isTrue();
 //  }

    @ParameterizedTest(name = "Test char {0} is upper.")
    @ValueSource(strings = {"A", "B", "C","D","E","F","G","H"})
    void test_IsUpper(String ch){
        CheckIfMoveable check = new CheckIfMoveable();
        assertThat(check.isUpper(ch)).isTrue();
    }
    @ParameterizedTest(name = "Test char {0} is lower.")
    @ValueSource(strings = {"a", "b", "c","d","e","f","g","h"})
    void test_IsLower(String ch){
        CheckIfMoveable check = new CheckIfMoveable();
        assertThat(check.isUpper(ch)).isFalse();
    }
}
