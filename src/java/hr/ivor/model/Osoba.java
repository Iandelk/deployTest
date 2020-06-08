/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ivor.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "Osoba")
@Proxy(lazy=false)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoba.findAll", query = "SELECT o FROM Osoba o")
    , @NamedQuery(name = "Osoba.findByIDOsoba", query = "SELECT o FROM Osoba o WHERE o.iDOsoba = :iDOsoba")
    , @NamedQuery(name = "Osoba.findByIme", query = "SELECT o FROM Osoba o WHERE o.ime = :ime")
    , @NamedQuery(name = "Osoba.findByPrezime", query = "SELECT o FROM Osoba o WHERE o.prezime = :prezime")
    , @NamedQuery(name = "Osoba.findByEmail", query = "SELECT o FROM Osoba o WHERE o.email = :email")
    , @NamedQuery(name = "Osoba.findByAdresa", query = "SELECT o FROM Osoba o WHERE o.adresa = :adresa")
    , @NamedQuery(name = "Osoba.findByUsername", query = "SELECT o FROM Osoba o WHERE o.username = :username")
    , @NamedQuery(name = "Osoba.findByPassword", query = "SELECT o FROM Osoba o WHERE o.password = :password")
    , @NamedQuery(name = "Osoba.findByAdministrator", query = "SELECT o FROM Osoba o WHERE o.administrator = :administrator")})
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDOsoba")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer iDOsoba;
    @Basic(optional = false)
    @Column(name = "Ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "Prezime")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Adresa")
    private String adresa;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Column(name = "Administrator")
    private Boolean administrator;
    @OneToMany(mappedBy = "osobaID")
    private List<Kosarica> kosaricaList;
    @OneToMany(mappedBy = "osobaID")
    private List<PovijestPrijave> povijestPrijaveList;

    public Osoba() {
    }

    public Osoba(Integer iDOsoba) {
        this.iDOsoba = iDOsoba;
    }

    public Osoba(String ime, String prezime, String email, String adresa, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
        this.username = username;
        this.password = password;
    }

    public Integer getIDOsoba() {
        return iDOsoba;
    }

    public void setIDOsoba(Integer iDOsoba) {
        this.iDOsoba = iDOsoba;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    @XmlTransient
    public List<Kosarica> getKosaricaList() {
        return kosaricaList;
    }

    public void setKosaricaList(List<Kosarica> kosaricaList) {
        this.kosaricaList = kosaricaList;
    }

    @XmlTransient
    public List<PovijestPrijave> getPovijestPrijaveList() {
        return povijestPrijaveList;
    }

    public void setPovijestPrijaveList(List<PovijestPrijave> povijestPrijaveList) {
        this.povijestPrijaveList = povijestPrijaveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOsoba != null ? iDOsoba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.iDOsoba == null && other.iDOsoba != null) || (this.iDOsoba != null && !this.iDOsoba.equals(other.iDOsoba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.ivor.model.Osoba[ iDOsoba=" + iDOsoba + " ]";
    }
    
}
