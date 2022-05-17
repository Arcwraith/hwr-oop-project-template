package Chess;

import java.io.PrintStream;
import java.util.Scanner;

public class Chessfield {
    private final String[][] fieldWithFigure = new String[8][8];
    private int activePlayer = 1;
    private int row, rowNew;
    private String column, columnNew;
    ChessfieldStatus statusField = new ChessfieldStatus();

    public void main(String[] args) {
        setupFigureArray();
        setDisplayedFieldToFieldStatus(statusField);
        displayFieldWithFigures();
        //fullfillMoveAndNextPlayersTurn(); // Needs Test
        //while (!gameNotOver()) {fullfillMoveAndNextPlayersTurn();}
    }

    public void setupFigureArray() {
        setDefaultValue();
        setupBlackFigures();
        setupWhiteFigures();
    }

    public void setDefaultValue() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                fieldWithFigure[i][j] = " ";
            }
        }
    }

    public void setupWhiteFigures() {
        fieldWithFigure[0][0] = "T";
        fieldWithFigure[0][1] = "S";
        fieldWithFigure[0][2] = "L";
        fieldWithFigure[0][3] = "D";
        fieldWithFigure[0][4] = "K";
        fieldWithFigure[0][5] = "L";
        fieldWithFigure[0][6] = "S";
        fieldWithFigure[0][7] = "T";

        for (int i = 0; i < 8; i++) {
            fieldWithFigure[1][i] = "B";
        }
    }

    public void setupBlackFigures() {
        fieldWithFigure[7][0] = "t";
        fieldWithFigure[7][1] = "s";
        fieldWithFigure[7][2] = "l";
        fieldWithFigure[7][3] = "k";
        fieldWithFigure[7][4] = "d";
        fieldWithFigure[7][5] = "l";
        fieldWithFigure[7][6] = "s";
        fieldWithFigure[7][7] = "t";

        for (int i = 0; i < 8; i++) {
            fieldWithFigure[6][i] = "b";
        }
    }

    public PrintStream displayFieldWithFigures() {
        PrintStream out;
        System.out.println();
        System.out.println(" A  B  C  D  E  F  G  H");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("|" + fieldWithFigure[i][j] + "|");
            }
            int sidenote = i + 1;
            System.out.print(" " + sidenote);
            System.out.println();
        }
        return out = System.out;
    }

    public String[][] getFieldWithFigure() {
        return fieldWithFigure;
    }

    public void setDisplayedFieldToFieldStatus(ChessfieldStatus statusField) {  //Only Chessfield //Aktualisierung des Statusfields
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                statusField.setFieldArray(i, j, fieldWithFigure[i][j]);
            }
        }
    }

    public int readInValideRow() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Spalte ein: ");
        row = scan.nextInt();
        boolean isValide = (row > 0 && row < 9);
        while (!isValide) {
            System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Spalte ein: ");
            row = scan.nextInt();
            isValide = (row > 0 && row < 9);
        }

        return row - 1;
    }

    public String readInValideColumn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Zeile ein: ");
        column = scan.nextLine();
        String abgleich = "ABCDEFGH";
        boolean isValid = abgleich.contains(column);
        while (!isValid) {
            System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Zeile ein: ");
            column = scan.nextLine();
            if (abgleich.contains(column)) {
                isValid = true;
            }
        }
        return column;
    }

    public int readInValideDepartureRow() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Ziel-Spalte ein: ");
        rowNew = scan.nextInt();
        boolean isValide = (rowNew > 0 && rowNew < 9);
        while (!isValide) {
            System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Ziel-Spalte ein: ");
            rowNew = scan.nextInt();
            isValide = (rowNew > 0 && rowNew < 9);
        }

        return rowNew - 1;
    }

    public String readInValideDepartureColumn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Ziel-Zeile ein: ");
        columnNew = scan.nextLine();
        String abgleich = "ABCDEFGH";
        boolean isValid = abgleich.contains(columnNew);
        while (!isValid) {
            System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Ziel-Zeile ein: ");
            columnNew = scan.nextLine();
            if (abgleich.contains(columnNew)) {
                isValid = true;
            }
        }
        return columnNew;
    }

  //  public void fullfillMoveAndNextPlayersTurn() {    //Test Needed
  //      CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
//
  //      boolean isMoveValide = checkIfMoveable.checkIfKoodinatesBelongToActivePlayer(readInValideColumn(), readInValideRow(), activePlayer, statusField);
  //      while (!isMoveValide) {  //Figur zu laufen auswählen
  //          System.out.println("Diese Figur gehört Spieler " + activePlayer + ". Sie können nur mit ihren eigenen Figuren Laufen");
  //          isMoveValide = checkIfMoveable.checkIfKoodinatesBelongToActivePlayer(readInValideColumn(), readInValideRow(), activePlayer, statusField);
  //      }
//
  //      boolean moveCanBeMade = checkIfMoveable.moveCanBeMade(row, column, readInValideDepartureRow(), readInValideDepartureColumn(), statusField);
  //      while (!moveCanBeMade) {
  //          System.out.println("Gewünschter Zug kann nicht ausgeführt werden!");
  //          moveCanBeMade = checkIfMoveable.moveCanBeMade(row, column, readInValideDepartureRow(), readInValideDepartureColumn(), statusField);
  //      }
//
  //      setDepartureFieldAndClearOldField(checkIfMoveable);
  //      setDisplayedFieldToFieldStatus(statusField);
//
  //      if (activePlayer == 1) {
  //          activePlayer = 2;
  //      } else {
  //          activePlayer = 1;
  //      }
  //  }

//   public void setDepartureFieldAndClearOldField(CheckIfMoveable checkIfMoveable) { //Test needed
//       int columnInt = checkIfMoveable.convertLetterToInteger(column);
//       int columnNewInt = checkIfMoveable.convertLetterToInteger(columnNew);
//       String figure = fieldWithFigure[row][columnInt];
//       fieldWithFigure[row][columnInt] = " ";  //Delet Old Position
//       fieldWithFigure[rowNew][columnNewInt] = figure; //Set New Position
//       setDisplayedFieldToFieldStatus(statusField);
//   }

  //  public boolean gameNotOver(){ //Tests needed
  //      return true;
  //  }
}