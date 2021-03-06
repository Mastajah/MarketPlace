package fr.projeti1.marketplace.server.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
import fr.projeti1.marketplace.server.entity.Competence;

@Dao
public interface CompetenceDAO {

    @Query("SELECT * FROM COMPETENCE")
    List<Competence> getCompentences();

    @Insert
    void insertCompentence(Competence competence);

    @Insert
    void insertAll(List<Competence> competences);

    @Update
    void modifierCompentence(Competence competence);

    @Delete
    void supprimerCompentence(Competence competence);

    @Query("SELECT * FROM COMPETENCE WHERE COM_SEQ = :id")
    Competence findById(Long id);

    @Query("SELECT * FROM COMPETENCE WHERE COM_ANN_SEQ =:id")
    List<Competence> getCompetencesByAnnonce(Long id);
}
