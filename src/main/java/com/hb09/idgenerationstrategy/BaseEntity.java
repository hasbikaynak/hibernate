package com.hb09.idgenerationstrategy;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass //this will not be entity and will not have tables
public class BaseEntity{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence" , sequenceName = "student_seq", initialValue = 1000, allocationSize = 10)
    private Long id;

    private LocalDateTime createdOn = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }


}
