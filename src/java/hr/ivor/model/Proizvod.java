/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author Phyrexian
 */
@Entity
@Table(name = "Proizvod")
@Proxy(lazy=false)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proizvod.findAll", query = "SELECT p FROM Proizvod p")
    , @NamedQuery(name = "Proizvod.findByIDProizvod", query = "SELECT p FROM Proizvod p WHERE p.iDProizvod = :iDProizvod")
    , @NamedQuery(name = "Proizvod.findByNaziv", query = "SELECT p FROM Proizvod p WHERE p.naziv = :naziv")
    , @NamedQuery(name = "Proizvod.findByCijena", query = "SELECT p FROM Proizvod p WHERE p.cijena = :cijena")
    , @NamedQuery(name = "Proizvod.findByOpis", query = "SELECT p FROM Proizvod p WHERE p.opis = :opis")
    , @NamedQuery(name = "Proizvod.findBySlikaURL", query = "SELECT p FROM Proizvod p WHERE p.slikaURL = :slikaURL")})
public class Proizvod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDProizvod")
    private Integer iDProizvod;
    @Basic(optional = false)
    @Column(name = "Naziv")
    private String naziv;
    @Column(name = "Cijena")
    private Long cijena;
    @Column(name = "Opis")
    private String opis;
    @Column(name = "SlikaURL")
    private String slikaURL;
    @JoinColumn(name = "KategorijaID", referencedColumnName = "IDKategorija")
    @ManyToOne(optional = false)
    private Kategorija kategorijaID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proizvodID")
    private List<Stavka> stavkaList;

    public Proizvod() {
    }

    public Proizvod(Integer iDProizvod) {
        this.iDProizvod = iDProizvod;
    }

    public Proizvod(Integer iDProizvod, String naziv) {
        this.iDProizvod = iDProizvod;
        this.naziv = naziv;
    }

    public Integer getIDProizvod() {
        return iDProizvod;
    }

    public void setIDProizvod(Integer iDProizvod) {
        this.iDProizvod = iDProizvod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getCijena() {
        return cijena;
    }

    public void setCijena(Long cijena) {
        this.cijena = cijena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlikaURL() {
        return slikaURL;
    }

    public void setSlikaURL(String slikaURL) {
        this.slikaURL = slikaURL;
    }

    public Kategorija getKategorijaID() {
        return kategorijaID;
    }

    public void setKategorijaID(Kategorija kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    @XmlTransient
    public List<Stavka> getStavkaList() {
        return stavkaList;
    }

    public void setStavkaList(List<Stavka> stavkaList) {
        this.stavkaList = stavkaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProizvod != null ? iDProizvod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proizvod)) {
            return false;
        }
        Proizvod other = (Proizvod) object;
        if ((this.iDProizvod == null && other.iDProizvod != null) || (this.iDProizvod != null && !this.iDProizvod.equals(other.iDProizvod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return iDProizvod.toString();
    }
    
}
