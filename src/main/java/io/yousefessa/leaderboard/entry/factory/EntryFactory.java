package io.yousefessa.leaderboard.entry.factory;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;

public interface EntryFactory {
    LeaderboardEntry<?, ?> deserialize(final String serializedData);
    LeaderboardEntry<?, ?> deserialize(final int rank, final String serializedData);
    <T, O extends Comparable<O>> LeaderboardEntry<T, O> construct(final int rank, final O data);
}
