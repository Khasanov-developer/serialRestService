package presentation.rest;

import com.google.gson.Gson;
import spark.ResponseTransformer;

class JsonUtil {

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}