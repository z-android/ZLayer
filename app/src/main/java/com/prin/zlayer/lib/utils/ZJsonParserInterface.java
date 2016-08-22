package com.prin.zlayer.lib.utils;

import java.util.Map;

/**
 * Created by prin on 2016/8/22.
 */
public interface ZJsonParserInterface {
    <T> T jsonToModel(String json, Class<T> model);

    Map<String, Object> jsonToMap(String json);

    String objToJson(Object object);
}
