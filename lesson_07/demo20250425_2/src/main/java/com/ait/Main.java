package com.ait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Person p = new Person("Jack", 18);
        Person[] people = {
                new Person("john", 22),
                new Person("lena", 23),
                new Person("igor", 25),
                new Person("mike", 21),
        };

            String json = mapper.writeValueAsString(p);
            mapper.writeValue(new File("p1.json"), p);
            mapper.writeValue(new File("p2.json"), people);
            System.out.println(json);

        Person person = mapper.readValue(new File("p1.json"), Person.class);
        // Person[] people1 = mapper.readValue(new File("p2.json"), Person[].class);
        // new TypeReference<HashSet<Person>>() используеться для переопределения типа дженерика в ArrayList либо в HashSet
        HashSet<Person> people1 = mapper.readValue(new File("p2.json"), new TypeReference<HashSet<Person>>() {});
        System.out.println("person:" + person);
       // System.out.println(Arrays.toString(people1));
        System.out.println(people1);


    }
}
