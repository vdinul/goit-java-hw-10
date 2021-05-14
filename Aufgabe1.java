/* VOLODYMYR DINUL
 * GOIT
 * Hausaufgaben #10
 * Aufgabe #1
 * Метод принимает на вход список имен.
 * Вернуть строку в виде: "1. Ivan, 3. Peter ...", с именами из списка,
 * стоящими под нечетным индексом (1, 3 и т.д.).
 * */

// LONG LIVE HERBERT SCHILDT

package main.java.ua.goit.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aufgabe1 {
    public static void main(String[] args) {
        // declare a list that will contain a name and an id associated with that name
        ArrayList<Personen> reihe = new ArrayList<>();

        // populate the list
        reihe.add(new Personen(1, "Petro"));
        reihe.add(new Personen(2, "Pavlo"));
        reihe.add(new Personen(3, "Vasyl"));
        reihe.add(new Personen(4, "Semen"));
        reihe.add(new Personen(5, "Sydir"));
        reihe.add(new Personen(6, "Eugene"));
        reihe.add(new Personen(7, "Ivan"));
        reihe.add(new Personen(8, "Ξένια"));

        // the little cuttie instance of applying Stream API to the list
        List<Personen> neueReihe = reihe.stream()
                .filter(i -> i.id % 2 != 0)
                .collect(Collectors.toList());

        // formatted output
        System.out.println("Persons and their corresponding indices in the output list:");
        for(Personen e: neueReihe)
            System.out.println(e.id + ". " + e.name);
    }
}

class Personen {
    int id;
    String name;

    public Personen(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
