# J - Arquivos I/O

<aside>
💡 Página destinada aos estudos de manipulação de arquivos com Java.

</aside>

---

## 1. Arquivo de apoio e Repositório

---

[11-arquivos.pdf](J%20-%20Arquivos%20I%20O%20cf06861260764d86a43f6c4d88fc1876/11-arquivos.pdf)

---

[https://github.com/matheusbus/java-arquivos](https://github.com/matheusbus/java-arquivos)

## 2. Leitura de Arquivos

---

### 2.1. Leitura simples - ********File e Scanner (Class)********

---

<aside>
💡 A classe File é uma representação abstrata de arquivos e seus diretórios.

</aside>

[File (Java SE 10 & JDK 10 )](https://docs.oracle.com/javase/10/docs/api/java/io/File.html)

[Scanner (Java SE 10 & JDK 10 )](https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html)

2.1.1. Exemplo de código para leitura de arquivo

---

```java
package org.example;

/*
* Leitura de arquivos com as Classes File e Scanner
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeituraArquivo {

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
```

2.1.2. Explicação do código

---

1. Instanciar um objeto File passando o caminho do diretório do arquivo.
2. Instanciar um objeto Scanner, passando o arquivo como parâmetro para o Scanner apontar para o arquivo.
3. Enquanto o scanner identificar que tem linhas a percorrer, ele imprime a próxima linha.
4. Ao final, é necessário fechar o scanner.

---

### 2.2. Leitura com Stream - FileReader e BufferedReader (Class)

---

<aside>
💡 A classe FileReader é implementada para leitura de caracteres a partir de arquivos utilizando stream.

</aside>

[FileReader (Java SE 10 & JDK 10 )](https://docs.oracle.com/javase/10/docs/api/java/io/FileReader.html)

<aside>
💡 A classe BufferedReader implementa interfaces de otimização de leitura de arquivos.

</aside>

[BufferedReader (Java SE 10 & JDK 10 )](https://docs.oracle.com/javase/10/docs/api/java/io/BufferedReader.html)

---

2.2.1. Exemplo de código para leitura de arquivo

---

```java
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
```

2.2.2. Explicação do código

---

- Inicia uma variável string com o caminho do arquivo.
- Instancia um objeto do tipo FileReader passando o diretório do arquivo.
- Instancia um objeto do tipo BufferedReader passando o objeto FileReader.
- Armazena a próxima linha lida. (se não for encontrada retorna null)
- Controle e impressão da variável de linha lida até chegar no final do arquivo.

---

## 3. Bloco try-with-resources

---

<aside>
💡 É um bloco try que declara um ou mais recursos e garante que estes serão fechados ao final de suas utilizações.

</aside>

[The try-with-resources Statement (The Java™ Tutorials >        
            Essential Java Classes > Exceptions)](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)

### 3.1. Exemplo de Código

---

```java
package org.codigomaislimpo;

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
```

### 3.2. Explicando o código

---

1. Dentro da declaração do bloc try posso fazer a instanciação dos objetos.
2. Com isso, ao finalizar o bloco, os recursos serão fechados automaticamente, ficando assim um código bem mais enxuto.

---

## 4. Escrita em arquivos

---

### 4.1. Escrita com Stream - FileWriter e BufferedWriter (Class)

---

<aside>
💡 Classe FileWriter (stream de escrita de caracteres em arquivos) pode receber como parâmetro o caminho do diretório do arquivo.

</aside>

[FileWriter (Java SE 10 & JDK 10 )](https://docs.oracle.com/javase/10/docs/api/java/io/FileWriter.html)

<aside>
💡 Classe BufferedWriter utilizada para escrita em arquivos implementando otimizações para escrever mais rápido.

</aside>

[BufferedWriter (Java SE 10 & JDK 10 )](https://docs.oracle.com/javase/10/docs/api/java/io/BufferedWriter.html)

4.1.1. Exemplo de código

---

```java
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
```

---

## 5. Manipulando diretórios com File (Class)

---

```java
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
    }
}
```
