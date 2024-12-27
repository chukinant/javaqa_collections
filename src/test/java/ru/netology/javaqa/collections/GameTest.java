package ru.netology.javaqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GameTest {

    @Test
    void shouldRegister() {
        Player p1 = new Player(1, "Marusya", 4);
        Player p2 = new Player(2, "Frosya", 6);
        Player p3 = new Player(3, "Olesya", 6);

        ArrayList<Player> playersList = new ArrayList<>();

        Game players = new Game(playersList);

        players.register(p1);
        players.register(p2);
        players.register(p3);

        ArrayList<Player> playersExpected = new ArrayList<>();

        playersExpected.add(p1);
        playersExpected.add(p2);
        playersExpected.add(p3);

        Assertions.assertEquals(players.getPlayersList(), playersExpected);
    }

    @Test
    void shouldGenerateAlreadyExistsException() {  // проверка выдачи ошибки при попытке добавить уже зарегистрированного пользователя
        Player p1 = new Player(1, "Marusya", 4);
        Player p2 = new Player(2, "Frosya", 6);
        Player p3 = new Player(3, "Olesya", 6);

        ArrayList<Player> playersList = new ArrayList<>();

        Game players = new Game(playersList);

        players.register(p1);
        players.register(p2);
        players.register(p3);

        Assertions.assertThrows(AlreadyExistsException.class,  () -> {
            players.register(p1);
        });
    }

    @Test
    void shouldGenerateNotRegisteredException1() {  // проверка выдачи ошибки при попытке запустить игру с незарегистированным player1
        Player p1 = new Player(1, "Marusya", 4);
        Player p2 = new Player(2, "Frosya", 6);

        ArrayList<Player> playersList = new ArrayList<>();

        Game newGame = new Game(playersList);

        newGame.register(p1);
        newGame.register(p2);

        Assertions.assertThrows(NotRegisteredException.class,  () -> {
            newGame.round("Olesya", "Frosya");
        });
    }

    @Test
    void shouldGenerateNotRegisteredException2() {  // проверка выдачи ошибки при попытке запустить игру с незарегистированным player2
        Player p1 = new Player(1, "Marusya", 4);
        Player p2 = new Player(2, "Frosya", 6);

        ArrayList<Player> playersList = new ArrayList<>();

        Game newGame = new Game(playersList);

        newGame.register(p1);
        newGame.register(p2);

        Assertions.assertThrows(NotRegisteredException.class,  () -> {
            newGame.round("Marusya", "Olesya");
        });
    }

    @Test
    void FirstPlayerWins() {
        Player p1 = new Player(1, "Marusya", 10);
        Player p2 = new Player(2, "Frosya", 6);

        ArrayList<Player> playersList = new ArrayList<>();

        Game newGame = new Game(playersList);

        newGame.register(p1);
        newGame.register(p2);

        int expected = 1;
        int actual = newGame.round("Marusya", "Frosya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void SecondPlayerWins() {
        Player p1 = new Player(1, "Marusya", 4);
        Player p2 = new Player(2, "Frosya", 6);

        ArrayList<Player> playersList = new ArrayList<>();

        Game newGame = new Game(playersList);

        newGame.register(p1);
        newGame.register(p2);

        int expected = 2;
        int actual = newGame.round("Marusya", "Frosya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void NoOneWins() {
        Player p1 = new Player(1, "Marusya", 10);
        Player p2 = new Player(2, "Frosya", 10);

        ArrayList<Player> playersList = new ArrayList<>();

        Game newGame = new Game(playersList);

        newGame.register(p1);
        newGame.register(p2);

        int expected = 0;
        int actual = newGame.round("Marusya", "Frosya");
        Assertions.assertEquals(expected, actual);
    }
}