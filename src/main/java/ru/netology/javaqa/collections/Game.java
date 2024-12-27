package ru.netology.javaqa.collections;

import java.util.ArrayList;

public class Game {
    ArrayList<Player> playersList;

    public Game(ArrayList<Player> playersList) {
        this.playersList = playersList;
    }

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public void register(Player player) {
        if (playersList.contains(player)) {
            throw new AlreadyExistsException(player + " is in the list.");
        } else playersList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : playersList) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            } else if (player.getName().equals(playerName2)) {
                player2 = player;
            } else {
                throw new NotRegisteredException("Player(s) not found");
            }
        }
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            }
            else if (player1.getStrength() < player2.getStrength()) {
                return 2;
            }
            else return 0;
    }
}
