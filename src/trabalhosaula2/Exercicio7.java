package trabalhosaula2;

/**
 * @author adrisson.silva
 * @created 06/03/2018
 */
public class Exercicio7 {

    public static void main(String[] args) {

        try {
            StringMaiuscula.verificaCaracteresMaisculos("TESTE");
            System.out.println("OK!");
        } catch (NotLetterCharacterOnStringException | NotUpcaseCharacterOnStringException e) {
            System.out.println(e.getMessage());
        }

        try {
            StringMaiuscula.verificaCaracteresMaisculos("TEST4");
        } catch (NotLetterCharacterOnStringException | NotUpcaseCharacterOnStringException e) {
            System.out.println(e.getMessage());
        }

        try {
            StringMaiuscula.verificaCaracteresMaisculos("teste");
        } catch (NotLetterCharacterOnStringException | NotUpcaseCharacterOnStringException e) {
            System.out.println(e.getMessage());
        }

    }

    static class StringMaiuscula {

        public static void verificaCaracteresMaisculos(String palavra) throws NotLetterCharacterOnStringException, NotUpcaseCharacterOnStringException {

            for (int i = 0; i < palavra.length(); i++) {
                if (!Character.isLetter(palavra.charAt(i))) {
                    throw new NotLetterCharacterOnStringException("Dígitos não permitidos!");
                } else if (!Character.isUpperCase(palavra.charAt(i))) {
                    throw new NotUpcaseCharacterOnStringException("LowerCase não permitido!");
                }
            }

        }

    }

}
