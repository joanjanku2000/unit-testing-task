package org.ikubinfo.testing;

import org.ikubinfo.testing.dao.CategoryDAO;
import org.ikubinfo.testing.dto.CategoryDTO;
import org.ikubinfo.testing.entities.Category;
import org.ikubinfo.testing.service.CategoryService;
import org.ikubinfo.testing.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryDAO categoryDAO;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void saveTest() {
        Mockito.when(categoryDAO.save(Mockito.any())).thenReturn(new Category());
        categoryService.save(new CategoryDTO());
    }


}
