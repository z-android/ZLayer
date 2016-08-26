package prin.com.zlayer.utils;


import java.util.Map;

public class ZJsonUtils {

	private ZJsonParserInterface mJsonParserImpl;

	private static ZJsonUtils instance = null;

	private ZJsonUtils() {
		mJsonParserImpl = new ZGsonParserImpl();
	}

	public static ZJsonUtils instance() {
		if (instance == null) {
			instance = new ZJsonUtils();
		}

		return instance;
	}

	public ZJsonUtils setParserImpl(ZJsonParserInterface impl) {
		if (impl != null) {
			mJsonParserImpl = impl;
		}
		return this;
	}

	public <T> T jsonToModel(String json, Class<T> clazz) {
		return mJsonParserImpl.jsonToModel(json, clazz);
	}

	public Map<String, Object> jsonToMap(String json) {
		return mJsonParserImpl.jsonToMap(json);
	}

	public String objToJson(Object obj) {
		return mJsonParserImpl.objToJson(obj);
	}
}
