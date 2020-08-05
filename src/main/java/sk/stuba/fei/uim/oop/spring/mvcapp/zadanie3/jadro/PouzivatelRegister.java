package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.jadro;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy.Zmluva;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities.GeneratorId;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities.Pouzivatel;

import java.util.ArrayList;
import java.util.List;

@Service
public class PouzivatelRegister implements PouzivatelAPI {
    List<Pouzivatel> users;
    public PouzivatelRegister()
    {
        this.users = new ArrayList<>();
    }
    @Override
    public void addUser( Pouzivatel u )
    {
        u.setId(GeneratorId.newId());
        this.users.add(u);
    }

    @Override
    public Pouzivatel getUser(long id )
    {
        for ( Pouzivatel u : users ) {
            if(u.getId() == id )
            {
                return u;
            }
        }
        return null;
    }
    @Override
    public void editUser( long id, Pouzivatel from )
    {
        for ( Pouzivatel u : users ) {
            if(u.getId() == id )
            {
                u.edit( from );
                return;
            }
        }
        System.out.println("User not found");
    }

    @Override
    public List<Pouzivatel> getAllUsers()
    {
        return this.users;
    }
    //
//    public void printAllContracts()
//    {
//        for ( User u : users ) {
//            System.out.println(u.toString());
//            u.printContracts();
//        }
//    }
//
    public void addZmluva(long user_id, Zmluva c )
    {
        if(getUser(user_id) != null )
            getUser(user_id).addZmluva(c);
        else
            System.out.println("User not found");
    }
//
//    public void editContract( long id )
//    {
//        boolean ret = false;
//        for( User u : users )
//        {
//            ret = u.editContract(id);
//            if(ret)
//                return;
//        }
//        System.out.println("Contract id not found");
//    }
}
