package ch.zhaw.roma.model.repositories;

import ch.zhaw.roma.interfaces.IRepositority;
import org.hibernate.Session;

public class ApplicationRepositoriy implements IRepositority {

    private final Session session;

    public ApplicationRepositoriy(Session s) {

        session = s;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
