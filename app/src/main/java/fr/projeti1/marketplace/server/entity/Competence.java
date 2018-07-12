package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "COMPETENCE")
public class Competence {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "COM_SEQ")
    private Long idComp;

    @ColumnInfo(name = "COM_LIB_COM")
    private String libelle;

    @ColumnInfo(name = "COM_DESC_COM")
    private String description;

    public Long getIdComp() {
        return idComp;
    }

    public void setIdComp(Long idComp) {
        this.idComp = idComp;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
