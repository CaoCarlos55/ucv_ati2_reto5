package com.lab3springbootTDD.Service;

import com.lab3springbootTDD.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {

    public ArrayList<Category> getAll() {

        return generateCategoriesList(3);
    }

    private ArrayList<Category> generateCategoriesList(int wantedSize) {
        ArrayList<Category> categories = new ArrayList<>();

        for (int i = 1; i <= wantedSize; i ++){
            Category category = new Category((long) i, "Category " + i, "Description " + i);
            categories.add(category);
        }
        return categories;
    }
}