package Algorithms.bitmasking;

public class Ex5_TurnOnSpecificBIt {
    public static void main(String[] args) {
        int s = 18; // 10010
        int idx = 3;
        s |= (1 << idx);
        System.out.println(s);
    }
}
