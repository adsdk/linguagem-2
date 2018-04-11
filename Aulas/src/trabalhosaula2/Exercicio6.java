package trabalhosaula2;

import java.util.Arrays;
import java.util.List;

/**
 * @author adrisson.silva
 * @created 06/03/2018
 */
public class Exercicio6 {

    public static void main(String[] args) {

        try {
            System.out.println(getPosition(3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice " + e.getMessage() + " não encontrado!");
        }

    }

    private static String getPosition(int n) {
        List<String> list = Arrays.asList("A", "B", "C");
        return list.get(n);
    }

}
