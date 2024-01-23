package edu.cesur.fullstackProyecto.repositories;

import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public interface GlobalRepository<T> {

    List<T> findAll(Specification<T> specification);
}
