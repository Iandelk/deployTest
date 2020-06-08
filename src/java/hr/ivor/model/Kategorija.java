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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phyrexian
 */
@Entity
@Table(name = "Kategorija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategorija.findAll", query = "SELECT k FROM Kategorija k")
    , @NamedQuery(name = "Kategorija.findByIDKategorija", query = "SELECT k FROM Kategorija k WHERE k.iDKategorija = :iDKategorija")
    , @NamedQuery(name = "Kategorija.findByNaziv", query = "SELECT k FROM Kategorija k WHERE k.naziv = :naziv")})
public class Kategorija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDKategorija")
    private Integer iDKategorija;
    @Basic(optional = false)
    @Column(name = "Naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorijaID")
    private List<Proizvod> proizvodList;

    public Kategorija() {
    }

    public Kategorija(Integer iDKategorija) {
        this.iDKategorija = iDKategorija;
    }

    public Kategorija(Integer iDKategorija, String naziv) {
        this.iDKategorija = iDKategorija;
        this.naziv = naziv;
    }

    public Integer getIDKategorija() {
        return iDKategorija;
    }

    public void setIDKategorija(Integer iDKategorija) {
        this.iDKategorija = iDKategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<Proizvod> getProizvodList() {
        return proizvodList;
    }

    public void setProizvodList(List<Proizvod> proizvodList) {
        this.proizvodList = proizvodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDKategorija != null ? iDKategorija.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategorija)) {
            return false;
        }
        Kategorija other = (Kategorija) object;
        if ((this.iDKategorija == null && other.iDKategorija != null) || (this.iDKategorija != null && !this.iDKategorija.equals(other.iDKategorija))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.ivor.model.Kategorija[ iDKategorija=" + iDKategorija + " ]";
    }
    
}
