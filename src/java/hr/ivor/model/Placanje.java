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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Placanje")
@Proxy(lazy=false)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Placanje.findAll", query = "SELECT p FROM Placanje p")
    , @NamedQuery(name = "Placanje.findByIDPlacanje", query = "SELECT p FROM Placanje p WHERE p.iDPlacanje = :iDPlacanje")
    , @NamedQuery(name = "Placanje.findByVrsta", query = "SELECT p FROM Placanje p WHERE p.vrsta = :vrsta")})
public class Placanje implements Serializable {

   public static enum nacinPlacanja {
  GOTOVINA_POUZECE(1),
  PAYPAL(2);
  
  private int value;
  
  private nacinPlacanja(int value){
      this.value=value;
  }
  public int getValue(){
      return value;
  }
}
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPlacanje")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer iDPlacanje;
    @Column(name = "Vrsta")
    private String vrsta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placanje")
    private List<Kosarica> kosaricaList;

    public Placanje() {
    }

    public Placanje(Integer iDPlacanje) {
        this.iDPlacanje = iDPlacanje;
    }

    public Integer getIDPlacanje() {
        return iDPlacanje;
    }

    public void setIDPlacanje(Integer iDPlacanje) {
        this.iDPlacanje = iDPlacanje;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    @XmlTransient
    public List<Kosarica> getKosaricaList() {
        return kosaricaList;
    }

    public void setKosaricaList(List<Kosarica> kosaricaList) {
        this.kosaricaList = kosaricaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDPlacanje != null ? iDPlacanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placanje)) {
            return false;
        }
        Placanje other = (Placanje) object;
        if ((this.iDPlacanje == null && other.iDPlacanje != null) || (this.iDPlacanje != null && !this.iDPlacanje.equals(other.iDPlacanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.ivor.model.Placanje[ iDPlacanje=" + iDPlacanje + " ]";
    }
    
}
