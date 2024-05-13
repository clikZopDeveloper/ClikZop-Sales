package com.clikzop.sales_custom.ApiHelper;

import com.google.gson.JsonElement;

public interface ApiResponseListner {

    public void success(String tag, JsonElement jsonElement);
    public void failure(String tag, String errorMessage);
}
