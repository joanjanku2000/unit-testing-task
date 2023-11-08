package org.ikubinfo.testing.converters;

import org.ikubinfo.testing.dto.UserDTO;
import org.ikubinfo.testing.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface UserMapper {

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
