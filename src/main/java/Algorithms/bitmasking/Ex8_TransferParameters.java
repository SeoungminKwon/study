package Algorithms.bitmasking;

public class Ex8_TransferParameters {

    static int n = 4;
    static String a[] = {"사과", "딸기", "포도", "배"};
    public static void main(String[] args) {
        for (int i = 1; i < n; i++) {

            go(1 | (1 << i));
        }
    }

    static void go(int num) {
        String ret = "";
        for (int i = 0; i < 4; i++) {
            if((num & (1 << i)) != 0){
                ret += a[i] + " ";
            }
        }
        System.out.println(ret);
    }
}
