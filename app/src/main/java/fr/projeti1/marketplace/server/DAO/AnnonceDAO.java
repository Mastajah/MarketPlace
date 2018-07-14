package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.projeti1.marketplace.server.entity.Annonce;

@Dao
public interface AnnonceDAO{

    @Query("SELECT * FROM ANNONCE")
    public List<Annonce> getAnnonces();

    @Insert
    public void insertAnnonce(Annonce annonce);

    @Update
    public void modifierAnnonce(Annonce annonce);

    @Delete
    public void supprimerAnnonce(Annonce annonce);

    @Query("SELECT * FROM ANNONCE WHERE ANN_VIL_ANN = :ville")
    public List<Annonce> getAnnoncesByVille(String ville);

    @Query("SELECT * FROM ANNONCE WHERE ANN_STAT_ANN = :status")
    public List<Annonce> getAnnonceByStatus(String status);

}
