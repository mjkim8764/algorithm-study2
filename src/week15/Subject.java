package week15;

/*
    Week15.Prob05 : 국영수
    url : https://www.acmicpc.net/problem/10825
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Subject {

    static class Student {
        String name;   // 이름
        int subject1;  // 국어
        int subject2;  // 영어
        int subject3;  // 수학
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Student[] students = new Student[N];

        for(int i=0; i<N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            students[i] = new Student();
            students[i].name = tokenizer.nextToken();
            students[i].subject1 = Integer.parseInt(tokenizer.nextToken());
            students[i].subject2 = Integer.parseInt(tokenizer.nextToken());
            students[i].subject3 = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if(student1.subject1 != student2.subject1) {
                    return -(student1.subject1 - student2.subject1);    // 국어 내림차순
                } else if(student1.subject2 != student2.subject2) {
                    return student1.subject2 - student2.subject2;       // 영어 오름차순
                } else if(student1.subject3 != student2.subject3) {
                    return -(student1.subject3 - student2.subject3);    // 수학 내림차순
                } else {
                    return student1.name.compareTo(student2.name);      // 이름 사전순
                }
            }
        });

        StringBuilder builder = new StringBuilder();

        for(int i=0; i<N; i++)
            builder.append(students[i].name).append("\n");

        System.out.print(builder);
    }
}
