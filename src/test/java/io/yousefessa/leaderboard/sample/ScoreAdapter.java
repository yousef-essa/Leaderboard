package io.yousefessa.leaderboard.sample;

import io.yousefessa.leaderboard.entry.adapter.EntryAdapter;

public final class ScoreAdapter extends EntryAdapter<ScoreEntry> {
    @Override
    public ScoreEntry createInstance(final String serializedData) {
        return ScoreEntry.deserialize(serializedData);
    }

    @Override
    public ScoreEntry createInstance(final int rank, final String serializedData) {
        return ScoreEntry.deserialize(rank, serializedData);
    }
}
