package com.ecommerce.project.controller;

import com.ecommerce.project.model.ApiResponse;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CategoryController {
    // @Autowired => we can also do field injection
    private CategoryService categoryService;
     //constructor Injection
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
//    @GetMapping("/api/public/categories")
//    public ResponseEntity<ApiResponse> getAllCategories() {
        public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setCode(200);
//        apiResponse.setStatus(true);
//        apiResponse.setData(categories);
//        System.err.println("Error : -> " + apiResponse.toString());
//        log.error(apiResponse.toString());
//        log.warn(apiResponse.toString());
//        return ResponseEntity.ok(apiResponse);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

//    @PostMapping("/api/public/categories")

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody @Valid Category category){
        categoryService.CreateCategory(category);
        return new ResponseEntity<>("Category added successfully", HttpStatus.OK);
    }
//    @DeleteMapping("/api/admin/categories/{categoryId}")
    @DeleteMapping("/admin/categories/{categoryId}")
      public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
       try{
           String status = categoryService.deleteCategory(categoryId);
           return new ResponseEntity<>(status , HttpStatus.OK);
//           return ResponseEntity.ok(status);
//           return ResponseEntity.status(HttpStatus.OK).body(status);
       }catch (ResponseStatusException e){
           return new ResponseEntity<>(e.getReason() , e.getStatusCode());
       }
      }

//      @PutMapping("/api/admin/categories/{categoryId}")
      @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable Long categoryId){
        try{
            Category savedCategory = categoryService.UpdateCategoryById(category, categoryId);
            return new ResponseEntity<>("Category with categoryId " + categoryId + " updated.", HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode());
        }
      }
}
