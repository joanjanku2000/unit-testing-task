package org.ikubinfo.testing.dao;

import org.ikubinfo.testing.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDAO extends JpaRepository<Post,Integer> {
}
