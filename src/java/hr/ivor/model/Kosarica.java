/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phyrexian
 */
@Entity
@Table(name = "Kosarica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kosarica.findAll", query = "SELECT k FROM Kosarica k")
    , @NamedQuery(name = "Kosarica.findByIDKosarica", query = "SELECT k FROM Kosarica k WHERE k.iDKosarica = :iDKosarica")
    , @NamedQuery(name = "Kosarica.findByVrijeme", query = "SELECT k FROM Kosarica k WHERE k.vrijeme = :vrijeme")
    , @NamedQuery(name = "Kosarica.findByUkupnaCijena", query = "SELECT k FROM Kosarica k WHERE k.ukupnaCijena = :ukupnaCijena")})
public class Kosarica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDKosarica")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer iDKosarica;
    @Column(name = "Vrijeme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vrijeme;
    @Column(name = "UkupnaCijena")
    private Long ukupnaCijena;
    @JoinColumn(name = "OsobaID", referencedColumnName = "IDOsoba")
    @ManyToOne
    private Osoba osobaID;
    @JoinColumn(name = "Placanje", referencedColumnName = "IDPlacanje")
    @ManyToOne(optional = false)
    private Placanje placanje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kosaricaID")
    private List<Stavka> stavkaList;

    public Kosarica() {
    }

    public Kosarica(Integer iDKosarica) {
        this.iDKosarica = iDKosarica;
    }

    public Integer getIDKosarica() {
        return iDKosarica;
    }

    public void setIDKosarica(Integer iDKosarica) {
        this.iDKosarica = iDKosarica;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    public Long getUkupnaCijena() {
        return ukupnaCijena;
    }

    public void setUkupnaCijena(Long ukupnaCijena) {
        this.ukupnaCijena = ukupnaCijena;
    }

    public Osoba getOsobaID() {
        return osobaID;
    }

    public void setOsobaID(Osoba osobaID) {
        this.osobaID = osobaID;
    }

    public Placanje getPlacanje() {
        return placanje;
    }

    public void setPlacanje(Placanje placanje) {
        this.placanje = placanje;
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
        hash += (iDKosarica != null ? iDKosarica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kosarica)) {
            return false;
        }
        Kosarica other = (Kosarica) object;
        if ((this.iDKosarica == null && other.iDKosarica != null) || (this.iDKosarica != null && !this.iDKosarica.equals(other.iDKosarica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.ivor.model.Kosarica[ iDKosarica=" + iDKosarica + " ]";
    }
    
}
