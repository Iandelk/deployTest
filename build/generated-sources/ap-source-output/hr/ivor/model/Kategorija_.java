package hr.ivor.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Kategorija.class)
public abstract class Kategorija_ {

	public static volatile SingularAttribute<Kategorija, Integer> iDKategorija;
	public static volatile SingularAttribute<Kategorija, String> naziv;
	public static volatile ListAttribute<Kategorija, Proizvod> proizvodList;

}

