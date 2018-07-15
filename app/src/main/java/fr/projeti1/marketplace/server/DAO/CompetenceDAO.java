package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.entity.Competence;
import fr.projeti1.marketplace.server.entity.Particulier;

@Dao
public interface CompetenceDAO {

    @Query("SELECT * FROM COMPETENCE")
    List<Competence> getCompentences();

    @Insert
    void insertCompentence(Competence competence);

    @Update
    void modifierCompentence(Competence competence);

    @Delete
    void supprimerCompentence(Competence competence);

    @Query("SELECT * FROM COMPETENCE WHERE COM_SEQ = :id")
    Competence findById(Long id);
}
