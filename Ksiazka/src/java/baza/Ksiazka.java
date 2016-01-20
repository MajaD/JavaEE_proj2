/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Maja
 */
@Entity
@Table(name = "ksiazka", catalog = "ksiazkibaza", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ksiazka.findAll", query = "SELECT k FROM Ksiazka k"),
    @NamedQuery(name = "Ksiazka.findById", query = "SELECT k FROM Ksiazka k WHERE k.id = :id"),
    @NamedQuery(name = "Ksiazka.findByTytul", query = "SELECT k FROM Ksiazka k WHERE k.tytul = :tytul"),
    @NamedQuery(name = "Ksiazka.findByAutor", query = "SELECT k FROM Ksiazka k WHERE k.autor = :autor"),
    @NamedQuery(name = "Ksiazka.findByOpis", query = "SELECT k FROM Ksiazka k WHERE k.opis = :opis")})
public class Ksiazka implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tytul")
    private String tytul;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "opis")
    private String opis;

    public Ksiazka() {
    }

    public Ksiazka(Integer id) {
        this.id = id;
    }

    public Ksiazka(Integer id, String tytul, String autor, String opis) {
        this.id = id;
        this.tytul = tytul;
        this.autor = autor;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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
        if (!(object instanceof Ksiazka)) {
            return false;
        }
        Ksiazka other = (Ksiazka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.Ksiazka[ id=" + id + " ]";
    }
    
}
