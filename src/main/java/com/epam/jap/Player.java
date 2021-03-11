package com.epam.jap;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Player {
    private Games game;

    Player(Games game) {
        this.game = game;
    }

    public static void main(String[] args) {
        Player player = new Player(Games.BASKETBALL);
        System.out.println("Basketball player's actions: "+ player.play());
        player.changeGame(Games.VOLLEYBALL);
        System.out.println("Volleyball player's actions: "+ player.play());
    }

    void changeGame(Games newGame) {
        this.game = newGame;
    }

    String play() {
        List<Supplier<String>> actionsInGame = List.of(() -> takeBall(),() -> intermediateActions(), () -> earnPoint() );
        Supplier<String> playerActions = () -> actionsInGame.stream().map(Supplier::get).collect(Collectors.joining(" and "));
        return playerActions.get();
    }

    private String takeBall() {
        return  switch (game){
            case BASKETBALL -> "catching the ball with my hands";
            case FOOTBALL -> "receiving the ball with my feet or head";
            case VOLLEYBALL -> "blocking or digging the ball";
            case BACKYARD_GAME -> "catching the ball";
        };
    }

    private String intermediateActions() {
        return  switch (game){
            case BASKETBALL -> "then dribbling, passing or rebounding the ball";
            case FOOTBALL -> "then dribbling or passing the ball";
            case VOLLEYBALL -> "then passing the ball";
            case BACKYARD_GAME -> "then passing or hitting the ball or whatever actions my team allows";
        };
    }

    private String earnPoint() {
        return  switch (game){
            case BASKETBALL -> "finally throwing the ball into the basket";
            case FOOTBALL -> "finally shooting the ball to score a goal";
            case VOLLEYBALL -> "finally spiking to score a point";
            case BACKYARD_GAME -> "scoring a point or not depending on the rules";
        };
    }
}

enum Games {
    BASKETBALL, FOOTBALL, VOLLEYBALL, BACKYARD_GAME
}