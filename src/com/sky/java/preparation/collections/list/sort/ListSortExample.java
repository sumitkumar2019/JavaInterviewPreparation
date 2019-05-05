package com.sky.java.preparation.collections.list.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortExample {

    public static void main(String[] args) {


        List<Integer> integerList = List.of(132,13,1,134); /**Immutable List**/
        List<Integer> newList = new ArrayList<>(integerList); /**Mutable List**/
        System.out.println(newList);

        //newList.sort();//for directly using sort() method of array list needs comparator

        Collections.sort(newList);
        System.out.println(newList);

        List<Student> students = List.of(new Student(2,"Adam"),new Student(1,"eve"));/**Immutable List**/
        List<Student> studentList = new ArrayList<>(students);/**Mutable List**/

        System.out.println(studentList);

        //Class should implement comparable: Wrapper classes already implement comparable
        Collections.sort(studentList);//without comparator
        System.out.println(studentList);

        studentList.sort(new StudentDescendingComparator());
        System.out.println(studentList);

        Collections.sort(studentList, new StudentAscendingComparator());
        System.out.println(studentList);

        Collections.sort(studentList, new StudentDescendingComparator()); //with comparator
        System.out.println(studentList);

    }
}
