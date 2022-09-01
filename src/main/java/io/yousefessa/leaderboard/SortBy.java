package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;

public enum SortBy {
    HIGHEST {
        @Override
        public <T> int compareTo(final LeaderboardEntry<T, ?> by, final LeaderboardEntry<T, ?> against) {
            return by.compareTo(against);
        }
    },
    LOWEST {
        @Override
        public <T> int compareTo(final LeaderboardEntry<T, ?> by, final LeaderboardEntry<T, ?> against) {
            return against.compareTo(by);
        }
    };

    public abstract <T> int compareTo(final LeaderboardEntry<T, ?> by, final LeaderboardEntry<T, ?> against);
}
