/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author horia.mut
 */
@Entity
@Table(name = "ingredient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i"),
    @NamedQuery(name = "Ingredient.findByIdIngredient", query = "SELECT i FROM Ingredient i WHERE i.idIngredient = :idIngredient"),
    @NamedQuery(name = "Ingredient.findByNom", query = "SELECT i FROM Ingredient i WHERE i.nom = :nom"),
    @NamedQuery(name = "Ingredient.findByQuantite", query = "SELECT i FROM Ingredient i WHERE i.quantite = :quantite"),
    @NamedQuery(name = "Ingredient.findByUnite", query = "SELECT i FROM Ingredient i WHERE i.unite = :unite")})
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingredient")
    private Integer idIngredient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Column(name = "quantite")
    private Integer quantite;
    @Size(max = 16)
    @Column(name = "unite")
    private String unite;
    @JoinColumn(name = "id_recette", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Recette idRecette;

    public Ingredient() {
    }

    public Ingredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Ingredient(Integer idIngredient, String nom) {
        this.idIngredient = idIngredient;
        this.nom = nom;
    }

    public Integer getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Recette getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(Recette idRecette) {
        this.idRecette = idRecette;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngredient != null ? idIngredient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.idIngredient == null && other.idIngredient != null) || (this.idIngredient != null && !this.idIngredient.equals(other.idIngredient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ingredient[ idIngredient=" + idIngredient + " ]";
    }
    
}
