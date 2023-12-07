package Algorithms.bitmasking;

public class Ex3_FindLowestBit {
    public static void main(String[] args) {
        int s = 24; // 11000
        int idx = (s & -s);
        System.out.println(idx);
    }
}
