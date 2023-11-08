package org.ikubinfo.testing.service.impl;

import lombok.RequiredArgsConstructor;
import org.ikubinfo.testing.converters.UserMapper;
import org.ikubinfo.testing.dao.UserDAO;
import org.ikubinfo.testing.dto.UserDTO;
import org.ikubinfo.testing.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(UserDTO userDTO) {
        userDAO.save(USER_MAPPER.userDTOToUser(userDTO));
    }

    @Override
    public void update(UserDTO userDTO) {
        userDAO.save(USER_MAPPER.userDTOToUser(userDTO, userDAO.findById(userDTO.getId()).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public UserDTO findById(Integer id) {
        return USER_MAPPER.userToUserDTO(userDAO.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        userDAO.deleteById(id);
    }
}
