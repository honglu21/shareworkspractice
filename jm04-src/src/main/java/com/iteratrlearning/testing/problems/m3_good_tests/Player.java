package com.iteratrlearning.testing.problems.m3_good_tests;

public class Player
{
    private final String name;
    private final int penaltiesTaken;
    private final int penaltiesScored;
    private final int gamesPlayed;
    private final int goalsScored;

    public Player(
        final String name,
        final int penaltiesTaken,
        final int penaltiesScored,
        final int gamesPlayed,
        final int goalsScored)
    {
        this.name = name;
        this.penaltiesTaken = penaltiesTaken;
        this.penaltiesScored = penaltiesScored;
        this.gamesPlayed = gamesPlayed;
        this.goalsScored = goalsScored;
    }

    public String getName()
    {
        return name;
    }

    public int getPenaltiesTaken()
    {
        return penaltiesTaken;
    }

    public int getPenaltiesScored()
    {
        return penaltiesScored;
    }

    public double penaltyScoringRatio()
    {
        return ((double) penaltiesScored) / ((double) penaltiesTaken);
    }

    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    public int getGoalsScored()
    {
        return goalsScored;
    }

    public double goalScoringRatio()
    {
        return ((double) goalsScored) / ((double) gamesPlayed);
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "name='" + name + '\'' +
                ", penaltiesTaken=" + penaltiesTaken +
                ", penaltiesScored=" + penaltiesScored +
                ", gamesPlayed=" + gamesPlayed +
                ", goalsScored=" + goalsScored +
                '}';
    }
}
