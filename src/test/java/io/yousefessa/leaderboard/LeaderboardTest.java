package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.sample.ScoreAdapter;
import io.yousefessa.leaderboard.sample.ScoreEntry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public final class LeaderboardTest {
    private Leaderboard<ScoreEntry> leaderboard;

    @BeforeAll
    void setUp() {
        this.leaderboard = new Leaderboard<>(3, new ScoreAdapter());
    }

    @Test
    @Order(1)
    void rankOneShouldBeNull() {
        assertNull(this.leaderboard.getEntry(1));
    }

    @Test
    @Order(2)
    void addEntryForRankOne() {
        this.leaderboard.addEntry(ScoreEntry.of(10));
    }

    @Test
    @Order(3)
    void rankOneShouldNotBeNull() {
        final ScoreEntry entry = this.leaderboard.getEntry(1);
        assertNotNull(entry);
    }

    @Test
    @Order(4)
    void rankOneShouldHave10Score() {
        final ScoreEntry entry = this.leaderboard.getEntry(1);
        assertEquals(10, entry.getData());
    }

    @Test
    @Order(5)
    void addEntryForRankTwo() {
        this.leaderboard.addEntry(ScoreEntry.of(11));
    }

    @Test
    @Order(6)
    void rankTwoShouldNotBeNull() {
        final ScoreEntry entry = this.leaderboard.getEntry(2);
        assertNotNull(entry);
    }

    @Test
    @Order(7)
    void rankTwoShouldHave11Score() {
        final ScoreEntry entry = this.leaderboard.getEntry(2);
        assertEquals(11, entry.getData());
    }
}