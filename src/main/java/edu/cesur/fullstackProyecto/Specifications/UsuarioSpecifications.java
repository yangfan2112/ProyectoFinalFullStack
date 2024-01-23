package edu.cesur.fullstackProyecto.Specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import edu.cesur.fullstackProyecto.entities.Usuario;
import jakarta.persistence.criteria.Predicate;

public class UsuarioSpecifications {

    public static Specification<Usuario> conFiltros(Map<String, String> filtros) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (Map.Entry<String, String> entry : filtros.entrySet()) {
                String campo = entry.getKey();
                String valor = entry.getValue();

                switch (campo) {
                    case "nombre":
                        predicates.add(criteriaBuilder.like(root.get("nombre"), "%" + valor + "%"));
                        break;
                    case "apellidos":
                        predicates.add(criteriaBuilder.like(root.get("apellidos"), "%" + valor + "%"));
                        break;
                    case "documentacion":
                        predicates.add(criteriaBuilder.like(root.get("documentacion"), "%" + valor + "%"));
                        break;
                    case "email":
                        predicates.add(criteriaBuilder.like(root.get("email"), "%" + valor + "%"));
                        break;
                    case "tlf":
                        predicates.add(criteriaBuilder.like(root.get("tlf"), "%" + valor + "%"));
                        break;
                    case "idioma":
                        predicates.add(criteriaBuilder.equal(root.get("idioma"), "%" + valor + "%"));
                        break;
                    case "nacionalidad":
                        predicates.add(criteriaBuilder.like(root.get("nacionalidad"), "%" + valor + "%"));
                        break;
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
