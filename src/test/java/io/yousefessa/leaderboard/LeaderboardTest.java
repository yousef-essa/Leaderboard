package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;
import io.yousefessa.leaderboard.entry.SimpleLeaderboardEntry;
import io.yousefessa.leaderboard.entry.factory.DefaultEntryFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LeaderboardTest {
    private static final int SIZE = 3;
    public static final String STRING_DATA_FORMAT = "important_data_here_%d";

    @Test
    public void testEntryOrderOfRanking() {
        final DefaultEntryFactory entryFactory = new DefaultEntryFactory();
        final Leaderboard<SimpleLeaderboardEntry<?>> leaderboard = LeaderboardHelper.constructLeaderboard(3,
                (rank, serializedData) -> (LeaderboardEntry<SimpleLeaderboardEntry<?>, ?>) entryFactory.deserialize(rank, serializedData));

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            final int rank = i + 1;
            final LeaderboardEntry<SimpleLeaderboardEntry<?>, String> entry = entryFactory.construct(rank,
                    String.format(STRING_DATA_FORMAT, i));

            leaderboard.addEntry(entry);
        }

        for (int rank = 1; rank < 4; rank++) {
            System.out.println(rank);
            final SimpleLeaderboardEntry<?> entry = leaderboard.getEntry(rank);
            assertEquals(entry.getRank(), rank);
        }
    }
}