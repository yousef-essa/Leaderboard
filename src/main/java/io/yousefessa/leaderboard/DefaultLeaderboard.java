package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;
import io.yousefessa.leaderboard.entry.adapter.EntryAdapter;

public final class DefaultLeaderboard<T extends LeaderboardEntry<T, ?>> implements Leaderboard<T> {
    private final int size;
    private final LeaderboardEntry<?, ?>[] positionEntry;
    private final EntryAdapter<T> adapter;
    private final SortBy sortBy;

    public DefaultLeaderboard(final int size, final EntryAdapter<T> adapter, final SortBy sortBy) {
        if (size <= 0) {
            throw new IllegalArgumentException("The leaderboard size must start from 1.");
        }

        this.size = size;
        this.positionEntry = new LeaderboardEntry[size];
        this.adapter = adapter;
        this.sortBy = sortBy;
    }

    @Override
    public void addEntry(LeaderboardEntry<T, ?> entry) {
        int rank = 0;
        for (int i = 0; i < size; i++) {
            rank++;

            final LeaderboardEntry<T, ?> element = (LeaderboardEntry<T, ?>) positionEntry[i];

            // if the element is null or lesser then, go to the next iteration
            if (element != null && sortBy.compareTo(element, entry) <= 0) {
                continue;
            }

            this.positionEntry[i] = adapter.createEntry(rank, entry.serialize());

            // reassigning the element for the next iteration
            if (element == null) {
                break;
            }

            entry = element;
        }
    }

    @Override
    public T getEntry(final int rank) {
        if (rank <= 0 || rank > size) {
            throw new IllegalArgumentException("Invalid rank: " + rank + " (1-" + size + ")");
        }
        return (T) this.positionEntry[rank - 1];
    }
}