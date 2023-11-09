package org.ikubinfo.testing.api;

import org.ikubinfo.testing.dto.PostCategoryDTO;
import org.ikubinfo.testing.service.PostCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post-category")
public class PostCategoryController {

    private final PostCategoryService userService;

    public PostCategoryController(PostCategoryService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void save(@RequestBody PostCategoryDTO userDTO) {
        userService.save(userDTO);
    }

    @PutMapping
    public void update(@RequestBody PostCategoryDTO userDTO) {
        userService.update(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCategoryDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}
