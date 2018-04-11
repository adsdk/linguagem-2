package trabalhosaula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author adrisson.silva
 * @created 26/02/2018
 */
public class Exercicio2 {
    
    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        ArrayList<String> list = new ArrayList<>();
        
        int i = 0;
        for (; i < 10; i++) {
            list.add("nome" + i);
        }
        
        System.out.println("Digite o nome a ser pesquisado:");
        if (list.contains(KEYBOARD_INPUT.readLine())) {
            System.out.println("O nome tá na lista! :D");
        }

    }
}
