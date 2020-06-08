/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Phyrexian
 */
@Entity
@Table(name = "Stavka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavka.findAll", query = "SELECT s FROM Stavka s")
    , @NamedQuery(name = "Stavka.findByIDStavka", query = "SELECT s FROM Stavka s WHERE s.iDStavka = :iDStavka")
    , @NamedQuery(name = "Stavka.findByBrojPrimjeraka", query = "SELECT s FROM Stavka s WHERE s.brojPrimjeraka = :brojPrimjeraka")})
public class Stavka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDStavka")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer iDStavka;
    @Column(name = "brojPrimjeraka")
    private Integer brojPrimjeraka;
    @JoinColumn(name = "KosaricaID", referencedColumnName = "IDKosarica")
    @ManyToOne(optional = false)
    private Kosarica kosaricaID;
    @JoinColumn(name = "ProizvodID", referencedColumnName = "IDProizvod")
    @ManyToOne(optional = false)
    private Proizvod proizvodID;    
    public Stavka() {
    }
    
    public Stavka(Proizvod proizvod, String brojPrimjeraka){
        proizvodID = proizvod;
        this.brojPrimjeraka = Integer.parseInt(brojPrimjeraka);
    }

    public Stavka(Integer iDStavka) {
        this.iDStavka = iDStavka;
    }

    public Integer getIDStavka() {
        return iDStavka;
    }

    public void setIDStavka(Integer iDStavka) {
        this.iDStavka = iDStavka;
    }

    public Integer getBrojPrimjeraka() {
        return brojPrimjeraka;
    }

    public void setBrojPrimjeraka(Integer brojPrimjeraka) {
        this.brojPrimjeraka = brojPrimjeraka;
    }

    public Kosarica getKosaricaID() {
        return kosaricaID;
    }

    public void setKosaricaID(Kosarica kosaricaID) {
        this.kosaricaID = kosaricaID;
    }

    public Proizvod getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(Proizvod proizvodID) {
        this.proizvodID = proizvodID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDStavka != null ? iDStavka.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavka)) {
            return false;
        }
        Stavka other = (Stavka) object;
        if ((this.iDStavka == null && other.iDStavka != null) || (this.iDStavka != null && !this.iDStavka.equals(other.iDStavka))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.ivor.model.Stavka[ iDStavka=" + iDStavka + " ]";
    }
    
}
