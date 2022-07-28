package io.yousefessa.leaderboard.entry.adapter;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;

public abstract class EntryAdapter<T extends LeaderboardEntry<?>> {
    public abstract T createInstance(final String serializedData);
    public abstract T createInstance(final int rank, final String serializedData);
}
