package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class TypeTransmogrifiers {

    private static final String TAG="TypeTransmogrifier";

    public TypeTransmogrifiers(){

    }

    @TypeConverter
    public static Long fromDate(Date date) {
        if (date==null) {
            return(null);
        }

        return(date.getTime());
    }

    @TypeConverter
    public static Date toDate(Long millisSinceEpoch) {
        if (millisSinceEpoch==null) {
            return(null);
        }

        return(new Date(millisSinceEpoch));
    }
}
