/**
 * Created by Тим on 08.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        //String[] pnames = {"Silver","Jack","Black Beard","Cook","Hook"};
        //int[] pgold = {200,100,250,50,5};
        sort();
    }

    public static void sort() {
        String[] pnames = {"Silver", "Jack", "Black Beard", "Cook", "Hook"};
        int[] pgold = {200, 100, 250, 50, 5};
        int tmpInt;
        String tmpString;
        for (int i = 0; i < pgold.length ; i++) {
            System.out.println(pnames[i] + " " + pgold[i]);
        }
        for (int i = 0; i < pgold.length; i++) {
            for (int j = 0; j < pgold.length; j++) {
                if (pgold[j] < pgold[i]) {
                    tmpInt = pgold[i];
                    pgold[i] = pgold[j];
                    pgold[j] = tmpInt;
                    tmpString = pnames[i];
                    pnames[i] = pnames[j];
                    pnames[j] = tmpString;
                }
            }
        }
        for (int i = 0; i < pgold.length ; i++) {
            System.out.println(pnames[i] + " " + pgold[i]);
        }
    }
}
