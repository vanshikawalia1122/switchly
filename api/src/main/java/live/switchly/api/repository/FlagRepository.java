package live.switchly.api.repository;

import live.switchly.api.model.Flag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FlagRepository {
    private final List<Flag> flags = new ArrayList<>();

    public List<Flag> findAll() {
        return flags;
    }

    public Optional<Flag> findById(UUID id) {
        return flags.stream()
                .filter(flag -> flag.getId().equals(id))
                .findFirst();
    }

    public Flag save(Flag flag) {
        flags.add(flag);
        return flag;
    }
}