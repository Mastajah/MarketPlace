package fr.projeti1.marketplace.server.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import fr.projeti1.marketplace.server.DAO.AnnonceDAO;
import fr.projeti1.marketplace.server.DAO.AvisDAO;
import fr.projeti1.marketplace.server.DAO.ProfilProDAO;
import fr.projeti1.marketplace.server.entity.Annonce;
import fr.projeti1.marketplace.server.entity.Particulier;

@Database(entities = {Annonce.class, Particulier.class}, version = 1)
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
