package org.ikubinfo.testing.dao;

import org.ikubinfo.testing.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
