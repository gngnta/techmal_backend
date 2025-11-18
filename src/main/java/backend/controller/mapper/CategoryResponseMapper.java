package backend.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import backend.controller.response.CategoryResponse;
import backend.domain.Category;

@Mapper(componentModel = "spring")
public interface CategoryResponseMapper {
    CategoryResponse toResponse(Category category);

    List<CategoryResponse> toResponses(List<Category> categories);
}
