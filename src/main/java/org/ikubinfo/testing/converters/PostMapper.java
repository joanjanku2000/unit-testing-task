package org.ikubinfo.testing.converters;

import org.ikubinfo.testing.dto.PostDTO;
import org.ikubinfo.testing.dto.UserDTO;
import org.ikubinfo.testing.entities.Post;
import org.ikubinfo.testing.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "user",target = "userDTO",qualifiedByName = "toUserDTO")
    PostDTO postToPostDTO(Post post);

    @Mapping(source = "userDTO",target = "user",qualifiedByName = "toUserEntity")
    Post postDTOToPost(PostDTO postDTO);

    @Named("toUserDTO")
    default UserDTO toDTO(User user) {
        return USER_MAPPER.userToUserDTO(user);
    }

    @Named("toUserEntity")
    default User toEntity(UserDTO userDTO) {
        return USER_MAPPER.userDTOToUser(userDTO);
    }
}
