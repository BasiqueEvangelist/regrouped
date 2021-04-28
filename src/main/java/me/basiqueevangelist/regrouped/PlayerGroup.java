package me.basiqueevangelist.regrouped;

import java.util.List;
import java.util.UUID;

public interface PlayerGroup {
    /**
     * Returns an <b>unmodifiable</b> list of group members.
     */
    List<UUID> getMembers();

    boolean canChangeMembers();

    /**
     * Adds a player to the group.
     * @return Returns true if adding the player succeeded, false otherwise.
     */
    boolean addMember(UUID uuid);

    /**
     * Removes a player from the group.
     * @return Returns true if removing the player succeeded, false otherwise.
     */
    boolean removeMember(UUID uuid);

    String getName();


    GroupSource getSource();
}
