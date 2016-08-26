package prin.com.zlayer.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ZGsonParserImpl implements ZJsonParserInterface {

	private static Gson mGson = new Gson();

	@Override
	public <T> T jsonToModel(String json, Class<T> clazz) {
		try {
			T obj = mGson.fromJson(json, clazz);
			return obj;
		} catch (JsonSyntaxException e) {
			ZLogUtil.e(this.getClass(), e.getMessage());
		}
		return null;
	}

	@Override
	public Map<String, Object> jsonToMap(String json) {
		return toMap(json);
	}

	@Override
	public String objToJson(Object obj) {
		try {
			return mGson.toJson(obj);
		} catch (Exception e) {
			ZLogUtil.e(ZGsonParserImpl.class, e.getMessage());
		}

		return null;
	}

	public static JsonObject parseJson(String json) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = parser.parse(json).getAsJsonObject();
		return jsonObj;
	}

	public static Map<String, Object> toMap(String json) {
		return toMap(parseJson(json));
	}

	public static Map<String, Object> toMap(JsonObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<Entry<String, JsonElement>> entrySet = json.entrySet();
		for (Iterator<Entry<String, JsonElement>> iter = entrySet.iterator(); iter
				.hasNext();) {
			Entry<String, JsonElement> entry = iter.next();
			String key = entry.getKey();
			JsonElement value = entry.getValue();
			if (value.isJsonArray())
				map.put((String) key, toList((JsonArray) value));
			else if (value.isJsonObject())
				map.put((String) key, toMap((JsonObject) value));
			else if (value.isJsonNull()) {
				// noting to do
			} else
				map.put((String) key,
						handlePrimitive(value.getAsJsonPrimitive()));
		}
		return map;
	}

	public static List<Object> toList(JsonArray json) {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < json.size(); i++) {
			Object value = json.get(i);
			if (value instanceof JsonArray) {
				list.add(toList((JsonArray) value));
			} else if (value instanceof JsonObject) {
				list.add(toMap((JsonObject) value));
			} else {
				list.add(value);
			}
		}
		return list;
	}

	private static Object handlePrimitive(JsonPrimitive json) {
		if (json.isBoolean())
			return json.getAsBoolean();
		else if (json.isString())
			return json.getAsString();
		else {
			BigDecimal bigDec = json.getAsBigDecimal();
			// Find out if it is an int type
			try {
				bigDec.toBigIntegerExact();
				try {
					return bigDec.intValueExact();
				} catch (ArithmeticException e) {
				}
				return bigDec.longValue();
			} catch (ArithmeticException e) {
			}
			// Just return it as a double
			return bigDec.doubleValue();
		}
	}

}
