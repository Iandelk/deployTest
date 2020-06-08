package hr.ivor.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Placanje.class)
public abstract class Placanje_ {

	public static volatile SingularAttribute<Placanje, String> vrsta;
	public static volatile ListAttribute<Placanje, Kosarica> kosaricaList;
	public static volatile SingularAttribute<Placanje, Integer> iDPlacanje;

}

