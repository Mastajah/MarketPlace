package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
import fr.projeti1.marketplace.server.entity.Particulier;

@Dao
public interface ParticulierDAO {

    @Query("SELECT * FROM PARTICULIER")
    List<Particulier> getPariculiers();

    @Insert
    void insertParticulier(Particulier particulier);

    @Update
    void modifierParticulier(Particulier particulier);

    @Delete
    void supprimerParticulier(Particulier particulier);

    @Query("SELECT * FROM PARTICULIER WHERE PAR_SEQ = :id")
    Particulier findById(Long id);
}
