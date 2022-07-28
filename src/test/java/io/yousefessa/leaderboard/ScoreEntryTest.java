package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.sample.ScoreEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScoreEntryTest {
    private ScoreEntry lowEntry;
    private ScoreEntry highEntry;

    @BeforeAll
    void setUp() {
        this.lowEntry = ScoreEntry.of(10);
        this.highEntry = ScoreEntry.of(20);
    }

    @Test
    void lowEntryShouldBeLesserThanHighEntry() {
        assertEquals(-1, lowEntry.compareTo(highEntry));
    }

    @Test
    void highEntryShouldBeHigherThanLowEntry() {
        assertEquals(1, highEntry.compareTo(lowEntry));
    }
}
