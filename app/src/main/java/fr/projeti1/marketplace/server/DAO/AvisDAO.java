package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.entity.Avis;

@Dao
public interface AvisDAO {

    @Query("SELECT * FROM AVIS")
    List<Avis> getAvis();

    @Insert
    void insertAvis(Avis avis);

    @Update
    void modifierAvis(Avis avis);

    @Delete
    void supprimerAvis(Avis avis);

    @Query("SELECT * FROM AVIS WHERE AVIS_SEQ = :id")
    Avis findById(Long id);
}
