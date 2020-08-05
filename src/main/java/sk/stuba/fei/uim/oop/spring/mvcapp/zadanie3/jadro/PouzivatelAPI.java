package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.jadro;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities.Pouzivatel;

import java.util.List;

@Service
public interface PouzivatelAPI {
    void addUser( Pouzivatel u );
    void editUser( long id, Pouzivatel u );
    Pouzivatel getUser(long id);
    List<Pouzivatel> getAllUsers();
}
