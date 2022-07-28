package io.yousefessa.leaderboard.entry;

import org.jetbrains.annotations.NotNull;

public abstract class LeaderboardEntry<T> implements Comparable<LeaderboardEntry<T>> {
    private final int rank;
    private final T data;

    protected LeaderboardEntry(final int rank, final T data) {
        this.rank = rank;
        this.data = data;
    }

    public abstract String serialize();

    @Override
    public int compareTo(@NotNull final LeaderboardEntry<T> o) {
        return 0;
    }

    public int getRank() {
        return rank;
    }

    public T getData() {
        return data;
    }
}