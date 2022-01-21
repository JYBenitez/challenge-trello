package com.demo.managment.model.listener;

import java.time.LocalDateTime;

public interface AuditEntity {
    void setCreationDate(LocalDateTime date);
    void setModificationDate(LocalDateTime date);
    void setUser(String user);
}
