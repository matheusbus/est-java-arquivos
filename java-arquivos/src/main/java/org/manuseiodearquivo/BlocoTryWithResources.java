package org.manuseiodearquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlocoTryWithResources {

    public static void main(String[] args) {

        String path = "D:\\GitHub\\java-arquivos\\arquivo-leitura-stream.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = bf.readLine();

            while (line != null) {
                System.out.println(line);
                line = bf.readLine();
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }

    }

}
