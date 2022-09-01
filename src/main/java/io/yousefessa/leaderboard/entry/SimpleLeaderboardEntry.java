package io.yousefessa.leaderboard.entry;

import org.jetbrains.annotations.NotNull;

public class SimpleLeaderboardEntry<O extends Comparable<O>> extends LeaderboardEntry<SimpleLeaderboardEntry<?>, O> {
    public SimpleLeaderboardEntry(final int rank, final O data) {
        super(rank, data);
    }

    public static <O extends Comparable<O>> SimpleLeaderboardEntry<O> deserialize(final String serializedData) {
        final String[] args = serializedData.split(";");
        final int rank = Integer.parseInt(args[0]);
        return deserialize(rank, serializedData);
    }

    public static <O extends Comparable<O>> SimpleLeaderboardEntry<O> deserialize(final int rank, final String serializedData) {
        final String[] args = serializedData.split(";");
        final O data = (O) args[1];

        return new SimpleLeaderboardEntry<>(rank, data);
    }

    @Override
    public int compareTo(@NotNull final LeaderboardEntry<SimpleLeaderboardEntry<?>, ?> o) {
        return this.getData().compareTo((O) o.getData());
    }

    @Override
    public String serialize() {
        return this.getRank() + ";" + this.getData();
    }
}
