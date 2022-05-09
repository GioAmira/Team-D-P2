package com.revature.GroupDP2.Irepository;

import com.google.gson.JsonObject;
import org.json.JSONObject;

public interface ICategoryRepository extends IGenericRepository{

    JSONObject getByCategoryName (JSONObject jsonObject);
    JsonObject getByCategoryName (JsonObject jsonObject);
}
