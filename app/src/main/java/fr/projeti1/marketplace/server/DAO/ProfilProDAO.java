package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import java.util.List;
import fr.projeti1.marketplace.server.entity.ProfilPro;

@Dao
public interface ProfilProDAO {

    @Query("SELECT * FROM PROFILPRO")
    public List<ProfilPro> getProfilPro();

    //findById(Long id)

    //findAll()

    //create(ProfilPro prop)

    //update()

    //delete()
}
