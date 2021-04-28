package me.basiqueevangelist.regrouped;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.function.Consumer;

public interface GroupSource {
    @Nullable PlayerGroup findGroupByName(String name);

    void visitAllGroups(Consumer<PlayerGroup> visitor);

    void visitGroupsOf(UUID playerId, Consumer<PlayerGroup> visitor);
}
