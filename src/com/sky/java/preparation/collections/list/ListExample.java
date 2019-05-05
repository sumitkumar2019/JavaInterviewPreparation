package com.sky.java.preparation.collections.list;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {

        /***Immutable List**/
        List<String>  words = List.of("Apple", "Bat","Cat");
        System.out.println(words);

        // words.add("Dog"); //java.lang.UnsupportedOperationException: Immutable list

        System.out.println(words.size());
        System.out.println(words.isEmpty());

        System.out.println(words.get(0));
        System.out.println(words.get(1));
        System.out.println(words.get(2));
        //System.out.println(words.get(3)); //java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

        System.out.println(words.contains("Dog"));
        System.out.println(words.contains("Cat"));
        System.out.println(words.indexOf("Cat"));
        System.out.println(words.indexOf("Dog")); //-1

        /**Mutable List**/
        List<String> wordArrayLists = new ArrayList<>(words); // uses array as a data structure

        wordArrayLists.add("Dog");
        wordArrayLists.add("Dog");//Duplicates allowed
        wordArrayLists.add("Dog");
        wordArrayLists.add(2,"Elephant");

        List<String> newList = List.of("Yak", "Zebra");
        wordArrayLists.addAll(newList);
        wordArrayLists.addAll(2, newList);
        wordArrayLists.set(3, "Fish");


        System.out.println(wordArrayLists);

        wordArrayLists.remove(3);
        System.out.println(wordArrayLists);

        wordArrayLists.remove("Dog");
        System.out.println(wordArrayLists);

        //Using for loop
        for(int i=0; i<wordArrayLists.size();i++) System.out.println(wordArrayLists.get(i));

        //Using for each loop
        for(String word:wordArrayLists) System.out.println(word);

        //Using iterator
        Iterator<String> wordIterator = wordArrayLists.iterator();
        while(wordIterator.hasNext())  System.out.println(wordIterator.next());

        //LinkedList
        List<String> wordLinkedLists = new LinkedList<>(words);// uses linked lists as a data structure

        //Vector
        List<String> wordVectors = new Vector<>(words);// uses array as a data structure

        wordLinkedLists.add("Dog");
        wordVectors.add("Dog"); //Vector: all methods are Synchronised hence thread safe

        System.out.println(wordLinkedLists);
        System.out.println(wordVectors);

        List value = List.of("A", 'A', 1, 1.0); //Autoboxing example: primitives not allowed
        System.out.println(value.get(2));
        System.out.println(value.get(2) instanceof Integer);
        System.out.println(value.get(1) instanceof Character);
        System.out.println(value.get(3) instanceof Double);

        List<Integer> integerValue = List.of(110,111,112,113); //Autoboxing example: primitives not allowed
        System.out.println(integerValue.indexOf(111));
        //System.out.println(integerValue.remove(111)); //UnsupportedOperationException: because of ambiguity :remove(index) & remove(Object)
        System.out.println(integerValue);
    }
}
