package trabalhosaula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author adrisson.silva
 * @created 26/02/2018
 */
public class Exercicio1 {

    private static final BufferedReader KEYBOARD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String numeroJogadores;
        do {
            System.out.println("Quantas jogadores? (1 ou 2)");
            numeroJogadores = KEYBOARD_INPUT.readLine();
        } while (numeroJogadores == null || !Character.isDigit(numeroJogadores.charAt(0)) || (!"1".equals(numeroJogadores) && !"2".equals(numeroJogadores)));

        Integer numeroEscolhido;
        if (Integer.valueOf(numeroJogadores) == 1) {
            numeroEscolhido = new Random().nextInt(1000 - 1) + 1;
        } else {
            System.out.println("Informe o número a ser adivinhado:");
            numeroEscolhido = Integer.valueOf(KEYBOARD_INPUT.readLine());
        }

        boolean naoAcertou = true;
        int tentativa = 0;
        Integer numeroChute;
        while (naoAcertou) {
            tentativa++;

            System.out.println("Informe o seu chute!");
            numeroChute = Integer.valueOf(KEYBOARD_INPUT.readLine());

            if (numeroChute.compareTo(numeroEscolhido) == 0) {
                naoAcertou = false;
                System.out.println("Você acertou! Total de tentativas = " + tentativa);
            } else if (numeroChute.compareTo(numeroEscolhido) < 0) {
                System.out.println("O número digitado é menor que o número a ser adivinhado");
            } else {
                System.out.println("O número digitado é maior que o número a ser adivinhado");
            }

        }

    }

}
