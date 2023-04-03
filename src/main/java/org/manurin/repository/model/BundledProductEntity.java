package org.manurin.repository.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
@Table(name = "BUNDLED_PRODUCTS")

public class BundledProductEntity extends PanacheEntity {


    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "bundled_product_id", unique = true)
    private String id;


    @Column(columnDefinition = "varchar(128) not null")
    private String name;
    @Column(columnDefinition = "timestamp not null")
    private OffsetDateTime createDate = OffsetDateTime.now();


    private Integer calls;
    private Integer sms;
    private Integer internet;
    @Column(columnDefinition = "boolean not null")
    private boolean deleted = false;

    public BundledProductEntity setId(String id) {
        this.id = id;
        return this;
    }

    public BundledProductEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BundledProductEntity setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public BundledProductEntity setCalls(Integer calls) {
        this.calls = calls;
        return this;
    }

    public BundledProductEntity setSms(Integer sms) {
        this.sms = sms;
        return this;
    }

    public BundledProductEntity setInternet(Integer internet) {
        this.internet = internet;
        return this;
    }

    public BundledProductEntity setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public Integer getCalls() {
        return calls;
    }

    public Integer getSms() {
        return sms;
    }

    public Integer getInternet() {
        return internet;
    }

    public boolean isDeleted() {
        return deleted;
    }
}