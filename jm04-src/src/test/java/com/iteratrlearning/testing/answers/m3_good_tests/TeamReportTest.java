package com.iteratrlearning.testing.answers.m3_good_tests;

import com.iteratrlearning.testing.problems.m3_good_tests.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.iteratrlearning.testing.answers.m3_good_tests.TeamReport.minPenaltyRatio;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class TeamReportTest
{
    private static final Player rooney =
        new Player("Wayne Rooney", 10, 1, 103, 50);
    private static final Player messi =
        new Player("Lionel Messi", 13, 11, 187, 187);
    private static final Player ballack =
        new Player("Michael Ballack", 10, 10, 78, 78);

    private static final List<Player> aTeam = Arrays.asList(
        rooney,
        new Player("John Terry", 7, 0, 76, 13),
        new Player("Steven Gerrard", 15, 3, 134, 27));

    private static final List<Player> anotherTeam = Arrays.asList(
        ballack,
        messi,
        new Player("Andrea Barzagli", 0, 0, 222, 2));

    @Test
    public void shouldNotReturnPlayerBelowPenaltyRatio()
    {
        final TeamReport report = TeamReport.calculate(aTeam);

        assertNull(report.getAcceptablePenaltyTaker(), "Overly optimistic about English Penalty abilities");
    }

    @Test
    public void shouldReturnPenaltyTakerAbovePenaltyRatio()
    {
        final TeamReport report = TeamReport.calculate(anotherTeam);

        assertThat("Penalty taker is too bad", ballack.penaltyScoringRatio(), greaterThan(minPenaltyRatio));
        assertEquals(ballack, report.getAcceptablePenaltyTaker(), "Wrong acceptable penalty taker");
    }

    @Test
    public void shouldGetMostLikelyScorer()
    {
        final TeamReport report = TeamReport.calculate(aTeam);

        assertEquals(rooney, report.getMostLikelyScorer(), "Wrong most likely scorer");
    }

    @Test
    public void shouldGetMostLikelyScorerIfTied()
    {
        final TeamReport report = TeamReport.calculate(anotherTeam);
        final Player mostLikelyScorer = report.getMostLikelyScorer();

        assertThat("Wrong most likely scorer when tied",
                mostLikelyScorer, either(equalTo(ballack)).or(equalTo(messi)));
    }

}
