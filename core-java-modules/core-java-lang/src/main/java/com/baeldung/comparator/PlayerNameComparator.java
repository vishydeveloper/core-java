package com.baeldung.comparator;

import java.util.Comparator;

public class PlayerNameComparator implements Comparator<Player> {

    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
       return firstPlayer.getName().compareTo(secondPlayer.getName());
    }

}
