package com.revature.GroupDP2.Irepository;

import com.google.gson.JsonObject;
import org.json.JSONObject;

public interface ICategoryRepository<Category> extends IGenericRepository<Category>{

    Category getByCategoryName (Category category);
}
