package org.ikubinfo.testing.service.impl;

import org.ikubinfo.testing.converters.PostMapper;
import org.ikubinfo.testing.dao.PostDAO;
import org.ikubinfo.testing.dto.PostDTO;
import org.ikubinfo.testing.service.PostService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private static final PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);
    private final PostDAO postDAO;

    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public void save(PostDTO postDTO) {
        postDAO.save(POST_MAPPER.postDTOToPost(postDTO));
    }

    @Override
    public void update(PostDTO postDTO) {
        postDAO.save(POST_MAPPER.postDTOToPost(postDTO, postDAO.findById(postDTO.getId()).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public PostDTO findById(Integer id) {
        return POST_MAPPER.postToPostDTO(postDAO.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        postDAO.deleteById(id);
    }
}
