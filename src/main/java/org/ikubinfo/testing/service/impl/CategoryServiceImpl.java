package org.ikubinfo.testing.service.impl;

import org.ikubinfo.testing.converters.CategoryMapper;
import org.ikubinfo.testing.dao.CategoryDAO;
import org.ikubinfo.testing.dto.CategoryDTO;
import org.ikubinfo.testing.service.CategoryService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);
    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void save(CategoryDTO categoryDTO) {
        categoryDAO.save(CATEGORY_MAPPER.categoryDTOToCategory(categoryDTO));
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        categoryDAO.save(CATEGORY_MAPPER.categoryDTOToCategory(categoryDTO, categoryDAO.findById(categoryDTO.getId()).orElseThrow(() -> new RuntimeException())));
    }

    @Override
    public CategoryDTO findById(Integer id) {
        return CATEGORY_MAPPER.categoryToCategoryDTO(categoryDAO.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public void delete(Integer id) {
        categoryDAO.deleteById(id);
    }
}
