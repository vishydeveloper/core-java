package com.baeldung.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerNameSorter {

    public static void main(String[] args) {
        
        List<Player> footballTeam = new ArrayList<Player>();
        Player player3 = new Player(45, "Steven", 24);
        Player player1 = new Player(59, "John", 22);
        Player player2 = new Player(67, "Roger", 20);
        Player player4 = new Player(59, "Alex", 22);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
        footballTeam.add(player4);

        System.out.println("Before Sorting : " + footballTeam);
        //Instance of PlayerAgeComparator
        PlayerNameComparator playerComparator = new PlayerNameComparator();
        Collections.sort(footballTeam, playerComparator);
        System.out.println("After Sorting by age : " + footballTeam);
        
    }

}
