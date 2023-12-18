package Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PqTest2 {
    static class Student{
        int mScore;
        int eScore;

        public Student(int mScore, int eScore) {
            this.mScore = mScore;
            this.eScore = eScore;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "mScore=" + mScore +
                    ", eScore=" + eScore +
                    '}';
        }
    }
    public static void main(String[] args) {
        PriorityQueue< Student > pq = new PriorityQueue<>(new Comparator< Student >() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.mScore == o2.mScore) {
                    return o2.eScore - o1.eScore; //수학점수가 같을시 영어점수 내림차순 정렬
                }
                return o2.mScore - o1.mScore; //영어점수 내림차순 정렬
            }
        });

        pq.offer(new Student(80, 90));
        pq.offer(new Student(80, 70));
        pq.offer(new Student(70, 100));
        pq.offer(new Student(90, 100));
        pq.offer(new Student(90, 90));
        pq.offer(new Student(80, 100));


        while (!pq.isEmpty()) {
            Student st = pq.poll();
            System.out.println(st);
        }
//        Student{mScore=90, eScore=100}
//        Student{mScore=90, eScore=90}
//        Student{mScore=80, eScore=100}
//        Student{mScore=80, eScore=90}
//        Student{mScore=70, eScore=100}

    }
}
