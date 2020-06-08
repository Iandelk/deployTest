package hr.ivor.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Proizvod.class)
public abstract class Proizvod_ {

	public static volatile SingularAttribute<Proizvod, Integer> iDProizvod;
	public static volatile SingularAttribute<Proizvod, Kategorija> kategorijaID;
	public static volatile SingularAttribute<Proizvod, String> naziv;
	public static volatile ListAttribute<Proizvod, Stavka> stavkaList;
	public static volatile SingularAttribute<Proizvod, Long> cijena;
	public static volatile SingularAttribute<Proizvod, String> opis;
	public static volatile SingularAttribute<Proizvod, String> slikaURL;

}

