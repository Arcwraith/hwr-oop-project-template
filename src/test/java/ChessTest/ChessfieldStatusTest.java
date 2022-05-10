package ChessTest;

import Chess.ChessfieldStatus;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChessfieldStatusTest {

    @Test
    void testOfGetFieldArray(){
        String[][] field = new String[8][8];
        ChessfieldStatus status = new ChessfieldStatus();
        String[][] actualField = status.getFieldArray();
        assertThat(field).isEqualTo(actualField);
    }

    @Test
    void test_SettingFigureIntoField(){
        ChessfieldStatus fieldStatus = new ChessfieldStatus();
        fieldStatus.setFieldArray(3,3,"König");
        String[][] field = fieldStatus.getFieldArray();
        assertThat(field[3][3]).isEqualTo("König");
    }
}
