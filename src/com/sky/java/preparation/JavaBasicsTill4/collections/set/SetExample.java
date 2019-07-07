package com.sky.java.preparation.JavaBasicsTill4.collections.set;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> newSet = Set.of("Apple", "Ball", "BAll", "Cat");
        System.out.println(newSet);

        Set<String> newHashSet = new HashSet<>(newSet);
        System.out.println(newHashSet);

        newHashSet.add("Apple");
        System.out.println(newHashSet); //no duplicates not maintaining the order

        Set<Integer> newIntegerHashSet = new HashSet<>();
        newIntegerHashSet.add(765890);
        newIntegerHashSet.add(76589);
        newIntegerHashSet.add(7658);
        newIntegerHashSet.add(765);
        newIntegerHashSet.add(76);
        System.out.println(newIntegerHashSet); // no order maintained in HashSer

        Set<Integer> newIntegerLinkedHashSet = new LinkedHashSet<>();
        newIntegerLinkedHashSet.add(765890);
        newIntegerLinkedHashSet.add(76589);
        newIntegerLinkedHashSet.add(7658);
        newIntegerLinkedHashSet.add(765);
        newIntegerLinkedHashSet.add(76);
        System.out.println(newIntegerLinkedHashSet); //order maintained in LinkedHashSet

        List<Character> characterList = List.of('A', 'Z', 'Y', 'Z', 'A', 'B', 'F');

        Set<Character> characterHashSet = new HashSet<>(characterList);
        System.out.println(characterHashSet); //un ordered

        Set<Character> characterTreeSet = new TreeSet<>(characterList);
        System.out.println(characterTreeSet); //Sorted order

        Set<Character> characterLinkedHashSet = new LinkedHashSet<>(characterList);
        System.out.println(characterLinkedHashSet); //added order

        TreeSet<Integer> integerTreeSet = new TreeSet<>(Set.of(65,54,34,12,99));
        System.out.println(integerTreeSet); //Sorted order

        //Set important methods
        System.out.println(integerTreeSet.floor(40)); //34
        System.out.println(integerTreeSet.floor(34)); //34
        System.out.println(integerTreeSet.lower(34)); //12
        System.out.println(integerTreeSet.ceiling(34)); //34
        System.out.println(integerTreeSet.ceiling(36)); //54
        System.out.println(integerTreeSet.higher(34)); //54
        System.out.println(integerTreeSet.subSet(20,80)); //[34,54,65]
        System.out.println(integerTreeSet.subSet(34,54)); //[34] not inclusive
        System.out.println(integerTreeSet.subSet(34,true,54, true)); //[34,54] inclusive
        System.out.println(integerTreeSet.subSet(34,false,65, false)); //[54] not inclusive
        System.out.println(integerTreeSet.subSet(34,65)); //[34, 54]
        System.out.println(integerTreeSet.headSet(50)); //[12,34]
        System.out.println(integerTreeSet.tailSet(50)); //[54,65,99]





    }
}
