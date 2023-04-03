package com.baeldung.comparator;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class PlayerAgeSorterTest {


    @Test
    public void testChainedSorting()
    {
        // Create the collection of people:
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Dan", 4));
        people.add(new Person("Andi", 2));
        people.add(new Person("Bob", 42));
        people.add(new Person("Debby", 3));
        people.add(new Person("Bob", 72));
        people.add(new Person("Barry", 20));
        people.add(new Person("Cathy", 40));
        people.add(new Person("Bob", 40));
        people.add(new Person("Barry", 50));

        System.out.println(people);

        // Define chained comparators:
        // Great article explaining this and how to make it even neater:
        // http://blog.jooq.org/2014/01/31/java-8-friday-goodies-lambdas-and-sorting/
        Comparator<Person> comparator = Comparator.comparing(person -> person.name);
        comparator = comparator.thenComparing(Comparator.comparing(person -> person.age));

        // Sort the stream:
        Stream<Person> personStream = people.stream().sorted(comparator);

        // Make sure that the output is as expected:
        List<Person> sortedPeople = personStream.collect(Collectors.toList());
        System.out.println(sortedPeople);

        assertEquals("Andi",  sortedPeople.get(0).name); assertEquals(2,  sortedPeople.get(0).age);
        assertEquals("Barry", sortedPeople.get(1).name); assertEquals(20, sortedPeople.get(1).age);
        assertEquals("Barry", sortedPeople.get(2).name); assertEquals(50, sortedPeople.get(2).age);
        assertEquals("Bob",   sortedPeople.get(3).name); assertEquals(40, sortedPeople.get(3).age);
        assertEquals("Bob",   sortedPeople.get(4).name); assertEquals(42, sortedPeople.get(4).age);
        assertEquals("Bob",   sortedPeople.get(5).name); assertEquals(72, sortedPeople.get(5).age);
        assertEquals("Cathy", sortedPeople.get(6).name); assertEquals(40, sortedPeople.get(6).age);
        assertEquals("Dan",   sortedPeople.get(7).name); assertEquals(4,  sortedPeople.get(7).age);
        assertEquals("Debby", sortedPeople.get(8).name); assertEquals(3,  sortedPeople.get(8).age);
        // Andi     : 2
        // Barry    : 20
        // Barry    : 50
        // Bob      : 40
        // Bob      : 42
        // Bob      : 72
        // Cathy    : 40
        // Dan      : 4
        // Debby    : 3
    }

    /**
     * A person in our system.
     */
    public static class Person
    {
        /**
         * Creates a new person.
         * @param name The name of the person.
         * @param age The age of the person.
         */
        public Person(String name, int age)
        {
            this.age = age;
            this.name = name;
        }

        /**
         * The name of the person.
         */
        public String name;

        /**
         * The age of the person.
         */
        public int age;

        @Override
        public String toString()
        {
            if (name == null) return super.toString();
            else return String.format("%s : %d", this.name, this.age);
        }
    }

}