package live.switchly.api.model;

import java.util.UUID;

public class Flag {
    private final UUID id;
    private final UUID projectId;
    private final String name;
    private final String description;
    private final boolean active;

    public Flag(UUID id, UUID projectId, String name, String description, boolean active) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }
}