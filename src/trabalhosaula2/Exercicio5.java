package trabalhosaula2;

/**
 * @author adrisson.silva
 * @created 06/03/2018
 */
public class Exercicio5 {

    public static void main(String[] args) {

        int a = 1, b = 0;

        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
