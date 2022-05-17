package Chess;

public class CheckIfMoveable {

    public boolean checkIfKoodinatesBelongToActivePlayer(String rowOfField, int column, int activePlayer, ChessfieldStatus statusField) {
        int row = convertLetterToInteger(rowOfField);
        String[][] field = statusField.getFieldArray();
        if (activePlayer == 1) { //Player 1 Uppercase
            //Figure belongs to Player 1
            return isUpper(field[row][column]);
            //Figure can move this way
        } else {  //Player 2 Lowercase
            //Figure belongs to Player 2
            return !isUpper(field[row][column]);
            //Figure can move this way
        }
    }

 //   public boolean moveCanBeMade(int rowOld, String columnOld, int rowNew, String columnNew, ChessfieldStatus statusField){
//
 //       return true;
 //   }

    public boolean isUpper(String s) {
        return ((int) s.toCharArray()[0]) < 97;
    }

    public int convertLetterToInteger(String s) {
        return ((int) (s.toCharArray()[0])) - 65;
        //String legalChars = "ABCDEFGH";
        //HashMap<Character, Integer> hm = new HashMap<>();
        //int i = 0;
        //for (Character c:legalChars.toCharArray()) {
        //    hm.put(c,i);
        //    i++;
        //}
        //return hm.get(s.toCharArray()[0]);  //Needs to be CharArray because needs char
    }

}
