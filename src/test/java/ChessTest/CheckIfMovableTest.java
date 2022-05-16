package ChessTest;

import Chess.CheckIfMovable;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckIfMovableTest {
    @Test
    void testConvertLetterToInteger(){
        CheckIfMovable moveable = new CheckIfMovable();

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
    @Test
    void testIsValideMove(){
        CheckIfMovable moveable = new CheckIfMovable();
        boolean isValide = moveable.checkIfValidMove("A",1);
        assertThat(isValide).isTrue();
    }
}
