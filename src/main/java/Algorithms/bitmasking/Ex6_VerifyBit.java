package Algorithms.bitmasking;

public class Ex6_VerifyBit {
    public static void main(String[] args) {
        int s = 18; // 10010
        int idx = 1;
        if((s & (1 << idx)) != 0){
            System.out.println("idx : " + idx + "번째 피트 켜짐");
        }else{
            System.out.println("idx : " + idx + "번째 피트 꺼짐");
        }
    }
}
