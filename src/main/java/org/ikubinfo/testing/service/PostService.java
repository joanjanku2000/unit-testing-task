package org.ikubinfo.testing.service;

import org.ikubinfo.testing.dto.PostCategoryDTO;
import org.ikubinfo.testing.dto.PostDTO;

public interface PostService {
    void save(PostDTO postDTO);
    void update(PostDTO postDTO);
    PostDTO findById(Integer id);
    void delete(Integer id);
}
