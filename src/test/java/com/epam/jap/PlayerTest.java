package com.epam.jap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerTest {


    @DataProvider
    public Object[][] gamesWithRequiredSkills(){
        return new Object[][] {
                {Games.BASKETBALL, "catching the ball with my hands and then dribbling, passing or rebounding the ball and finally throwing the ball into the basket"},
                {Games.FOOTBALL, "receiving the ball with my feet or head and then dribbling or passing the ball and finally shooting the ball to score a goal"},
                {Games.VOLLEYBALL, "blocking or digging the ball and then passing the ball and finally spiking to score a point"},
                {Games.BACKYARD_GAME, "catching the ball and then passing or hitting the ball or whatever actions my team allows and scoring a point or not depending on the rules"}
        };
    }

    @Test(dataProvider = "gamesWithRequiredSkills")
    public void playerShouldUseAdequateTechniques(Games game, String result) {
        //given
        var player = new Player(game);

        //when
        var actual = player.play();

        //then
        Assert.assertEquals(actual, result);
    }

}