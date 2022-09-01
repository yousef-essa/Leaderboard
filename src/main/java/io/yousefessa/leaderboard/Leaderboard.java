package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;

public interface Leaderboard<T extends LeaderboardEntry<T, ?>> {
    void addEntry(LeaderboardEntry<T, ?> entry);
    T getEntry(final int rank);
}
