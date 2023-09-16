package org.manuseiodepasta;

import java.io.File;
import java.util.Scanner;

public class ManipulandoDiretorio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a folter path: ");
        String strPath = scanner.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS: ");
        for(File folder : folders) {
            System.out.println(folder);
        }

        System.out.println("FILES: ");
        File[] files = path.listFiles(File::isFile);
        for(File file : files) {
            System.out.println(file);
        }

        // Criando um novo diretório:
        boolean sucesso = new File(strPath + "\\novo-diretorio").mkdir();
        if(sucesso) {
            System.out.println("Diretório criado com sucesso.");
        }

        scanner.close();
    }
}
