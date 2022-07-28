package io.yousefessa.leaderboard.sample;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;
import org.jetbrains.annotations.NotNull;

public class ScoreEntry extends LeaderboardEntry<Integer> {
    public static ScoreEntry of(final int rank, final Integer score) {
        return new ScoreEntry(rank, score);
    }

    public static ScoreEntry of(final Integer score) {
        return new ScoreEntry(-1, score);
    }

    public static ScoreEntry deserialize(final String serializedData) {
        final String[] args = serializedData.split(";");
        final int rank = Integer.parseInt(args[0]);
        return deserialize(rank, serializedData);
    }

    public static ScoreEntry deserialize(final int rank, final String serializedData) {
        final String[] args = serializedData.split(";");
        final int score = Integer.parseInt(args[1]);
        return new ScoreEntry(rank, score);
    }

    private ScoreEntry(final int rank, final Integer score) {
        super(rank, score);
    }

    @Override
    public int compareTo(@NotNull final LeaderboardEntry<Integer> o) {
        return this.getData()
                .compareTo(o.getData());
    }

    @Override
    public String serialize() {
        return super.getRank() + ";" + super.getData();
    }
}
