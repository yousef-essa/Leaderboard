package io.yousefessa.leaderboard.entry.adapter;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;

public abstract class EntryAdapter<T extends LeaderboardEntry<?>> {
    public abstract T createEntry(final String serializedData);
    public abstract T createEntry(final int rank, final String serializedData);
}
