package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.entity.Competence;

@Dao
public interface AnnonceDAO{

    @Query("SELECT * FROM ANNONCE")
    List<Annonce> getAnnonces();

    @Insert
    void insertAnnonce(Annonce annonce);

    @Update
    void modifierAnnonce(Annonce annonce);

    @Delete
    void supprimerAnnonce(Annonce annonce);

    @Query("SELECT * FROM ANNONCE WHERE ANN_SEQ = :id")
    Annonce findById(Long id);

    @Query("SELECT * FROM ANNONCE WHERE ANN_VIL_ANN = :ville")
    List<Annonce> getAnnoncesByVille(String ville);

    @Query("SELECT * FROM ANNONCE WHERE ANN_STAT_ANN = :status")
    List<Annonce> getAnnonceByStatus(String status);


}
