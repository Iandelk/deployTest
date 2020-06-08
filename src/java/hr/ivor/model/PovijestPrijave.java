/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phyrexian
 */
@Entity
@Table(name = "PovijestPrijave")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PovijestPrijave.findAll", query = "SELECT p FROM PovijestPrijave p")
    , @NamedQuery(name = "PovijestPrijave.findByIDPovijestPrijave", query = "SELECT p FROM PovijestPrijave p WHERE p.iDPovijestPrijave = :iDPovijestPrijave")
    , @NamedQuery(name = "PovijestPrijave.findByIPAdresa", query = "SELECT p FROM PovijestPrijave p WHERE p.iPAdresa = :iPAdresa")
    , @NamedQuery(name = "PovijestPrijave.findByVrijeme", query = "SELECT p FROM PovijestPrijave p WHERE p.vrijeme = :vrijeme")})
public class PovijestPrijave implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IDPovijestPrijave")
    private Integer iDPovijestPrijave;
    @Column(name = "IPAdresa")
    private String iPAdresa;
    @Column(name = "Vrijeme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vrijeme;
    @JoinColumn(name = "OsobaID", referencedColumnName = "IDOsoba")
    @ManyToOne
    private Osoba osobaID;

    public PovijestPrijave() {
    }

    public PovijestPrijave(Integer iDPovijestPrijave) {
        this.iDPovijestPrijave = iDPovijestPrijave;
    }

    public Integer getIDPovijestPrijave() {
        return iDPovijestPrijave;
    }

    public void setIDPovijestPrijave(Integer iDPovijestPrijave) {
        this.iDPovijestPrijave = iDPovijestPrijave;
    }

    public String getIPAdresa() {
        return iPAdresa;
    }

    public void setIPAdresa(String iPAdresa) {
        this.iPAdresa = iPAdresa;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    public Osoba getOsobaID() {
        return osobaID;
    }

    public void setOsobaID(Osoba osobaID) {
        this.osobaID = osobaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPovijestPrijave != null ? iDPovijestPrijave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PovijestPrijave)) {
            return false;
        }
        PovijestPrijave other = (PovijestPrijave) object;
        if ((this.iDPovijestPrijave == null && other.iDPovijestPrijave != null) || (this.iDPovijestPrijave != null && !this.iDPovijestPrijave.equals(other.iDPovijestPrijave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.ivor.model.PovijestPrijave[ iDPovijestPrijave=" + iDPovijestPrijave + " ]";
    }
    
}
