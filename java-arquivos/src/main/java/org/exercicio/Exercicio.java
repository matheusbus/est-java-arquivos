package org.exercicio;

/*
* Fazer um programa para ler o caminho de um arquivo .csv
contendo os dados de itens vendidos. Cada item possui um
nome, preço unitário e quantidade, separados por vírgula. Você
deve gerar um novo arquivo chamado "summary.csv", localizado
em uma subpasta chamada "out" a partir da pasta original do
arquivo de origem, contendo apenas o nome e o valor total para
aquele item (preço unitário multiplicado pela quantidade),
conforme exemplo.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {

    public static void main(String[] args) {

        // Ler o arquivo de origem
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the in-file path: ");
        String strPath = scanner.nextLine();
        File diretorioOrigem = new File(strPath);

        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(strPath))) {


            String linha = bf.readLine();

            while(linha != null) {

                String[] produtoProperties = linha.split(",");
                produtos.add(new Produto(produtoProperties[0],
                        Double.valueOf(produtoProperties[1]),
                        Integer.valueOf(produtoProperties[2])));

                linha = bf.readLine();
            }

        }
        catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        for(Produto prod : produtos) {
            System.out.println(prod.toString());
        }

        boolean criouDiretorio = new File(diretorioOrigem.getParent() + "\\out").mkdir();
        if(criouDiretorio) {

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(diretorioOrigem.getParent() + "\\out\\produtos-destino.csv"))) {

                for(Produto produto : produtos) {
                    bw.write(produto.getName() + ',' + (produto.getValor() * produto.getQuantidade()));
                    bw.newLine();
                }

            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

        scanner.close();
    }
}
