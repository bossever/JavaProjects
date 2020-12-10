package com.ayushman;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String LONG_DASH = "\u2014";
    private static boolean gameOver = false;
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    private static final String[][] gameBoard = {
            {" ", "|", " ", "|", " "},
            {LONG_DASH, "+", LONG_DASH, "+", LONG_DASH},
            {" ", "|", " ", "|", " "},
            {LONG_DASH, "+", LONG_DASH, "+", LONG_DASH},
            {" ", "|", " ", "|", " "},};

    public static void main(String[] args) {

        System.out.println("-------------------");
        System.out.println("*** TIC TAC TOE ***");
        System.out.println("-------------------\n");

        drawBoard();

        while(!gameOver) {
            playUser();
            if (gameOver) {
                break;
            }
            playComputer();
        }
    }

    public static void playUser() {
        int pos = scanner.nextInt();
        if (!placeXO(pos, "USER")) {
            playUser();
        }
    }

    public static void playComputer() {
        int pos = random.nextInt(9) + 1;
        if (!placeXO(pos, "COMPUTER")) {
            playComputer();
        }
    }

    public static boolean placeXO(int pos, String player) {

        boolean placed = true;
        String XO = player.equals("USER") ? "X" : "O";

        switch (pos) {
            case 1:
                if (gameBoard[0][0].equals(" ")) {
                    gameBoard[0][0] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 2:
                if (gameBoard[0][2].equals(" ")) {
                    gameBoard[0][2] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 3:
                if (gameBoard[0][4].equals(" ")) {
                    gameBoard[0][4] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 4:
                if (gameBoard[2][0].equals(" ")) {
                    gameBoard[2][0] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 5:
                if (gameBoard[2][2].equals(" ")) {
                    gameBoard[2][2] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 6:
                if (gameBoard[2][4].equals(" ")) {
                    gameBoard[2][4] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 7:
                if (gameBoard[4][0].equals(" ")) {
                    gameBoard[4][0] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 8:
                if (gameBoard[4][2].equals(" ")) {
                    gameBoard[4][2] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            case 9:
                if (gameBoard[4][4].equals(" ")) {
                    gameBoard[4][4] = XO;
                    break;
                }
                else if (player.equals("USER")) {
                    System.out.println("\nInvalid position specified, enter position again!");
                }
                placed = false;
                break;

            default:
                System.out.println("Error");
        }
        drawBoard();
        gameOver = check();

        if (gameOver) {
            System.out.println("\n*** \tGAME OVER \t***");
            System.out.println("*** \t" + player + " WON \t***");
        }
        return placed;
    }

    public static boolean check() {

        //check horizontals
        for (int row = 0; row <= 4; row += 2) {
            if (gameBoard[row][0].equals(gameBoard[row][2]) && gameBoard[row][2].equals(gameBoard[row][4]) && !gameBoard[row][0].equals(" ")) {
                return true;
            }
        }

        //check verticals
        for (int column = 0; column <= 4; column += 2) {
            if (gameBoard[0][column].equals(gameBoard[2][column]) && gameBoard[2][column].equals(gameBoard[4][column]) && !gameBoard[0][column].equals(" ")) {
                return true;
            }
        }

        //check diagonals
        if ((gameBoard[0][0].equals(gameBoard[2][2]) && gameBoard[2][2].equals(gameBoard[4][4])) || (gameBoard[0][4].equals(gameBoard[2][2]) && gameBoard[2][2].equals(gameBoard[4][0])) && !gameBoard[2][2].equals(" ")) {
            return true;
        }

        return false;
    }

    public static void drawBoard() {
        for (String[]  row : gameBoard) {
            System.out.print("      ");
            for (String s : row) {
                System.out.print(s);
            }
            System.out.println();
        }
        System.out.println();
    }
}
