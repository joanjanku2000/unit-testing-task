package org.ikubinfo.testing.service.impl;

import lombok.RequiredArgsConstructor;
import org.ikubinfo.testing.converters.PostCategoryMapper;
import org.ikubinfo.testing.dao.PostCategoryDAO;
import org.ikubinfo.testing.dto.PostCategoryDTO;
import org.ikubinfo.testing.service.PostCategoryService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {
    private final PostCategoryDAO postCategoryDAO;
    private static final PostCategoryMapper POST_CATEGORY_MAPPER = Mappers.getMapper(PostCategoryMapper.class);

    public PostCategoryServiceImpl(PostCategoryDAO postCategoryDAO) {
        this.postCategoryDAO = postCategoryDAO;
    }

    @Override
    public void save(PostCategoryDTO postCategoryDTO) {
        postCategoryDAO.save(POST_CATEGORY_MAPPER.postCategoryDTOToPostCategory(postCategoryDTO));
    }

    @Override
    public void update(PostCategoryDTO postCategoryDTO) {
        postCategoryDAO.save(POST_CATEGORY_MAPPER.postCategoryDTOToPostCategory(postCategoryDTO,postCategoryDAO.findById(postCategoryDTO.getId()).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public PostCategoryDTO findById(Integer id) {
        return POST_CATEGORY_MAPPER.postCategoryToPostCategoryDTO(postCategoryDAO.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        postCategoryDAO.deleteById(id);
    }
}
