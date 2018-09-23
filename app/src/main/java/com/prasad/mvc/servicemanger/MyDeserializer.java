//package com.prasad.mvc.servicemanger;
//
//import android.renderscript.Type;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonDeserializationContext;
//import com.google.gson.JsonDeserializer;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParseException;
//
///**
// * Created by prasad on 9/22/18.
// */
//
//class MyDeserializer implements JsonDeserializer<Object> {
//    Class cls;
//
//    public MyDeserializer(Class cls) {
//        this.cls = cls;
//    }
//
//    @Override
//    public Object deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        // Get the "content" element from the parsed JSON
////        JsonElement content = json.getAsJsonObject().get("content");
//
//        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
//        // to this deserializer
//        return new Gson().fromJson(json, cls);
//
//    }
//}
//
//
