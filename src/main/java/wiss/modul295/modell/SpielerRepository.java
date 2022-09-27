package wiss.modul295.modell;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface SpielerRepository extends CrudRepository<Spieler, Integer> {
    }


