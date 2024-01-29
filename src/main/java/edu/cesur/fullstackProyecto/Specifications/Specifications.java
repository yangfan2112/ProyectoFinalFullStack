package edu.cesur.fullstackProyecto.Specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

public class Specifications {

    public static <T> Specification<T> filtrar(Map<String, String> filtros) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (Map.Entry<String, String> entry : filtros.entrySet()) {
                String campo = entry.getKey();
                String valor = entry.getValue();
                switch (campo) {
                    case "nombre":
                        predicates.add(criteriaBuilder.equal(root.get("nombre"), valor));
                        break;
                    case "apellidos":
                        predicates.add(criteriaBuilder.equal(root.get("apellidos"), valor));
                        break;
                    case "documentacion":
                        predicates.add(criteriaBuilder.equal(root.get("documentacion"), valor));
                        break;
                    case "email":
                        predicates.add(criteriaBuilder.equal(root.get("email"), valor));
                        break;
                    case "tlf":
                        predicates.add(criteriaBuilder.equal(root.get("tlf"), valor));
                        break;
                    case "idioma":
                        predicates.add(criteriaBuilder.equal(root.get("idioma"), valor));
                        break;
                    case "nacionalidad":
                        predicates.add(criteriaBuilder.equal(root.get("nacionalidad"), valor));
                        break;
                    case "fechares":
                        predicates.add(criteriaBuilder.equal(root.get("fechares"), valor));
                        break;
                    case "fechaini":
                        predicates.add(criteriaBuilder.equal(root.get("fechaini"), valor));
                        break;
                    case "evento":
                    	predicates.add(criteriaBuilder.equal(root.get("evento").get("id"), Long.parseLong(valor)));
                        break;
                    case "usuario":
                    	predicates.add(criteriaBuilder.equal(root.get("usuario").get("id"), Long.parseLong(valor)));
                        break;
                    case "hotel":
                    	predicates.add(criteriaBuilder.equal(root.get("hotel").get("id"), Long.parseLong(valor)));
                        break;
                    case "restaurante":
                    	predicates.add(criteriaBuilder.equal(root.get("restaurante").get("id"), Long.parseLong(valor)));
                        break;
                    case "empresa":
                        predicates.add(criteriaBuilder.equal(root.get("empresa"), valor));
                        break;
                    case "pais":
                        predicates.add(criteriaBuilder.equal(root.get("pais"), valor));
                        break;
                    case "servicios":
                        predicates.add(criteriaBuilder.equal(root.get("servicios"), valor));
                        break;
                    case "tipoHab":
                        predicates.add(criteriaBuilder.equal(root.get("tipoHab"), valor));
                        break;
                    case "tipoCocina":
                    	predicates.add(criteriaBuilder.equal(root.get("tipoCocina"), valor));
                        break;
                    case "horarioApertura":
                    	predicates.add(criteriaBuilder.equal(root.get("horarioApertura"), valor));
                        break;
                    case "horarioCierre":
                    	predicates.add(criteriaBuilder.equal(root.get("horarioCierre"), valor));
                        break;
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
