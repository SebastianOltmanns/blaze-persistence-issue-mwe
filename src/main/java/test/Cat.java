package test;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
@Data
public class Cat {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "insert_ts")
    @CreationTimestamp
    private Instant insertTs;

    @Column(name = "age")
    private Integer age;

    @Column(name = "name")
    private String name;

}
