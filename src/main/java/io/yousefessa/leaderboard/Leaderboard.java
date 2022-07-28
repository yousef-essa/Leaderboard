package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;
import io.yousefessa.leaderboard.entry.adapter.EntryAdapter;

public final class Leaderboard<T extends LeaderboardEntry<?>> {
    private final int size;
    private final LeaderboardEntry<?>[] positionEntry;
    private final EntryAdapter<T> adapter;

    public Leaderboard(final int size, final EntryAdapter<T> adapter) {
        this.size = size;
        this.adapter = adapter;
        this.positionEntry = new LeaderboardEntry[size];
    }

    public void addEntry(T entry) {
        int rank = 0;
        for (int i = 0; i < size; i++) {
            rank++;

            final LeaderboardEntry element = positionEntry[i];

            // if the element is null or lesser then, go to the next iteration
            if (element != null && element.compareTo(entry) <= 0) {
                continue;
            }

            this.positionEntry[i] = adapter.createInstance(rank, entry.serialize());

            // reassigning the element for the next iteration
            if (element == null) {
                break;
            }

            entry = (T) element;
        }
    }

    public T getEntry(final int rank) {
        if (rank <= 0 || rank > size) {
            throw new IllegalArgumentException("Invalid rank: " + rank + " (1-" + size + ")");
        }
        return (T) this.positionEntry[rank - 1];
    }
}