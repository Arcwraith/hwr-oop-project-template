package Chess;

import java.io.PrintStream;
import java.util.Scanner;

public class Chessfield {
    private final String[][] fieldWithFigure = new String[8][8];
    private int activePlayer = 1;

    public static void main(String[] args) {
        Chessfield application = new Chessfield();
        application.setupFigureArray();
        application.displayFieldWithFigures();
    }

//   public void firstMove(){
//       Scanner scan = new Scanner(System.in);
//       System.out.println("Die Großbuchstaben ziehen zuerst." +
//               "\n Geben Sie erst die Koordinate der zubewegenden Figur ein: ");
//       String koordFigure = scan.nextLine();
//       System.out.println("Geben Sie bitte die gewünschten Ziel Koordinaten ihrer Figur ein: ");
//       String destKoord = scan.nextLine();

//       activePlayer++;
//   }

    //   public void nextMove(){
    //       if (activePlayer == 2){
//
    //       }else{
//
    //       }
    //   }

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

    public void setDisplayedFieldToFieldStatus(ChessfieldStatus statusField){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                statusField.setFieldArray(i,j,fieldWithFigure[i][j]);
            }
        }
    }
}