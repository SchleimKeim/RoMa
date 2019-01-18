package ch.zhaw.roma.model.repositories;

import ch.zhaw.roma.interfaces.IRepositority;
import org.hibernate.Session;

public class TestRepository implements IRepositority {

    private final Session session;

    public TestRepository(Session s) {
        session = s;
    }

    @Override
    public Session getSession() {
        return null;
    }
}
