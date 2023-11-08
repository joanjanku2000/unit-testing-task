package org.ikubinfo.testing.converters;

import org.ikubinfo.testing.dto.CategoryDTO;
import org.ikubinfo.testing.dto.PostCategoryDTO;
import org.ikubinfo.testing.dto.PostDTO;
import org.ikubinfo.testing.entities.Category;
import org.ikubinfo.testing.entities.Post;
import org.ikubinfo.testing.entities.PostCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostCategoryMapper {
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);
    PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);
    @Mapping(source = "category",target = "categoryDTO",qualifiedByName = "toCategoryDto")
    @Mapping(source = "post",target = "postDTO",qualifiedByName = "toPostDto")
    PostCategoryDTO postCategoryToPostCategoryDTO(PostCategory postCategory);
    @Mapping(source = "categoryDTO",target = "category",qualifiedByName = "toCategoryEntity")
    @Mapping(source = "postDTO",target = "post",qualifiedByName = "toPostEntity")
    PostCategory postCategoryDTOToPostCategory(PostCategoryDTO postCategoryDTO);

    @Named("toCategoryDto")
    default CategoryDTO toCategoryDTO(Category category){
       return CATEGORY_MAPPER.categoryToCategoryDTO(category);
    }
    @Named("toCategoryEntity")
    default Category toCategoryEntity(CategoryDTO category){
        return CATEGORY_MAPPER.categoryDTOToCategory(category);
    }
    @Named("toPostDto")
    default PostDTO toPostDTO(Post post){
        return POST_MAPPER.postToPostDTO(post);
    }
    @Named("toPostEntity")
    default Post toPostEntity(PostDTO post){
        return POST_MAPPER.postDTOToPost(post);
    }
}
