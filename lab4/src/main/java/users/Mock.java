package users;

import java.util.ArrayList;
import java.util.List;

public class Mock {
    private List<User1> userList = new ArrayList<>();

    public Mock(){
        this.userList.add(new User1(0, "Name", 20));
        this.userList.add(new User1(1, "Name1", 21));
        this.userList.add(new User1(2, "Name2", 21));
    }

    public List<User1> getUserList() {
        return userList;
    }

    public void setUserList(List<User1> userList) {
        this.userList = userList;
    }
}
