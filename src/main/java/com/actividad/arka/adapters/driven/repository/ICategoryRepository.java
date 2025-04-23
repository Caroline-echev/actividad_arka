package com.actividad.arka.adapters.driven.repository;

import com.actividad.arka.adapters.driven.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
  }
