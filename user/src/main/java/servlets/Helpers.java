package servlets;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;
import users.User;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Helpers {
    public static JsonElement bodyParse(HttpServletRequest request){
        JsonElement jsonElement = null;
        try {
            jsonElement = JsonParser.parseReader(request.getReader());
        } catch (JsonIOException | JsonSyntaxException | IOException  e) {
            e.printStackTrace();
        }
        return jsonElement;
    }

    public static User userParse(HttpServletRequest request){
        User user = new User();
        JsonElement jsonElement = bodyParse(request);
        user.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        user.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        user.setAge(jsonElement.getAsJsonObject().get("age").getAsInt());
        return user;
    }
    public static int getNextId(List<User> list){
        int maxId = 0;
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()){
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexByUserId(int id, List<User> list){
        int listId = id;

        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()){
            User temp = iterator.next();
            if(temp.getId()==listId){
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}
