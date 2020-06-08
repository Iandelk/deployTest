package hr.ivor.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Osoba.class)
public abstract class Osoba_ {

	public static volatile SingularAttribute<Osoba, String> ime;
	public static volatile SingularAttribute<Osoba, String> prezime;
	public static volatile ListAttribute<Osoba, Kosarica> kosaricaList;
	public static volatile SingularAttribute<Osoba, String> password;
	public static volatile SingularAttribute<Osoba, Boolean> administrator;
	public static volatile SingularAttribute<Osoba, Integer> iDOsoba;
	public static volatile SingularAttribute<Osoba, String> adresa;
	public static volatile ListAttribute<Osoba, PovijestPrijave> povijestPrijaveList;
	public static volatile SingularAttribute<Osoba, String> email;
	public static volatile SingularAttribute<Osoba, String> username;

}

