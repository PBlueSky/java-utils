package utils;

/*
 ** @Author:         blue_sky
 ** @CreateDate:     2023-03-22  18:48
 ** @ProjectName:    java-utils
 ** @Package:        utils
 */

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    private JSONUtils() {
    }

    /**
     * 将对象序列化为json
     * @param obj 对象
     * @return json
     */
    public static <T> String objectToJson(T obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Json序列化错误 "+e.getMessage());
        }
    }

    /**
     * 将json反序列化为对象
     * @param json json字符串
     * @param clazz 目标对象类型
     * @return 反序列化后的对象
     */
    public static <T> T jsonToObject(String json,Class<T> clazz){
        try {
            JsonParser parser = objectMapper.createParser(json);
            return objectMapper.readValue(parser,clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json反序列化错误 "+e.getMessage());
        }
    }
}
