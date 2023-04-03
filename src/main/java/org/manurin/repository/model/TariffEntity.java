package org.manurin.repository.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Entity
@Table(name = "TARIFFS")
public class TariffEntity extends PanacheEntity {


    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "tariff_id", unique = true)
    private String id;

    @Column(columnDefinition = "varchar(128) not null")
    private String name;
    @Column(columnDefinition = "timestamp not null")
    private OffsetDateTime createDate = OffsetDateTime.now();



    @OneToOne
    @JoinColumn(name = "bundled_product_id")
    private BundledProductEntity bundledProductId;


    @Column(columnDefinition = "boolean not null")
    private boolean deleted = false;
    @Column(columnDefinition = "boolean not null")
    private boolean archived = false;

    public TariffEntity setId(String id) {
        this.id = id;
        return this;
    }

    public TariffEntity setName(String name) {
        this.name = name;
        return this;
    }

    public TariffEntity setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public TariffEntity setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }



    public TariffEntity setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }
    public TariffEntity setBundledProductId(BundledProductEntity bundledProductId) {
        this.bundledProductId = bundledProductId;
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


    public boolean isDeleted() {
        return deleted;
    }



    public boolean isArchived() {
        return archived;
    }


    public BundledProductEntity getBundledProductId() {
        return bundledProductId;
    }
}