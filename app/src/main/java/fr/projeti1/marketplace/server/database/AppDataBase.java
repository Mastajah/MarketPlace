package fr.projeti1.marketplace.server.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import fr.projeti1.marketplace.server.DAO.AnnonceDAO;
import fr.projeti1.marketplace.server.DAO.AvisDAO;
import fr.projeti1.marketplace.server.DAO.ProfilProDAO;
import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.entity.Avis;
import fr.projeti1.marketplace.server.entity.Competence;
import fr.projeti1.marketplace.server.entity.Particulier;
import fr.projeti1.marketplace.server.entity.ProfilPro;
import fr.projeti1.marketplace.server.entity.TypeTransmogrifiers;

@Database(entities = {Annonce.class, Particulier.class,Avis.class,ProfilPro.class, Competence.class}, version = 1)
@TypeConverters({TypeTransmogrifiers.class})
public abstract class AppDataBase extends RoomDatabase{

    //Liste des DAO
    public abstract AnnonceDAO getAnnonceDAO();
    public abstract AvisDAO getAvisDAO();
    public abstract ProfilProDAO getProfilProDAO();

    private static AppDataBase INSTANCE;

    public static AppDataBase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "database").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
