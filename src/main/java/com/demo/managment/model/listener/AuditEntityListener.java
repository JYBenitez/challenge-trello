package com.demo.managment.model.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditEntityListener {

    @PrePersist
    public void prePersistAuditable(Object auditable){
        ((AuditEntity)auditable).setCreationDate(LocalDateTime.now());
        ((AuditEntity)auditable).setUser("user-admin");
    }

    @PreUpdate
    public void preUpdateAuditable(Object auditable){
        ((AuditEntity)auditable).setModificationDate(LocalDateTime.now());
        ((AuditEntity)auditable).setUser("user-admin");
    }
}
