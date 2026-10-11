package live.switchly.api.controller;

import live.switchly.api.model.Flag;
import live.switchly.api.service.FlagService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "flags")
public class FlagController {

    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Flag create(@RequestParam UUID projectId, @RequestBody CreateFlagDto createFlagDto) {
        return flagService.create(
                projectId,
                createFlagDto.getName(),
                createFlagDto.getDescription(),
                createFlagDto.isActive()
        );
    }

    @GetMapping(produces = "application/json")
    public List<Flag> findAll() {
        return flagService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Flag getById(@PathVariable UUID id) {
        return flagService.getById(id);
    }

    // DTO class for receiving request body data safely
    public static class CreateFlagDto {
        private String name;
        private String description;
        private boolean active;

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
}