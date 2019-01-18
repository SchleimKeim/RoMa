package ch.zhaw.roma.interfaces;

import org.hibernate.Session;

public interface IRepositority {
    Session getSession();
}
