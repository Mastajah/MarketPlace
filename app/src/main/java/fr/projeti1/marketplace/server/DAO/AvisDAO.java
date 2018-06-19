package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import java.util.List;
import fr.projeti1.marketplace.server.entity.Avis;

@Dao
public interface AvisDAO {

    @Query("SELECT * FROM AVIS")
    public List<Avis> getAvis();


}
