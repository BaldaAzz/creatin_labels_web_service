package nastya.proj.NastyaProj.controllers;

import lombok.RequiredArgsConstructor;
import nastya.proj.NastyaProj.models.Category;
import nastya.proj.NastyaProj.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public String showCategoryList(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "categories";
    }
}
