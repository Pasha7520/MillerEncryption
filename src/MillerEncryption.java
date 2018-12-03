import java.util.Scanner;

public class MillerEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String : ");
        miller(scanner.nextLine());
    }

    public static void miller(String word) {
        String result = "";
        String[] strings = new String[word.length()];
        //записуєм в масив похідні слова
        for (int i = 0; i < word.length(); i++) {
            strings[i] = word.substring(i, word.length()) + word.substring(0, i);
        }

        int count = sort(strings).length;
        int number = 0;

        for (int i = 0; i < count; i++) {
            //шукаємо оригінальне слово в масиві
            if (word.equals(strings[i])) {
                //записуєм його позицію
                number = i + 1;
            }
            //записуємо в результат останні літери кожного слова
            result = result + strings[i].substring(count - 1);
        }
        //виводимо результат
        System.out.println(result + " , " + number);

    }
    //сортування
    public static String[] sort(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].compareTo(strings[j]) > 0) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return strings;
    }


}
