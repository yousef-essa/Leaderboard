package io.yousefessa.leaderboard;

import io.yousefessa.leaderboard.entry.LeaderboardEntry;
import io.yousefessa.leaderboard.entry.adapter.EntryAdapter;

import java.util.function.BiFunction;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LeaderboardHelper {
    public static <T extends LeaderboardEntry<T, ?>> Leaderboard<T> constructLeaderboard(final int size,
            final BiFunction<Integer, String, LeaderboardEntry<T, ?>> whenDeserialize) {
        return new DefaultLeaderboard<T>(size, constructEntryAdapter(whenDeserialize), SortBy.HIGHEST);
    }

    @SuppressWarnings("unchecked")
    public static <T extends LeaderboardEntry<T, ?>> EntryAdapter<T> constructEntryAdapter(
            final BiFunction<Integer, String, LeaderboardEntry<T, ?>> whenDeserialize) {
        final EntryAdapter<T> mockedAdapter = mock(EntryAdapter.class);
        when(mockedAdapter.createEntry(anyInt(), notNull())).thenAnswer(invocation -> {
            final int rank = invocation.getArgument(0);
            final String serializedData = invocation.getArgument(1);
            return whenDeserialize.apply(rank, serializedData);
        });
        return mockedAdapter;
    }
}