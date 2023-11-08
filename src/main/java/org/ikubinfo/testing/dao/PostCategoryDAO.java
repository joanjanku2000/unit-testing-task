package org.ikubinfo.testing.dao;

import org.ikubinfo.testing.entities.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCategoryDAO extends JpaRepository<PostCategory, Integer> {
}
