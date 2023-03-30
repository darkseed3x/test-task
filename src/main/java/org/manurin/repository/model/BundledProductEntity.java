package org.manurin.repository.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
@Table(name = "BUNDLED_PRODUCTS")
public class BundledProductEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "bundled_product_id", unique = true)
    String id;


    @Column(columnDefinition = "varchar(128) not null")
    String name;
    @Column(columnDefinition = "timestamp not null")
    OffsetDateTime createDate = OffsetDateTime.now();


    Integer calls;
    Integer sms;
    Integer internet;
    @Column(columnDefinition = "boolean not null")
    boolean deleted = false;

}