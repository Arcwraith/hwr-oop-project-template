package Chess;

import java.io.PrintStream;
import java.util.Scanner;

public class Chessfield {
    private final String[][] fieldWithFigure = new String[8][8];
    private final WegFrei[][] figuresOnField = new WegFrei[8][8];
    private int activePlayer = 1;
    private int row, rowNew;
    private String column, columnNew;

    public void setupFigureArrays() {
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

    private void setupWhiteFigures() {
        fieldWithFigure[0][0] = "T";
        fieldWithFigure[0][1] = "S";
        fieldWithFigure[0][2] = "L";
        fieldWithFigure[0][3] = "D";
        fieldWithFigure[0][4] = "K";
        fieldWithFigure[0][5] = "L";
        fieldWithFigure[0][6] = "S";
        fieldWithFigure[0][7] = "T";

        figuresOnField[0][0] = new Turm();
        figuresOnField[0][1] = new Pferd();
        figuresOnField[0][2] = new Springer();
        figuresOnField[0][3] = new Dame();
        figuresOnField[0][4] = new Koenig();
        figuresOnField[0][5] = new Springer();
        figuresOnField[0][6] = new Pferd();
        figuresOnField[0][7] = new Turm();

        figuresOnField[0][0].setPlayer(1);
        figuresOnField[0][1].setPlayer(1);
        figuresOnField[0][2].setPlayer(1);
        figuresOnField[0][3].setPlayer(1);
        figuresOnField[0][4].setPlayer(1);
        figuresOnField[0][5].setPlayer(1);
        figuresOnField[0][6].setPlayer(1);
        figuresOnField[0][7].setPlayer(1);

        for (int i = 0; i < 8; i++) {
            fieldWithFigure[1][i] = "B";
            figuresOnField[1][i] = new Bauer();
            figuresOnField[1][i].setPlayer(1);
        }
    }

    private void setupBlackFigures() {
        fieldWithFigure[7][0] = "t";
        fieldWithFigure[7][1] = "s";
        fieldWithFigure[7][2] = "l";
        fieldWithFigure[7][3] = "k";
        fieldWithFigure[7][4] = "d";
        fieldWithFigure[7][5] = "l";
        fieldWithFigure[7][6] = "s";
        fieldWithFigure[7][7] = "t";

        figuresOnField[7][0] = new Turm();
        figuresOnField[7][1] = new Pferd();
        figuresOnField[7][2] = new Springer();
        figuresOnField[7][3] = new Dame();
        figuresOnField[7][4] = new Koenig();
        figuresOnField[7][5] = new Springer();
        figuresOnField[7][6] = new Pferd();
        figuresOnField[7][7] = new Turm();

        figuresOnField[7][0].setPlayer(2);
        figuresOnField[7][1].setPlayer(2);
        figuresOnField[7][2].setPlayer(2);
        figuresOnField[7][3].setPlayer(2);
        figuresOnField[7][4].setPlayer(2);
        figuresOnField[7][5].setPlayer(2);
        figuresOnField[7][6].setPlayer(2);
        figuresOnField[7][7].setPlayer(2);

        for (int i = 0; i < 8; i++) {
            fieldWithFigure[6][i] = "b";
            figuresOnField[6][i] = new Bauer();
            figuresOnField[6][i].setPlayer(2);
        }
    }

    public PrintStream displayFieldWithFigures() {

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
        return System.out;
    }

    public String[][] getFieldWithFigure() {
        return fieldWithFigure;
    }

    public void setDisplayedFieldToFieldStatus(ChessfieldStatus statusField) {  //Only Chessfield //Aktualisierung des Statusfields
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                statusField.setFieldArray(i, j, this.fieldWithFigure[i][j]);
                statusField.setWegFreiArray(i, j, this.figuresOnField[i][j]);
            }
        }
    }

    public int readInValideRow() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Spalte ein: ");
        int row = scan.nextInt();
        boolean isValide = (row > 0 && row < 9);
        while (!isValide) {
            System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Spalte ein: ");
            row = scan.nextInt();
            isValide = (row > 0 && row < 9);
        }
        this.row = row-1;
        return row - 1;
    }

    public String readInValideColumn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Zeile ein: ");
        String column = scan.nextLine();
        String abgleich = "ABCDEFGH";
        boolean isValid = abgleich.contains(column);
        while (!isValid) {
            System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Zeile ein: ");
            column = scan.nextLine();
            if (abgleich.contains(column)) {
                isValid = true;
            }
        }
        this.column = column;
        return column;
    }

    public int readInValideDepartureRow() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Ziel-Spalte ein: ");
        int rowNew = scan.nextInt();
        boolean isValide = (rowNew > 0 && rowNew < 9);
        while (!isValide) {
            System.out.println("Geben sie bitte eine Zahl zwischen 1 und 8 für die gewünschte Ziel-Spalte ein: ");
            rowNew = scan.nextInt();
            isValide = (rowNew > 0 && rowNew < 9);
        }

        this.rowNew = rowNew;
        return rowNew - 1;
    }

    public String readInValideDepartureColumn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Ziel-Zeile ein: ");
        String columnNew = scan.nextLine();
        String abgleich = "ABCDEFGH";
        boolean isValid = abgleich.contains(columnNew);
        while (!isValid) {
            System.out.println("Geben Sie Bitte eine Buchstaben von A bis H für die Ziel-Zeile ein: ");
            columnNew = scan.nextLine();
            if (abgleich.contains(columnNew)) {
                isValid = true;
            }
        }

        this.columnNew = columnNew;
        return columnNew;
    }

    public void fullfillMoveAndNextPlayersTurn(ChessfieldStatus statusField) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();

        System.out.println("Spieler " + activePlayer + " ist am Zug.");

        String column = readInValideColumn();
        int row = readInValideRow();

        while (checkIfPositionNull(column, row)) {
            column = readInValideColumn();
            row = readInValideRow();
        }

        boolean figureBelongsToPlayer = checkIfMoveable.checkIfKoodinatesBelongToActivePlayer(column, row, activePlayer, statusField);
        while (!figureBelongsToPlayer) {  //Figur zu laufen auswählen
            System.out.println("Diese Figur gehört Spieler " + getNotActivePlayer(activePlayer) + ". Sie können nur mit ihren eigenen Figuren Laufen");
            figureBelongsToPlayer = checkIfMoveable.checkIfKoodinatesBelongToActivePlayer(readInValideColumn(), readInValideRow(), activePlayer, statusField);
        }

        String departureColumn = readInValideDepartureColumn();
        int departureRow = readInValideDepartureRow();

        while (checkIfPositionNull(column, row)) {
            departureColumn = readInValideDepartureColumn();
            departureRow = readInValideDepartureRow();
        }

        boolean moveCanBeMade = checkIfMoveable.moveCanBeMade(row, column, departureRow, departureColumn, statusField, this.activePlayer);
        while (!moveCanBeMade) {
            System.out.println("Gewünschter Zug kann nicht ausgeführt werden!");
            moveCanBeMade = checkIfMoveable.moveCanBeMade(row, column, readInValideDepartureRow(), readInValideDepartureColumn(), statusField, this.activePlayer);
        }
        this.row = row;
        this.column = column;
        this.columnNew = departureColumn;
        this.rowNew = departureRow;

        setDepartureFieldAndClearOldField(row, departureRow, column, departureColumn,statusField);
        displayFieldWithFigures();
        switchActivePlayer(this.activePlayer);
    }

    public void setDepartureFieldAndClearOldField(int row, int newRow, String column, String columnNew, ChessfieldStatus chessfieldStatus) { //Test needed **NextToImplement**
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();

        String figure = this.fieldWithFigure[row][checkIfMoveable.convertLetterToInteger(column)];
        this.fieldWithFigure[row][checkIfMoveable.convertLetterToInteger(column)] = " ";  //Delet Old Position
        this.fieldWithFigure[newRow][checkIfMoveable.convertLetterToInteger(columnNew)] = figure; //Set New Position
        setDisplayedFieldToFieldStatus(chessfieldStatus);
    }

    public boolean gameNotOver() {
        int count = 0;
        for (String[] strings : fieldWithFigure) {
            for (int j = 0; j < fieldWithFigure.length; j++) {
                if (strings[j].equals("K")) {
                    count++;
                }
                if (strings[j].equals("k")) {
                    count++;
                }
            }
        }
        return (count == 2);
    }

    public int getNotActivePlayer(int activePlayer) {
        if (activePlayer == 1) {
            return 2;
        }
        return 1;
    }

    public void switchActivePlayer(int activePlayer) {
        if (activePlayer == 2) {
            this.activePlayer = 1;
        } else {
            this.activePlayer = 2;
        }
    }

    public int getActivePlayer() {
        return activePlayer;
    }

    public boolean checkIfPositionNull(String column, int row) {
        CheckIfMoveable checkIfMoveable = new CheckIfMoveable();
        return (fieldWithFigure[row][checkIfMoveable.convertLetterToInteger(column)].equals(" "));
    }
}