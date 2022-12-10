package com.iteratrlearning.testing.problems.m3_good_tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// TODO: 1. rename tests to be more descriptive
// TODO: 2. Make the minimum penalty ratio 0.25 - refactoring tests as appropriate
// TODO: 3. Add readable diagnostic messages to your test asserts. alter the test input data
// To force a failure and check that it's readable. Hint: Matchers.greaterThan
// TODO: 4. Alter the most likely scorer algorithm to randomly pick between tied
// Players and update tests. Hint: java.util.random, Matchers.either()
// TODO: 5. Remove duplication about looking up players

public class TeamReportTest
{
    private static final List<Player> aTeam = Arrays.asList(
            new Player("Wayne Rooney", 10, 1, 103, 50),
            new Player("John Terry", 7, 0, 76, 13),
            new Player("Steven Gerrard", 15, 3, 134, 27));

    private static final List<Player> anotherTeam = Arrays.asList(
            new Player("Michael Ballack", 10, 10, 78, 78),
            new Player("Lionel Messi", 13, 11, 187, 187),
            new Player("Andrea Barzagli", 0, 0, 222, 2));

    @BeforeEach
    public void setUp() {


    }

    @Test
    public void test_report_a_team_with_penaltyBad_returnNonePlayer()
    {
        final TeamReport report = TeamReport.calculate(aTeam);
        assertNull(report.getAcceptablePenaltyTaker(), "No player return below the minimum penalty ratio");
    }

    @Test
    public void test_report_a_team_with_penaltyGood_returnPlayer()
    {
        final TeamReport report = TeamReport.calculate(anotherTeam);
        final Player ballack = anotherTeam.get(0);

        assertTrue(ballack.penaltyScoringRatio() > 0.5, "Check a team player penaltyScoringRation is greater than minimum penalty ration");
        assertEquals(ballack, report.getAcceptablePenaltyTaker(), "Check the acceptablePenalty player match");
    }

    @Test
    public void test_report_a_team_player_scorer_1()
    {
        final TeamReport report = TeamReport.calculate(aTeam);
        final Player rooney = aTeam.get(0);

        assertEquals(rooney, report.getMostLikelyScorer(), "check first team get player goalScoringRatio greater than mostLikelyScorerRatio");
    }

    @Test
    public void test_report_a_team_plaer_scorer_2_first()
    {
        final TeamReport report = TeamReport.calculate(anotherTeam);
        final Player ballack = anotherTeam.get(0);

        assertEquals(ballack, report.getMostLikelyScorer(), "check the second team get player goalScoringRatio greater than mostLikelyScorerRatio");
    }

//    private TeamReport TeamReportCalcuate(Team team) {
//        return TeamReport.calculate(aTeam)
//    }

}
