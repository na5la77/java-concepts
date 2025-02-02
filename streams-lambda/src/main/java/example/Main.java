package example;


import example.classes.Person;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
            List<Person> people = Arrays.asList(
                    new Person("Alice", 17),
                    new Person("Bob", 20),
                    new Person("Charlie", 22),
                    new Person("David", 15),
                    new Person("Eve", 25)
            );
    }
}
