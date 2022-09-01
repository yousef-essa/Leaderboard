package io.yousefessa.leaderboard.entry.factory;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;
import io.yousefessa.leaderboard.entry.SimpleLeaderboardEntry;

public class DefaultEntryFactory implements EntryFactory {
    @Override
    public LeaderboardEntry<?, ?> deserialize(final String serializedData) {
        return SimpleLeaderboardEntry.deserialize(serializedData);
    }

    @Override
    public LeaderboardEntry<?, ?> deserialize(final int rank, final String serializedData) {
        return SimpleLeaderboardEntry.deserialize(rank, serializedData);
    }

    @Override
    public <T, O extends Comparable<O>> LeaderboardEntry<T, O> construct(final int rank, final O data) {
        return (LeaderboardEntry<T, O>) new SimpleLeaderboardEntry<O>(rank, data);
    }
}
