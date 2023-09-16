package org.example;

/*
* Leitura de arquivos com as Classes File e Scanner
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeituraSimples {

    public static void main(String[] args) {

        File file = new File("D:\\GitHub\\java-arquivos\\arquivo-leitura.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            if(scanner != null) {
                scanner.close();
            }
        }

    }
}