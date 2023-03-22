package utils;

/*
 ** @Author:         blue_sky
 ** @CreateDate:     2023-03-22  18:57
 ** @ProjectName:    java-utils
 ** @Package:        utils
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONUtilsTest {
    @Test
    public void testJsonConvert(){
        // // {"username":"张三","email":"11111111@qq.com","age":21}
        String srcJson = "{\"username\":\"张三\",\"email\":\"11111111@qq.com\",\"age\":21}";
        User user = JSONUtils.jsonToObject(srcJson, User.class);
        String desJson = JSONUtils.objectToJson(user);
        Assertions.assertEquals(srcJson,desJson);
    }


    private static class User{
        private String username;
        private String email;
        private int age;

        public User() {
        }

        public User(String username, String email, int age) {
            this.username = username;
            this.email = email;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", email='" + email + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
