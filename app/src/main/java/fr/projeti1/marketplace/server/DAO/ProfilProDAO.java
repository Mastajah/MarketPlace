package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.projeti1.marketplace.server.entity.Particulier;
import fr.projeti1.marketplace.server.entity.ProfilPro;

@Dao
public interface ProfilProDAO {

    @Query("SELECT * FROM PROFILPRO")
    List<ProfilPro> getProfilPros();

    @Insert
    void insertProfilPro(ProfilPro profilPro);

    @Update
    void modifierProfilPro(ProfilPro profilPro);

    @Delete
    void supprimerProfilPro(ProfilPro profilPro);

    @Query("SELECT * FROM PROFILPRO WHERE PROP_SEQ = :id")
    ProfilPro findById(Long id);
}
