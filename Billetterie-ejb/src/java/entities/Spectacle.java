package entities;

import enums.StatutSpectacle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "entities.Spectacle.selectById", query = "SELECT s FROM Spectacle s WHERE s.id = :paramId"), // no need for this query: should just use find
    @NamedQuery(name = "entities.Spectacle.selectSeancesBySpectacle", query = "SELECT s FROM Seance s WHERE s.spectacle = :paramSpectacle ORDER BY s.date"), // shouldn't be here: belongs to Seance
    @NamedQuery(name = "entities.Spectacle.selectGroupeBySpectacle", query = "SELECT g FROM Groupe g WHERE g.spectacle = :paramSpectacle"), // shouldn't be here: belongs to Groupe
    @NamedQuery(name = "entities.Spectacle.selectCategorie", query = "SELECT c FROM Categorie c WHERE c.Seances = :paramSeance"), // shouldn't be here: beelongs to Categorie
    @NamedQuery(name = "entities.Spectacle.select", query = "SELECT DISTINCT s FROM Spectacle s JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.statut = :paramStatut ORDER BY s.titre"),
    @NamedQuery(name = "entities.Spectacle.count", query = "SELECT COUNT(DISTINCT s) FROM Spectacle s JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.statut = :paramStatut"),
    @NamedQuery(name = "entities.Spectacle.countAll", query = "SELECT COUNT(s) FROM Spectacle s"),
    @NamedQuery(name = "entities.Spectacle.selectBySearch", query = "SELECT DISTINCT s FROM Spectacle s LEFT JOIN s.evenement e LEFT JOIN s.groupes g LEFT JOIN g.fonctions f LEFT JOIN f.participants p JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.statut = :paramStatut AND (s.titre LIKE :paramTitle OR s.description LIKE :paramDescription OR e.nom LIKE :paramEventName OR p.nom LIKE :paramParticipantName) ORDER BY s.titre"),
    @NamedQuery(name = "entities.Spectacle.countBySearch", query = "SELECT COUNT(DISTINCT s) FROM Spectacle s LEFT JOIN s.evenement e LEFT JOIN s.groupes g LEFT JOIN g.fonctions f LEFT JOIN f.participants p JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.statut = :paramStatut AND (s.titre LIKE :paramTitle OR s.description LIKE :paramDescription OR e.nom LIKE :paramEventName OR p.nom LIKE :paramParticipantName)"),
    @NamedQuery(name = "entities.Spectacle.selectBySubTheme", query = "SELECT DISTINCT s FROM Spectacle s JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.sousTheme.nom = :paramSubThemeNom AND s.statut = :paramStatut ORDER BY s.titre"),
    @NamedQuery(name = "entities.Spectacle.countBySubTheme", query = "SELECT COUNT(DISTINCT s) FROM Spectacle s JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.statut = :paramStatut AND s.sousTheme.nom = :paramSubThemeNom"),
    @NamedQuery(name = "entities.Spectacle.selectByTheme", query = "SELECT DISTINCT s FROM Spectacle s JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.sousTheme.theme.nom = :paramThemeNom AND s.statut = :paramStatut ORDER BY s.titre"),
    @NamedQuery(name = "entities.Spectacle.countByTheme", query = "SELECT COUNT(DISTINCT s) FROM Spectacle s JOIN s.seances se WHERE se.date > CURRENT_DATE AND s.statut = :paramStatut AND s.sousTheme.theme.nom = :paramThemeNom"),
    @NamedQuery(name = "entities.Spectacle.selectBestSelling", query = "SELECT b.seance.spectacle FROM Billet b WHERE b.seance.date > CURRENT_DATE AND b.ligneCommande IS NOT NULL GROUP BY b.seance.spectacle ORDER BY COUNT(b.seance.spectacle) DESC")
})
public class Spectacle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private StatutSpectacle statut;

//--------------------------------------------------------------------------------------
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Image image;

    @OneToMany(mappedBy = "spectacle")
    private Collection<Seance> seances;

    @OneToMany(mappedBy = "spectacle")
    private Collection<Groupe> groupes;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private SousTheme sousTheme;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Evenement evenement;

//---------------------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatutSpectacle getStatut() {
        return statut;
    }

    public void setStatut(StatutSpectacle statut) {
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Spectacle() {
        groupes = new ArrayList<>();
        seances = new ArrayList<>();
    }

    public Spectacle(String titre, String description, StatutSpectacle statut, Collection<Seance> seances) {
        this();
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.seances = seances;
    }

    public Spectacle(String titre, String description, StatutSpectacle statut, SousTheme sousTheme, Evenement evenement) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.sousTheme = sousTheme;
        this.evenement = evenement;
    }

    public Spectacle(String titre, String description, StatutSpectacle statut) {
        this();
        this.titre = titre;
        this.description = description;
        this.statut = statut;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Collection<Seance> getSeances() {
        return seances;
    }

    public void setSeances(Collection<Seance> seances) {
        this.seances = seances;
    }

    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }

    public SousTheme getSousTheme() {
        return sousTheme;
    }

    public void setSousTheme(SousTheme sousTheme) {
        this.sousTheme = sousTheme;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    @Override
    public String toString() {
        return "entities.Spectacle[ id=" + id + " ]" + "titre : " + titre;
    }

}
