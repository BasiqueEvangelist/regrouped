package me.basiqueevangelist.regrouped;

import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public final class Regrouped {
    private Regrouped() {

    }

    private static final List<GroupSource> sources = new ArrayList<>();

    public static void registerSource(GroupSource source) {
        sources.add(source);
    }

    public static @Nullable PlayerGroup findGroupsByName(String name) {
        for (GroupSource source : sources) {
            PlayerGroup group = source.findGroupByName(name);
            if (group != null)
                return group;
        }

        return null;
    }

    public static List<PlayerGroup> getAllGroups(Consumer<PlayerGroup> visitor) {
        List<PlayerGroup> groups = new ArrayList<>();
        for (GroupSource source : sources) {
            source.visitAllGroups(groups::add);
        }
        return groups;
    }

    public static List<PlayerGroup> getGroupsOf(ServerPlayerEntity onlinePlayer) {
        return getGroupsOf(onlinePlayer.getUuid());
    }

    public static List<PlayerGroup> getGroupsOf(UUID player) {
        List<PlayerGroup> groups = new ArrayList<>();
        for (GroupSource source : sources) {
            source.visitGroupsOf(player, groups::add);
        }
        return groups;
    }
}
