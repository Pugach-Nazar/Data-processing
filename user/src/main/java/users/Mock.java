package users;

import java.util.ArrayList;
import java.util.List;

public class Mock {
    private List<User> userList = new ArrayList<>();

    public Mock(){
        this.userList.add(new User(0, "Name", 20));
        this.userList.add(new User(1, "Name1", 21));
        this.userList.add(new User(2, "Name2", 21));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
