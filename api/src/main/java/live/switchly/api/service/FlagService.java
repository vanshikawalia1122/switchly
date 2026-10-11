package live.switchly.api.service;

import live.switchly.api.exception.NotFoundException;
import live.switchly.api.model.Flag;
import live.switchly.api.model.Project;
import live.switchly.api.repository.FlagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlagService {
    private final ProjectService projectService;
    private final FlagRepository flagRepository;

    public FlagService(ProjectService projectService, FlagRepository flagRepository) {
        this.projectService = projectService;
        this.flagRepository = flagRepository;
    }

    public Flag create(UUID projectId, String name, String description, boolean active) {
        Project project = projectService.getById(projectId); // Ensures 404 if project doesn't exist
        Flag flag = new Flag(UUID.randomUUID(), project.getId(), name, description, active);
        return flagRepository.save(flag);
    }

    public List<Flag> findAll() {
        return flagRepository.findAll();
    }

    public Flag getById(UUID id) {
        return flagRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Flag " + id + " not found"));
    }
}