package com.iteratrlearning.testing.problems.m3_good_tests;

import java.util.List;

public class TeamReport
{
    private static final double minPenaltyRatio = 0.25;

    private final Player acceptablePenaltyTaker;
    private final Player mostLikelyScorer;

    public TeamReport(
        final Player acceptablePenaltyTaker,
        final Player mostLikelyScorer)
    {
        this.acceptablePenaltyTaker = acceptablePenaltyTaker;
        this.mostLikelyScorer = mostLikelyScorer;
    }

    public static TeamReport calculate(final List<Player> team)
    {
        if (team.size() < 2)
        {
            throw new IllegalArgumentException(team + " isn't a team!");
        }

        double acceptablePenaltyTakerRatio = 0.0;
        Player acceptablePenaltyTaker = null;
        for (Player player : team)
        {
            final double penaltyScoringRatio = player.penaltyScoringRatio();
            if (penaltyScoringRatio > minPenaltyRatio &&
                penaltyScoringRatio > acceptablePenaltyTakerRatio)
            {
                acceptablePenaltyTaker = player;
                acceptablePenaltyTakerRatio = penaltyScoringRatio;
            }
        }

        double mostLikelyScorerRatio = 0.0;
        Player mostLikelyScorer = null;
        for (Player player : team)
        {
            final double goalScoringRatio = player.goalScoringRatio();
            if (goalScoringRatio > mostLikelyScorerRatio)
            {
                mostLikelyScorer = player;
                mostLikelyScorerRatio = goalScoringRatio;
            }
        }

        return new TeamReport(acceptablePenaltyTaker, mostLikelyScorer);
    }

    public Player getAcceptablePenaltyTaker()
    {
        return acceptablePenaltyTaker;
    }

    public Player getMostLikelyScorer()
    {
        return mostLikelyScorer;
    }
}
