/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution2.util;

import com.ruben.solution2.model.BaseModel;
import com.google.gson.Gson;

/**
 *
 * @author home
 */
public class Paser {

    public static < T extends BaseModel> T parserObject(Class<T> obj, String jsonString) throws Exception {
        T a = obj.newInstance();
        Gson g = new Gson();
        a = g.fromJson(jsonString, obj);
        return a;
    }

    public static < T extends BaseModel> String parserJsonString(Class<T> obj, T objInstance) throws Exception {
        Gson g = new Gson();
        return g.toJson(objInstance);
    }
}
