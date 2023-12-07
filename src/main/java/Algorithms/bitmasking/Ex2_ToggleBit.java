package Algorithms.bitmasking;

public class Ex2_ToggleBit {
    public static void main(String[] args) {
        int s = 18; // 10010
        int idx = 2;
        s ^= (1 << idx);
        System.out.println(s);
    }
}
