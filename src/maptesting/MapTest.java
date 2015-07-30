package maptesting;

import students.Student;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.TreeMap;

public class MapTest {

    private static final char[] CH = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ".toCharArray();

    private  static int randomLength (int min, int max){
        SecureRandom random = new SecureRandom();
        return random.nextInt((max-min)+1)+min;
    }

    private static String randomSurname(int min, int max) {
        SecureRandom random = new SecureRandom();
        int numOfChars = randomLength(min,max);
        char[] temp = new char[numOfChars];

        for (int i = 0; i < numOfChars; ++i) {
            temp[i] = CH[random.nextInt(CH.length)];
        }

        return new String(temp);
    }


    private static int [] randomMarks (int min, int max) {
        SecureRandom random = new SecureRandom();
        int numOfMarks = randomLength(min,max);
        int [] marks = new int[numOfMarks];
        for (int i=0;i<numOfMarks;++i){
            marks[i] = random.nextInt(5)+1;
        }
        return marks;
    }


    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        HashMap hashMap = new HashMap();
        int minSurnameLength = 1;
        int maxSurnameLength = 50;
        int minNumOfMarks = 0;
        int maxNumOfMarks = 35;
        int numOfStudents = 1000000;
        Student [] students = new Student[numOfStudents];
        long start = System.currentTimeMillis();
        long duration = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i=0;i<numOfStudents;++i) {
            Student randomStudent = new Student(i,
                            randomSurname(minSurnameLength,maxSurnameLength),
                            randomMarks(minNumOfMarks,maxNumOfMarks));
            students[i]=randomStudent;
        }
        duration = System.currentTimeMillis() - start;
        for (int i = 0; i<10;++i) {
            System.out.println("Data example: " + students[i+100].toString());
        }
        System.out.println();
        System.out.println(numOfStudents + " elements added to an array in " + duration + " ms\n");//15 064 ms


        System.out.println("Add:");
        start = System.currentTimeMillis();
        for (int i=0;i<numOfStudents;++i) {
            treeMap.put(i,students[i]);
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("TreeMap: " + duration + " ms");

        start = System.currentTimeMillis();
        for (int i=0;i<numOfStudents;++i) {
            hashMap.put(i,students[i]);
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("HashMap : " + duration + " ms\n");


        System.out.println("Search:");
        Student test = students[1999];

        start = System.currentTimeMillis();
        for (int i=0;i<numOfStudents;++i) {
            treeMap.containsValue(test);
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("TreeMap: " + duration + " ms");

        start = System.currentTimeMillis();
        for (int i=0;i<numOfStudents;++i) {
            hashMap.containsValue(test);
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("HashMap: " + duration + " ms\n");

        System.out.println("Delete by key:");
        start = System.currentTimeMillis();
        for (int i=0;i<numOfStudents;++i) {
            treeMap.remove(1999);
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("TreeMap: " + duration + " ms");

        start = System.currentTimeMillis();
        for (int i=0;i<numOfStudents;++i) {
            hashMap.remove(1998);
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("HashMap: " + duration + " ms\n");


    }


}
