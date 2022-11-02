package test;

import com.blazebit.persistence.CriteriaBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/test")
@Transactional
public class TestComponent {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CriteriaBuilderFactory criteriaBuilderFactory;

    @GetMapping
    public List<Cat> get(@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
        return criteriaBuilderFactory
                .create(entityManager, Cat.class)
                .from(Cat.class)
                .where("age").eq(1)
                .orderByDesc("insertTs")
                .setMaxResults(2)
//                .union()
//                .from(Cat.class)
//                .where("age").eq(2)
//                .orderByDesc("insertTs")
//                .setMaxResults(2)
//                .endSet()
                .orderByDesc(orderBy)
                .getResultList();
    }

}
