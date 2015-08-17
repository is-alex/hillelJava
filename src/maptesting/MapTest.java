package maptesting;

import students.Student;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class MapTest {

    private static final char[] CH = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ".toCharArray();
    private static long start = System.currentTimeMillis();

    public  static int randomLength (int min, int max){
        SecureRandom random = new SecureRandom();
        return random.nextInt((max-min)+1)+min;
    }

    public static String randomSurname(int min, int max) {
        SecureRandom random = new SecureRandom();
        int numOfChars = randomLength(min,max);
        char[] temp = new char[numOfChars];

        for (int i = 0; i < numOfChars; ++i) {
            temp[i] = CH[random.nextInt(CH.length)];
        }

        return new String(temp);
    }

    public static int [] randomMarks (int min, int max) {
        SecureRandom random = new SecureRandom();
        int numOfMarks = randomLength(min,max);
        int [] marks = new int[numOfMarks];
        for (int i=0;i<numOfMarks;++i){
            marks[i] = random.nextInt(5)+1;
        }
        return marks;
    }

    private static long [] putTest(Student[] students, TreeMap treeMap, HashMap hashMap){

        start = System.currentTimeMillis();
        for (int i=0;i<students.length;++i) {
            treeMap.put(i,students[i]);
        }
        long treeMapDuration = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i=0;i<students.length;++i) {
            hashMap.put(i,students[i]);
        }
        long hashMapDuration = System.currentTimeMillis() - start;
        return new long[] {treeMapDuration, hashMapDuration};

    }

    private static long []  containsTest (Student student, TreeMap treeMap, HashMap hashMap) {
        start = System.currentTimeMillis();
            treeMap.containsValue(student);
        long treeMapDuration = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
            hashMap.containsValue(student);
        long hashMapDuration = System.currentTimeMillis() - start;
        return new long[] {treeMapDuration, hashMapDuration};

    }

    private static long[] removeTest (int treeMapKey, int hashMapKey, TreeMap treeMap, HashMap hashMap) {

        start = System.currentTimeMillis();
            treeMap.remove(treeMapKey);
        long treeMapDuration = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
            hashMap.remove(hashMapKey);

        long hashMapDuration = System.currentTimeMillis() - start;
        return new long[] {treeMapDuration, hashMapDuration};

    }

    private static long[] removeAllTest (TreeMap treeMap, HashMap hashMap) {

        start = System.currentTimeMillis();
        for (int i=0;i<treeMap.size();i++) {
            treeMap.remove(i);
        }
        long treeMapDuration = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i=0;i<treeMap.size();i++) {
            hashMap.remove(i);
        }
        long hashMapDuration = System.currentTimeMillis() - start;
        return new long[] {treeMapDuration, hashMapDuration};

    }


    public static void main(String[] args) {
        System.out.println("========================================================" +
                "====================================================");
        System.out.println("                |              ||         Add all       " +
                "||         Search        ||      Remove all       ||");
        System.out.println("Num of students |  Created in  ||  TreeMap  |  HashMap  " +
                "||  TreeMap  |  HashMap  ||  TreeMap  |  HashMap  ||");
        System.out.println("==========================================================" +
                "==================================================");



        TreeMap treeMap = new TreeMap();
        HashMap hashMap = new HashMap();
        int minSurnameLength = 1;
        int maxSurnameLength = 50;
        int minNumOfMarks = 0;
        int maxNumOfMarks = 35;
        int studentIdToSearch = 75;
//        int treeMapRemoveByKey = 89;
//        int hashMapRemoveByKey = 89;
        long start = System.currentTimeMillis();
        long duration = System.currentTimeMillis() - start;



        for (int numOfStudents = 100000; numOfStudents<=1000000;numOfStudents+=100000) {

            Student[] students = new Student[numOfStudents];

            start = System.currentTimeMillis();
            for (int i = 0; i < numOfStudents; ++i) {
                Student randomStudent = new Student(i,
                        randomSurname(minSurnameLength, maxSurnameLength),
                        randomMarks(minNumOfMarks, maxNumOfMarks));
                students[i] = randomStudent;
            }
            duration = System.currentTimeMillis() - start;

            System.out.printf("%16d", numOfStudents);
            System.out.printf("|");
            System.out.printf("%11d", duration);
            System.out.printf(" ms||");

            System.out.printf("%8d", putTest(students, treeMap, hashMap)[0]);
            System.out.printf(" ms|");
            System.out.printf("%8d", putTest(students, treeMap, hashMap)[1]);
            System.out.printf(" ms||");

            Student containsStudent = students[studentIdToSearch];
            System.out.printf("%8d", containsTest(containsStudent, treeMap, hashMap)[0]);
            System.out.printf(" ms|");
            System.out.printf("%8d", containsTest(containsStudent, treeMap, hashMap)[1]);
            System.out.printf(" ms||");

//            System.out.printf("%8d", removeTest(treeMapRemoveByKey, hashMapRemoveByKey, treeMap, hashMap)[0]);
//            System.out.printf(" ms|");
//            System.out.printf("%8d", removeTest(treeMapRemoveByKey, hashMapRemoveByKey, treeMap, hashMap)[1]);
//            System.out.print(" ms||\n");

            System.out.printf("%8d", removeAllTest(treeMap, hashMap)[0]);
            System.out.printf(" ms|");
            System.out.printf("%8d", removeAllTest(treeMap, hashMap)[1]);
            System.out.print(" ms||\n");

            studentIdToSearch = numOfStudents/5;
//            treeMapRemoveByKey = numOfStudents/5;
//            hashMapRemoveByKey = numOfStudents/5;
            Arrays.fill(students,null);

        }

        System.out.println("================================================" +
                "============================================================");


        Student randomStudent = new Student(14561,
                randomSurname(minSurnameLength, maxSurnameLength),
                randomMarks(minNumOfMarks, maxNumOfMarks));
        System.out.println("\nData example: " + randomStudent.toString());


    }


}
