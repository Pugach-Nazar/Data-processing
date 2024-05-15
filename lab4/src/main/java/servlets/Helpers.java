package servlets;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import jakarta.servlet.http.HttpServletRequest;
import users.User1;

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

    public static User1 userParse(HttpServletRequest request){
        User1 user = new User1();
        JsonElement jsonElement = bodyParse(request);
        user.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
        user.setName(jsonElement.getAsJsonObject().get("name").getAsString());
        user.setAge(jsonElement.getAsJsonObject().get("age").getAsInt());
        return user;
    }
    public static int getNextId(List<User1> list){
        int maxId = 0;
        Iterator<User1> iterator = list.iterator();
        while (iterator.hasNext()){
            int currentId = iterator.next().getId();
            if(currentId>maxId) maxId=currentId;
        }
        return maxId+1;
    }

    public static int getIndexByUserId(int id, List<User1> list){
        int listId = id;

        Iterator<User1> iterator = list.iterator();
        while (iterator.hasNext()){
            User1 temp = iterator.next();
            if(temp.getId()==listId){
                listId=list.indexOf(temp);
                break;
            }
        }
        return listId;
    }
}
