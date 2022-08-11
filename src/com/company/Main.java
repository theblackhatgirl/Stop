package com.company;

import java.util.Scanner;

public class Main {
    private static int roundAmount = 5;
    private static int columnAmount = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] table = new String[roundAmount][columnAmount];
        int currentRound = 1;

        table[0][0] = "1- NOME";
        table[0][1] = "2- COR";
        table[0][2] = "3- COMIDA";
        table[0][3] = "4- OBJETO";
        table[0][4] = "5- CEP";
        table[0][5] = "6- ANIMAL";
        table[0][6] = "7- PONTUACAO";


        while (currentRound < roundAmount) {
            table = formatTable(table);

            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < columnAmount; j++) {
                    System.out.print(table[i][j] + " | ");
                }
                System.out.println();

            }
            System.out.print("=> ");
            String userInput = scanner.nextLine();

            if (userInput.equals("stop")) {

                System.out.print("Digite sua pontuação:");
                String score = scanner.nextLine();

                table[currentRound][6] = score;

                currentRound++;

            } else {

                String[] parts = userInput.split(" ");

//                int category = Integer.parseInt(parts[0]) -1;
//                table[currentRound][category] = parts[1];

                switch (parts[0]) {
                    case "1" -> table[currentRound][0] = parts[1];
                    case "2" -> table[currentRound][1] = parts[1];
                    case "3" -> table[currentRound][2] = parts[1];
                    case "4" -> table[currentRound][3] = parts[1];
                    case "5" -> table[currentRound][4] = parts[1];
                    case "6" -> table[currentRound][5] = parts[1];
                    default -> System.out.println("Inválido!");
                }
            }

        }
        int totalScore = 0;
        for (int line = 1; line < roundAmount; line++) {
            totalScore += Integer.parseInt(table[line][6].trim());
        }

        System.out.println("Pontuação final: " + totalScore);


    }

    private static String[][] formatTable(String[][] table) {
        if (table[0] != null) {
            for (int column = 0; column < table[0].length; column++) {
                int maxLength = 0;
                for (int line = 0; line < table.length; line++) {
                    if (table[line][column] != null && table[line][column].length() > maxLength) {
                        maxLength = table[line][column].length();
                    }
                }

                for (int line = 0; line < table.length; line++) {
                    int wordLength = 0;
                    if (table[line][column] != null) {
                        wordLength = table[line][column].length();
                    }

                    int spaceAmount = maxLength - wordLength;

                    for (int s = 0; s < spaceAmount; s++) {
                        if (table[line][column] == null) {
                            table[line][column] = "";
                        }
                        table[line][column] += " ";
                    }
                }
            }
        }

        return table;
    }
}
