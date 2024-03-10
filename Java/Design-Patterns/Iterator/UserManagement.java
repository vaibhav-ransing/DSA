import java.util.*;

public class UserManagement {
    

    List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public User getUser(int idx){
        return users.get(idx);
    }

    public MyIterator getIterator(){
        return new MyIteratorImpl(users);
    }

}
