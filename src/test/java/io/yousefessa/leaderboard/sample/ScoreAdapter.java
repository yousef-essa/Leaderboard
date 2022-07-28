package io.yousefessa.leaderboard.sample;

import io.yousefessa.leaderboard.entry.adapter.EntryAdapter;

public final class ScoreAdapter extends EntryAdapter<ScoreEntry> {
    @Override
    public ScoreEntry createEntry(final String serializedData) {
        return ScoreEntry.deserialize(serializedData);
    }

    @Override
    public ScoreEntry createEntry(final int rank, final String serializedData) {
        return ScoreEntry.deserialize(rank, serializedData);
    }
}
