/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import enums.CiviliteClient;
import enums.StatutClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cdi505
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "entities.Client.selectByEmailPwd", query = "select c from Client c where c.email = :paramEmail and c.hashMotPasse = :paramHashMotPasse"),
    @NamedQuery(name = "entities.Client.selectByCode", query = "select c from Client c where c.code = :paramCode"),
    @NamedQuery(name = "entities.Client.selectByEmail", query = "select c from Client c where c.email = :paramEmail")
})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private CiviliteClient civilite;
    private String nom;
    private String prenom;
    @Column(unique = true, nullable = false)
    private String email;
    private String hashMotPasse;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private StatutClient statut;
    private String commentaire;

    @ManyToOne(cascade = CascadeType.ALL)
    private Coordonnees coordonneesFacturation;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Coordonnees> listeCoordonneesLivraison;

    public Client() {
        listeCoordonneesLivraison = new ArrayList<>();
    }

    public Client(CiviliteClient civilite, String nom, String prenom, String email, String hashMotPasse, Date dateNaissance, StatutClient statut, String commentaire) {
        this();
        setCivilite(civilite);
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
        setHashMotPasse(hashMotPasse);
        setDateNaissance(dateNaissance);
        setStatut(statut);
        setCommentaire(commentaire);
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long id) {
        this.code = id;
    }

    public CiviliteClient getCivilite() {
        return civilite;
    }

    public final void setCivilite(CiviliteClient civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public final void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public final void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getNomComplet() {
        return String.format("%s %s", prenom, nom);
    }

    public String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        this.email = email;
    }

    public String getHashMotPasse() {
        return hashMotPasse;
    }

    public final void setHashMotPasse(String hashMotPasse) {
        this.hashMotPasse = hashMotPasse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public final void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public StatutClient getStatut() {
        return statut;
    }

    public final void setStatut(StatutClient statut) {
        this.statut = statut;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public final void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Coordonnees getCoordonneesFacturation() {
        return coordonneesFacturation;
    }

    public void setCoordonneesFacturation(Coordonnees coordonneesFacturation) {
        this.coordonneesFacturation = coordonneesFacturation;
    }

    public Collection<Coordonnees> getListeCoordonneesLivraison() {
        return listeCoordonneesLivraison;
    }

    public void setListeCoordonneesLivraison(Collection<Coordonnees> listeCoordonneesLivraison) {
        this.listeCoordonneesLivraison = listeCoordonneesLivraison;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Client[ id=" + code + " ]";
    }

}
