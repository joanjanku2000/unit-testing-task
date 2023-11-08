package org.ikubinfo.testing.service;

import org.ikubinfo.testing.dto.CategoryDTO;

public interface CategoryService {
    void save(CategoryDTO categoryDTO);
    void update(CategoryDTO categoryDTO);
    CategoryDTO findById(Integer id);
    void delete(Integer id);
}
