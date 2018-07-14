package fr.projeti1.marketplace.server.service;

import android.app.IntentService;
import android.content.Intent;
import fr.projeti1.marketplace.server.entity.ProfilPro;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;
import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.DAO.ProfilProDAO;

public class ProfilProService extends IntentService{
    private ProfilProDAO dao;
    public ProfilProService(){ super("ProfilPro"); }
    public void onCreate () {super.onCreate(); }

    @Override
    protected void onHandleIntent(Intent intent) {
        String nomFonction = intent.getStringExtra("nomFonction");

        switch(nomFonction){
            case "creerProfilPro":
                ProfilProDTO profilProDTO = (ProfilProDTO) intent.getSerializableExtra("profilProDTO");
                creerProfilPro(profilProDTO);
        }
    }

    public void creerProfilPro(ProfilProDTO profilProDTO){
        //Insertion en base
        dao = AppDataBase.getAppDatabase(getApplicationContext()).getProfilProDAO();
        ProfilPro profilPro =  entityFromDTO(profilProDTO);
        dao.insertProfilPro(profilPro);

        //Retour de l'id au presenter par l'intent
        Intent reponseIntent = new Intent();
        reponseIntent.putExtra("idProfilPro", profilPro.getId());
        sendBroadcast(reponseIntent);
    }

    //conversion ProfilProDTO en Entity ProfilPro
    public ProfilPro entityFromDTO(ProfilProDTO dto){
        ProfilPro profilPro = new ProfilPro();
        profilPro.setNumero(dto.getNumeroPro());
        profilPro.setNomPro(dto.getNomPro());
        profilPro.setPrenomPro(dto.getPrenomPro());
        profilPro.setNomSociete(dto.getNomSociete());
        profilPro.setSiretSociete(dto.getSiretSociete());
        profilPro.setNumDecennale(dto.getNumDecennale());
        //ajouter compétences
        profilPro.setNumeroTel(dto.getNumeroTelephone());
        profilPro.setMail(dto.getMail());
        profilPro.setAdresse(dto.getAdresse());
        profilPro.setVille(dto.getVille());
        profilPro.setCodePostal(dto.getCodePostal());

        return profilPro;
    }
}
