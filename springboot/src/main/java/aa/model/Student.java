package aa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    @Setter
    @Getter
    private Long id;

    @Column(nullable = true)
    @Setter
    @Getter
    private String name;

    @Column(nullable = true)
    @Setter
    @Getter
    private String password;

    @Column(nullable = true)
    @Setter
    @Getter
    private Integer age;


}
