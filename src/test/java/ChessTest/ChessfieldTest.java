package ChessTest;

import Chess.Chessfield;
import Chess.ChessfieldStatus;
import Chess.WegFrei;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ChessfieldTest {

    @Test
    void testOfSetupFigureArray() {
        Chessfield chessfield = new Chessfield();
        ChessfieldStatus chessfieldStatus = new ChessfieldStatus();

        chessfield.setupFigureArrays();
        chessfield.setDisplayedFieldToFieldStatus(chessfieldStatus);

        String[][] second = chessfield.getFieldWithFigure();
        WegFrei[][] setupedField = chessfieldStatus.getWegFreiArray();

        String[][] emptyArray = new String[8][8];
        WegFrei[][] emptyField = new WegFrei[8][8];

        assertThat(emptyField).isNotEqualTo(setupedField);
        assertThat(second).isNotEqualTo(emptyArray);
    }

    @Test
    void testOfDisplayFieldWithFiguresAndSetDisplayFieldToStatusField() {
        Chessfield chessfield = new Chessfield();
        ChessfieldStatus status = new ChessfieldStatus();

        PrintStream ps = chessfield.displayFieldWithFigures(status);
        System.out.println("\n" + " A  B  C  D  E  F  G  H\n" + "|T||S||L||D||K||L||S||T| 1\n" + "|B||B||B||B||B||B||B||B| 2\n" + "| || || || || || || || | 3\n" + "| || || || || || || || | 4\n" + "| || || || || || || || | 5\n" + "| || || || || || || || | 6\n" + "|b||b||b||b||b||b||b||b| 7\n" + "|t||s||l||k||d||l||s||t| 8");
        PrintStream compare = System.out;
        assertThat(ps).isEqualTo(compare);

        String[][] field = chessfield.getFieldWithFigure();

        chessfield.setDisplayedFieldToFieldStatus(status);
        String[][] statusField = status.getFieldArray();
        assertThat(field).isEqualTo(statusField);
    }

    @Test
    void testGetFieldWithFigure() {
        Chessfield chessfield = new Chessfield();
        String[][] field = new String[8][8];
        assertThat(field).isEqualTo(chessfield.getFieldWithFigure());
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8"})
    void test_ReadInValideRow(String input) {
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        int row = chessfield.readInValideRow();
        boolean isValide = (row >= 0 && row < 8);
        assertThat(isValide).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"9", "12", "13", "14", "15", "16", "17", "18"})
    void test_ReadInValideRowWithOneWrongInput(String input) {       // Fix
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);

        try {
            int row = chessfield.readInValideRow();
            assertThat(row).isNotEqualTo(1 | 2 | 3 | 4 | 5 | 6 | 7 | 8);
            fail();
        } catch (Exception e) {
            String rightInput = "6";
            ByteArrayInputStream streamRight = new ByteArrayInputStream(rightInput.getBytes());
            System.setIn(streamRight);
            chessfield.readInValideRow();
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8"})
    void test_ReadInValideDepartureRow(String input) {
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        int row = chessfield.readInValideDepartureRow();
        boolean isValide = (row >= 0 && row < 8);
        assertThat(isValide).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"9", "12", "13", "14", "15", "16", "17", "18"})
    void test_ReadInValideDepartureRowWithOneWrongInput(String input) {       // Fix
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);

        try {
            int row = chessfield.readInValideDepartureRow();
            assertThat(row).isNotEqualTo(1 | 2 | 3 | 4 | 5 | 6 | 7 | 8);
            fail();
        } catch (Exception e) {
            String rightInput = "6";
            ByteArrayInputStream streamRight = new ByteArrayInputStream(rightInput.getBytes());
            System.setIn(streamRight);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "D", "E", "F", "G", "H"})
    void test_readInValideColumn(String input) {
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        String row = chessfield.readInValideColumn();

        assertThat("ABCDEFGH").contains(row);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "D", "E", "F", "G", "H"})
    void test_readInValideDepartureColumn(String input) {
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        String row = chessfield.readInValideDepartureColumn();

        assertThat("ABCDEFGH").contains(row);
    }

    @ParameterizedTest
    @ValueSource(strings = {"W", "Q", "T", "R", "Z", "U", "I", "O"})
    void test_readInValideColumnWithOneWrongInput(String input) { //Idk how to fix
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());

        System.setIn(stream);
        try {
            String row = chessfield.readInValideColumn();
            assertThat("ABCDEFGH").doesNotContain(row);
            fail();
        } catch (Exception e) {
            String rightInput = "B";
            ByteArrayInputStream streamRight = new ByteArrayInputStream(rightInput.getBytes());
            try {
                System.in.reset();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.setIn(streamRight);
            String row = chessfield.readInValideColumn();
            assertThat("ABCDEFGH").contains(row);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"W", "Q", "T", "R", "Z", "U", "I", "O"})
    void test_readInValideDepartureColumnWithOneWrongInput(String input) { //Idk how to fix
        Chessfield chessfield = new Chessfield();
        ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());

        System.setIn(stream);
        try {
            String row = chessfield.readInValideDepartureColumn();
            assertThat("ABCDEFGH").doesNotContain(row);
            fail();
        } catch (Exception e) {
            String rightInput = "B";
            ByteArrayInputStream streamRight = new ByteArrayInputStream(rightInput.getBytes());
            System.setIn(streamRight);
        }
    }


    @Test
    void test_GameNotOver() {
        Chessfield chessfield = new Chessfield();
        Chessfield field = new Chessfield();
        ChessfieldStatus chessfieldStatus = new ChessfieldStatus();

        chessfield.setupFigureArrays();
        chessfield.displayFieldWithFigures(chessfieldStatus);

        field.setDefaultValue();

        boolean isNotOver1 = chessfield.gameNotOver();
        boolean isNotOver2 = field.gameNotOver();

        assertThat(isNotOver1).isTrue();
        assertThat(isNotOver2).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void test_GetNotActivePlayer(int activePlayer) {
        Chessfield field = new Chessfield();
        int notActivePlayer = field.getNotActivePlayer(activePlayer);
        assertThat(notActivePlayer).isNotEqualTo(activePlayer);
    }


    @Test
    void test_SetDepartureFieldAndClearOldField() {
        Chessfield field = new Chessfield();
        ChessfieldStatus statusField = new ChessfieldStatus();
        field.setupFigureArrays();
        field.setDisplayedFieldToFieldStatus(statusField);
        String[][] fieldOld = statusField.getFieldArray();

        String a = "A";
        String row = "2";
        String rowDeparture = "3";

        ByteArrayInputStream stream1 = new ByteArrayInputStream(a.getBytes());
        ByteArrayInputStream stream2 = new ByteArrayInputStream(row.getBytes());
        ByteArrayInputStream stream3 = new ByteArrayInputStream(rowDeparture.getBytes());

        System.setIn(stream2);
        int valideRow = field.readInValideRow();

        try {
            System.in.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.setIn(stream1);
        String valideColumn = field.readInValideColumn();

        try {
            System.in.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.setIn(stream3);
        int valideDepartureRow = field.readInValideDepartureRow();

        try {
            System.in.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.setIn(stream1);
        String valideDepartureColumn = field.readInValideDepartureColumn();

        try {
            System.in.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ChessfieldStatus chessfieldStatus = new ChessfieldStatus();

        field.setDepartureFieldAndClearOldField(valideRow, valideDepartureRow, valideColumn, valideDepartureColumn, chessfieldStatus);
        String[][] fieldNew = chessfieldStatus.getFieldArray();

        assertThat(fieldNew).isNotEqualTo(fieldOld);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void test_SwitchActivePlayer(int activePlayer) {
        Chessfield field = new Chessfield();
        int notActivePlayer = field.getNotActivePlayer(activePlayer);
        field.switchActivePlayer(activePlayer);
        int nowActivePlayer = field.getNotActivePlayer(notActivePlayer);
        assertThat(notActivePlayer).isNotEqualTo(nowActivePlayer);
    }

    // @Test
    // void test_FullfillMoveAndNextPlayersTurn() {       //Test doesnt work
    //     Chessfield field = new Chessfield();
    //     ChessfieldStatus chessfieldStatus = new ChessfieldStatus();
    //     field.setupFigureArrays();
    //     field.setDisplayedFieldToFieldStatus(chessfieldStatus);

    //     int notActivePlayer = field.getNotActivePlayer(1);
    //     String[][] fieldBeforeFirstTurn = chessfieldStatus.getFieldArray();

    //     String a = "A";
    //     String row = "1";
    //     String rowDeparture = "2";

    //     ByteArrayInputStream stream1 = new ByteArrayInputStream(a.getBytes());
    //     ByteArrayInputStream stream2 = new ByteArrayInputStream(row.getBytes());
    //     ByteArrayInputStream stream3 = new ByteArrayInputStream(rowDeparture.getBytes());


    //     field.fullfillMoveAndNextPlayersTurn(chessfieldStatus);

    //     //Read in starting row and column
    //     System.setIn(stream2);
    //     try {
    //         System.in.reset();
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    //     System.setIn(stream1);
    //     try {
    //         System.in.reset();
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }


    //     //Read in departure row and column
    //     System.setIn(stream3);
    //     try {
    //         System.in.reset();
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    //     System.setIn(stream1);
    //     try {
    //         System.in.reset();
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    //
    //     //Player switch
    //     String[][] fieldAfterFirstTurn = chessfieldStatus.getFieldArray();

    //     assertThat(fieldBeforeFirstTurn).isNotEqualTo(fieldAfterFirstTurn);
    //     assertThat(notActivePlayer).isEqualTo(field.getNotActivePlayer(2));
    // }

    @Test
    void testActivePlayer() {
        Chessfield chessfield = new Chessfield();
        int activePlayer = chessfield.getActivePlayer();
        assertThat(activePlayer).isEqualTo(1);

        chessfield.switchActivePlayer(1);
        activePlayer = chessfield.getActivePlayer();
        assertThat(activePlayer).isEqualTo(2);
    }

    @Test
    void testCheckIfPositionNotNull() {
        Chessfield chessfield = new Chessfield();
        ChessfieldStatus chessfieldStatus = new ChessfieldStatus();
        chessfield.setupFigureArrays();
        chessfield.setDisplayedFieldToFieldStatus(chessfieldStatus);
        boolean notNull = chessfield.checkIfPositionNull("A", 1, chessfieldStatus);
        boolean isNull = chessfield.checkIfPositionNull("A", 4, chessfieldStatus);

        assertThat(isNull).isTrue();
        assertThat(notNull).isFalse();
    }

    // @Test
    // void manualTestFullfillMoveAndNextPlayersTurn(){    //Needs to be manually executed. Input: A;2;A;3; --> bauer makes move
    //     Chessfield chessfield = new Chessfield();
    //     ChessfieldStatus chessfieldStatus = new ChessfieldStatus();
    //     int activePlayer = chessfield.getActivePlayer();

    //     chessfield.setupFigureArrays();
    //     chessfield.setDisplayedFieldToFieldStatus(chessfieldStatus);
    //     String[][] figures = chessfieldStatus.getFieldArray();

    //     chessfield.fullfillMoveAndNextPlayersTurn(chessfieldStatus);

    //     assertThat(figures).isNotEqualTo(chessfieldStatus.getWegFreiArray());
    //     //assertThat(activePlayer).isEqualTo(chessfield.getActivePlayer());
    // }

    //   @Test
    //  void testWegFreiToDisplayableFormat(){

    //      Chessfield chessfield = new Chessfield();
    //      ChessfieldStatus chessfieldStatus = new ChessfieldStatus();

    //      chessfield.setupFigureArrays();
    //      chessfield.setDisplayedFieldToFieldStatus(chessfieldStatus);
    //      WegFrei[][]figuresSetuped = chessfieldStatus.getWegFreiArray();
    //      PrintStream out = chessfield.wegFreiToDisplayableFormat(figuresSetuped);


    //  }
}