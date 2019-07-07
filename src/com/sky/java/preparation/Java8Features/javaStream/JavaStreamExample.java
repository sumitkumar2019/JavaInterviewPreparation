package com.sky.java.preparation.Java8Features.javaStream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class JavaStreamExample {
    public static void main(String[] args) {

        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        //Filtering and getting result without Stream
        List<Float> productPriceList = new ArrayList<>();
        for(Product product: productsList){

            // filtering data of list
            if(product.price<30000){
                productPriceList.add(product.price);    // adding price to a productPriceList
            }
        }
        System.out.println(productPriceList);   // displaying data*/

        //Filtering and getting result with Stream
        List<Float> prices = productsList
                .stream()
                .filter(product -> product.price < 30000)
                .map(product -> product.price)
                .collect(Collectors.toList());
        System.out.println(prices);

        //Using IntStream
        int[] numbers = {4, 1, 13, 90, 16, 2, 0};
        IntStream.of(numbers).min().getAsInt(); // can throw exception in case array is empty
        IntStream.of(numbers).min().ifPresent(min-> System.out.println(min)); //safe no exception

        System.out.println(IntStream.of(numbers).max().getAsInt()); //getting maximum
        System.out.println(IntStream.of(numbers).average().getAsDouble()); //getting average
        System.out.println(IntStream.of(numbers).count());//getting count
        System.out.println(IntStream.of(numbers).sum());//getting sum

        //Using IntSummary Statistics
        IntSummaryStatistics  statistics = IntStream.of(numbers).summaryStatistics();
        System.out.println(statistics.getMin()); //getting minimum
        System.out.println(statistics.getMax()); //getting maximum
        System.out.println(statistics.getAverage());//getting average
        System.out.println(statistics.getCount()); //getting count
        System.out.println(statistics.getSum()); //getting sum

        //IntStream will create a copy of array not mutate the original array
        //get first 3 minimum numbers
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        //skip first 3
        IntStream.of(numbers)
                .distinct()
                .sorted()
                .skip(3)
                .forEach(System.out::println);

        //Convert to wrapper classes
        IntStream
                .of(numbers)
                .boxed()
                .collect(Collectors.toList()).forEach(System.out::println);

        //Print in a give range
        IntStream.range(1,100).forEach(System.out::println);

        //Convert a range in to an array
        int x[] = IntStream.range(1,100).toArray();

        // if anyone matches as per predicate returns true
        System.out.println(IntStream.of(numbers).anyMatch(num->num%2 == 1));
        // if all matches as per predicate returns true
        System.out.println(IntStream.of(numbers).allMatch(num->num%2 == 1));

        // iterate 5 times number divisible by 5
        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);

        //Filtering and iterating collection
        productsList.stream()
                .filter(product->product.price ==30000)
                .forEach(product -> System.out.println(product.price));

    }


}
