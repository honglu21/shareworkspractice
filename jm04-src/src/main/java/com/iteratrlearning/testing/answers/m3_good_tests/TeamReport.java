package com.iteratrlearning.testing.answers.m3_good_tests;

import com.iteratrlearning.testing.problems.m3_good_tests.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamReport
{
    private static final Random random = new Random();

    static final double minPenaltyRatio = 0.25;

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
        final List<Player> mostLikelyScorers = new ArrayList<>();
        for (Player player : team)
        {
            final double goalScoringRatio = player.goalScoringRatio();
            if (goalScoringRatio >= mostLikelyScorerRatio)
            {
                if (goalScoringRatio > mostLikelyScorerRatio)
                {
                    mostLikelyScorers.clear();
                }

                mostLikelyScorers.add(player);
                mostLikelyScorerRatio = goalScoringRatio;
            }
        }

        final Player mostLikelyScorer = mostLikelyScorers.get(random.nextInt(mostLikelyScorers.size()));

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
