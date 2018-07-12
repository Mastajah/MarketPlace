package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import fr.projeti1.marketplace.server.entity.Annonce;

@Dao
public interface AnnonceDAO{

    @Query("SELECT * FROM ANNONCE")
    public List<Annonce> getAnnonces();

    @Insert
    public void insertAnnonce(Annonce annonce);

}
