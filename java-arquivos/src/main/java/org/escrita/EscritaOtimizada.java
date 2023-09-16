package org.escrita;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritaOtimizada {

    public static void main(String[] args) {

        // Escrita sobrescrevendo arquivo
        String[] lines = new String[] {"Python", "JavaScript", "Ruby on Rails"};
        String path = "D:\\GitHub\\java-arquivos\\arquivo-escrita.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

            for(String line : lines) {
                bw.write(line);
                bw.newLine(); // Quebrar linha
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }


        // Escrita sem reescrever - acrescenta string no final (append)
        // Toda vez que executar aqui, ele vai adicionar ao final do arquivo sem recriar.
        String path2 = "D:\\GitHub\\java-arquivos\\arquivo-escrita-semsobrescrita.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {

            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
