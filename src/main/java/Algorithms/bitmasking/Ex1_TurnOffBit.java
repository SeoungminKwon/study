package Algorithms.bitmasking;

public class Ex1_TurnOffBit {
    public static void main(String[] args) {
        int s = 18; //10010
        int idx = 1;
        s &= ~(1 << idx);
        System.out.println(s);
    }
}
