package org.manuseiodepasta;

import java.io.File;
import java.util.Scanner;

public class CaminhoDiretorioArquivo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a folder path: ");
        String strPath = scanner.nextLine();
        File path = new File(strPath);

        System.out.println("getName: " + path.getName());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getPath: " + path.getPath());
        System.out.println("getAbsolutePath: " + path.getAbsolutePath());
        System.out.println("getTotalSpace: " + path.getTotalSpace());

    }
}
