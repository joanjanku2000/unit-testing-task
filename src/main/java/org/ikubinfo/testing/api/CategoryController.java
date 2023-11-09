package org.ikubinfo.testing.api;

import org.ikubinfo.testing.dto.CategoryDTO;
import org.ikubinfo.testing.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void save(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(categoryDTO);
    }

    @PutMapping
    public void update(@RequestBody CategoryDTO categoryDTO) {
        categoryService.update(categoryDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        categoryService.delete(id);
    }
}
