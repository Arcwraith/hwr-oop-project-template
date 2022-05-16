package Chess;

import java.util.Locale;

public class CheckIfMovable {

    public boolean checkIfValidMove(String feldzeile, int feldreihe) {
        int zeile = convertLetterToInteger(feldzeile);
        return true;
    }

    public int convertLetterToInteger(String feldzeile) {
        if (feldzeile == "A") {
            return 0;
        }
        if (feldzeile == "B") {
            return 1;
        }
        if (feldzeile == "C") {
            return 2;
        }
        if (feldzeile == "D") {
            return 3;
        }
        if (feldzeile == "E") {
            return 4;
        }
        if (feldzeile == "F") {
            return 5;
        }
        if (feldzeile == "G") {
            return 6;
        } else {      // Has to be H
            return 7;
        }
    }
}
