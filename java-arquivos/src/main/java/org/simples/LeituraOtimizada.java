package org.simples;

/*
 * Leitura de arquivos com as Classes BufferedReader e FileReader
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraOtimizada {

    public static void main(String[] args) {

        String path = "D:\\GitHub\\java-arquivos\\arquivo-leitura-stream.txt";
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String lineReading = br.readLine();

            while (lineReading != null) {
                System.out.println(lineReading);
                lineReading = br.readLine();
            }
        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
