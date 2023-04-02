/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pr_5;

/**
 *
 * @author stanovova
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class PR_5 {
    public static void main(String[] args) {
        System.out.println("Вариант 2, РИБО-03-21, Становова Диана");
        Scanner scanner = new Scanner(System.in);
        System.out.print("путь до файла: ");
        String inputFilePath = scanner.nextLine();
        File inputFile = new File(inputFilePath);
        
        if (!inputFile.exists()) {
            System.out.println("нет файла");
            return;
        }

        String outputFileName = "output.txt";

        try {
            File outputFile = new File(inputFile.getParent(), outputFileName);

            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);

            int character;
            String line = "";
            while ((character = fileReader.read()) != -1) {
                if ((char) character == '\n') {
                    String reversedLine = reverseLine(line);
                    fileWriter.write(reversedLine+'\n');
                    line = "";
                } else {
                    line += (char) character;
                }
            }

            fileReader.close();
            fileWriter.close();

            System.out.println("да");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String reverseLine(String line) {
        String reversedLine = "";
        for (int i = line.length() - 1; i >= 0; i--) {
            reversedLine += line.charAt(i);
        }
        return reversedLine;
    }
}
