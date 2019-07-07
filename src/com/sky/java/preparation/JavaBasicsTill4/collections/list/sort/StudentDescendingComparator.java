package com.sky.java.preparation.JavaBasicsTill4.collections.list.sort;

import java.util.Comparator;

public class StudentDescendingComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student2.getId(), student1.getId());
    }
}
