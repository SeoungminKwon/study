package Algorithms.bitmasking;

public class Ex7_NumberOfCase {
    public static void main(String[] args) {
        int n = 4;
        String a[] = {"사과", "딸기", "포도", "배"};

        for (int i = 0; i < (1 << n); i++) {
            String ret = "";
            for (int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0){
                    ret += a[j] + " ";
                }
            }
            System.out.println(ret);
        }
    }
}
