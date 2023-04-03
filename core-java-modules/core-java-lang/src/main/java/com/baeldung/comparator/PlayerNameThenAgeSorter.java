package com.baeldung.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerNameThenAgeSorter {

    public static void main(String[] args) {
        
        List<Player> footballTeam = new ArrayList<Player>();
        Player player3 = new Player(45, "Steven", 24);
        Player player5 = new Player(33, "Alex", 44);
        Player player6 = new Player(32, "Alex", 10);
        Player player7 = new Player(22, "Alex", 44);
        Player player1 = new Player(59, "John", 22);
        Player player2 = new Player(67, "Roger", 20);
        Player player4 = new Player(59, "Alex", 22);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
        footballTeam.add(player4);
        footballTeam.add(player5);
        footballTeam.add(player6);
        footballTeam.add(player7);

        System.out.println("Before Sorting : " + footballTeam);
        //Instance of PlayerAgeComparator
        Comparator<Player> playerNameSorter = new PlayerNameComparator();
        Comparator<Player> playerNameThenAgeSorter = playerNameSorter.thenComparing(new PlayerAgeComparator());
//        Collections.sort(footballTeam, playerNameThenAgeSorter);

        Comparator<Player> comparator = Comparator.comparing(player -> player.name);
        comparator = comparator.thenComparing(Comparator.comparing(player -> player.age));

        // Sort the stream:
//        Stream<Player> personStream = footballTeam.stream().sorted(comparator);
        Stream<Player> personStream = footballTeam.stream().sorted(playerNameThenAgeSorter);

        // Make sure that the output is as expected:
        List<Player> sortedPeople = personStream.collect(Collectors.toList());

        System.out.println("After Sorting by name & then age : " + sortedPeople);
        
    }

}
