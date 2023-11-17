import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();


    // добавление пользователя
    public void addUser(User user) {
        data.add(user);
    }

    // разлогинивание всех пользователей, кроме администратора
    public void logOut() {
        Iterator<User> userIterator = data.iterator();
        while (userIterator.hasNext()) {
            User nextUser = userIterator.next();
            if (!nextUser.isAdmin) {
                userIterator.remove();
            }
        }
    }

}
