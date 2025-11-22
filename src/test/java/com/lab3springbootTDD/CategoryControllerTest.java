package com.lab3springbootTDD;

import com.lab3springbootTDD.Service.CategoryService;
import com.lab3springbootTDD.controller.CategoryController;
import com.lab3springbootTDD.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    CategoryService myTestCategoryService;

    @InjectMocks // Renombrado
    CategoryController myTestcategoryController;

    @BeforeEach
    public void setUp() {
        myTestcategoryController = new
                CategoryController(myTestCategoryService);
    }


    @Test
    void whenSayHello_shouldReturnStringHello() {
        String result = myTestcategoryController.sayHello();
        assertEquals("Hola", result);
    }

    @Test
    void whenGetAllCategories_shouldCallServiceAndReturnTheCorrectList() {
        try {
            ArrayList<Category> expected = this.getListOfCategories();
            doReturn(expected).when(myTestCategoryService).getAll();
            ArrayList<Category> result = myTestcategoryController.getAllCategories();
            verify(myTestCategoryService, times(1)).getAll();
            assertEquals(expected, result, "Las listas completas de categorías deben ser iguales.");
            Category firstExpected = expected.get(0);
            Category firstResult = result.get(0);

            assertEquals(firstExpected.getId(), firstResult.getId(), "El ID de la primera categoría debe coincidir.");
            assertEquals(firstExpected.getDescription(), firstResult.getDescription(), "La descripción debe coincidir.");

        } catch (RuntimeException e) {

            System.err.println("Excepción inesperada: " + e.getMessage());
            assertEquals(RuntimeException.class, e.getClass());
        }
    }

    private ArrayList<Category> getListOfCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Category category = new Category((long) i, "Category " + i, "Description " + i);
            categories.add(category);
        }
        return categories;
    }

}