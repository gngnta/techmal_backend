package backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.controller.mapper.CategoryResponseMapper;
import backend.controller.response.CategoryResponse;
import backend.domain.Category;
import backend.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryResponseMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryResponseMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryResponse> responses = categoryMapper.toResponses(categories);
        return responses;
    }
}
