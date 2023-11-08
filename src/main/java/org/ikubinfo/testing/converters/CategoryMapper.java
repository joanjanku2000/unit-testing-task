package org.ikubinfo.testing.converters;

import org.ikubinfo.testing.dto.CategoryDTO;
import org.ikubinfo.testing.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper
public interface CategoryMapper {
    CategoryDTO categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDTO categoryDTO);
    Category categoryDTOToCategory(CategoryDTO categoryDTO, @MappingTarget  Category category);


}
