package org.ikubinfo.testing.service;

import org.ikubinfo.testing.dto.PostDTO;
import org.ikubinfo.testing.dto.UserDTO;

public interface UserService {
    void save(UserDTO userDTO);
    void update(UserDTO userDTO);
    UserDTO findById(Integer id);
    void delete(Integer id);

}
