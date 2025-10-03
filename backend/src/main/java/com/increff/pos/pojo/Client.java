package com.increff.pos.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/*TODO:
snake case column, table names, use lombok, unique constraint class level,wrapper classes only
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"clientName"}))
@Getter
@Setter
public class Client extends BaseEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column(nullable = false)
    private String clientName;
}
