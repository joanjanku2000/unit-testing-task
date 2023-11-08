package org.ikubinfo.testing.dao;

import org.ikubinfo.testing.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}
