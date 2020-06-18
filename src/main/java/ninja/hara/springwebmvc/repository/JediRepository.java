package ninja.hara.springwebmvc.repository;

import ninja.hara.springwebmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JediRepository {
    private List<Jedi> lstJedi;

    public JediRepository() {
        lstJedi = new ArrayList<>();
//        lstJedi.add(new Jedi("Luke", "Skywalker"));
    }

    public List<Jedi> getAllJedi() {
        return lstJedi;
    }

    public void add(Jedi jedi) {
        this.lstJedi.add(jedi);
    }

    public List<Jedi> findAll() {
        return lstJedi;
    }

    public Optional<Jedi> findById(Long jediId) {
        Optional<Jedi> retorno;
        try {
            retorno = Optional.of(lstJedi.get(jediId.intValue()));
        }catch(IndexOutOfBoundsException e){
            retorno = Optional.empty();
        }
        return retorno;
    }

    public Jedi save(Jedi jedi) {
        int id = lstJedi.size();
        jedi.setId((long) id);
        lstJedi.add(jedi);
        return jedi;
    }

    public void delete(Jedi jedi) {
    }
}
