/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author horia.mut
 */
@Entity
@Table(name = "recette")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recette.findAll", query = "SELECT r FROM Recette r"),
    @NamedQuery(name = "Recette.findById", query = "SELECT r FROM Recette r WHERE r.id = :id"),
    @NamedQuery(name = "Recette.findByNom", query = "SELECT r FROM Recette r WHERE r.nom = :nom"),
    @NamedQuery(name = "Recette.findByTempsPreparation", query = "SELECT r FROM Recette r WHERE r.tempsPreparation = :tempsPreparation"),
    @NamedQuery(name = "Recette.findByTempsCuisson", query = "SELECT r FROM Recette r WHERE r.tempsCuisson = :tempsCuisson"),
    @NamedQuery(name = "Recette.findByDifficulte", query = "SELECT r FROM Recette r WHERE r.difficulte = :difficulte"),
    @NamedQuery(name = "Recette.findByMotsCles", query = "SELECT r FROM Recette r WHERE r.motsCles = :motsCles")})
public class Recette implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temps_preparation")
    private short tempsPreparation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temps_cuisson")
    private short tempsCuisson;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "preparation")
    private String preparation;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "remarque")
    private String remarque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "difficulte")
    private boolean difficulte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mots_cles")
    private String motsCles;
    @JoinColumn(name = "auteur", referencedColumnName = "pseudo")
    @ManyToOne(optional = false)
    private Utilisateur auteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRecette")
    private Collection<Ingredient> ingredientCollection;

    public Recette() {
    }

    public Recette(Integer id) {
        this.id = id;
    }

    public Recette(Integer id, String nom, short tempsPreparation, short tempsCuisson, String preparation, String remarque, boolean difficulte, String motsCles) {
        this.id = id;
        this.nom = nom;
        this.tempsPreparation = tempsPreparation;
        this.tempsCuisson = tempsCuisson;
        this.preparation = preparation;
        this.remarque = remarque;
        this.difficulte = difficulte;
        this.motsCles = motsCles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public short getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(short tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public short getTempsCuisson() {
        return tempsCuisson;
    }

    public void setTempsCuisson(short tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public boolean getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(boolean difficulte) {
        this.difficulte = difficulte;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    @XmlTransient
    public Collection<Ingredient> getIngredientCollection() {
        return ingredientCollection;
    }

    public void setIngredientCollection(Collection<Ingredient> ingredientCollection) {
        this.ingredientCollection = ingredientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recette)) {
            return false;
        }
        Recette other = (Recette) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Recette[ id=" + id + " ]";
    }
    
}
