package org.ikubinfo.testing.service;

import org.ikubinfo.testing.dto.PostCategoryDTO;

public interface PostCategoryService {
    void save(PostCategoryDTO postCategoryDTO);
    void update(PostCategoryDTO postCategoryDTO);
    PostCategoryDTO findById(Integer id);
    void delete(Integer id);
}
