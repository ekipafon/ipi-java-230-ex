package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Commercial;
import com.ipiecoles.java.java230.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercialRepository extends JpaRepository<Commercial, Long> {
}
