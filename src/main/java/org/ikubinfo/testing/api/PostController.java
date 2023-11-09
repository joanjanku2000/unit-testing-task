package org.ikubinfo.testing.api;

import org.ikubinfo.testing.dto.PostDTO;
import org.ikubinfo.testing.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService userService;

    public PostController(PostService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void save(@RequestBody PostDTO userDTO) {
        userService.save(userDTO);
    }

    @PutMapping
    public void update(@RequestBody PostDTO userDTO) {
        userService.update(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}
