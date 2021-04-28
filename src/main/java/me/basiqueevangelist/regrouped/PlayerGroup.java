package me.basiqueevangelist.regrouped;

import java.util.List;
import java.util.UUID;

public interface PlayerGroup {
    /**
     * Returns an <b>unmodifiable</b> list of group members.
     */
    List<UUID> getMembers();

    boolean canChangeMembers();

    void addMember(UUID uuid);

    void removeMember(UUID uuid);

    String getName();


    GroupSource getSource();
}
