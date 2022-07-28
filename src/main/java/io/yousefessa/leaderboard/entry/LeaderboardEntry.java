package io.yousefessa.leaderboard.entry;

import org.jetbrains.annotations.NotNull;

public abstract class LeaderboardEntry<T, D> implements Comparable<T> {
    private final int rank;
    private final D data;

    protected LeaderboardEntry(final int rank, final D data) {
        this.rank = rank;
        this.data = data;
    }

    public abstract String serialize();

    @Override
    public int compareTo(@NotNull final T o) {
        return 0;
    }

    public int getRank() {
        return rank;
    }

    public D getData() {
        return data;
    }
}
