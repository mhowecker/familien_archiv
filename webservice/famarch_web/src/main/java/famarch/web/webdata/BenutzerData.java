package famarch.web.webdata;

import famarch.web.dbdata.Benutzer;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.util.LinkedList;
import java.util.List;

public class BenutzerData {
    private List<Benutzer> users;

    public BenutzerData() {
        this.users = new LinkedList<Benutzer>();
    }

    public void setUsers(List<Benutzer> users) {
        this.users = users;
    }

    public List<Benutzer> getUsers() {
        return this.users;
    }

    public void addUser(Benutzer user) {
        this.users.add(user);
    }
}
