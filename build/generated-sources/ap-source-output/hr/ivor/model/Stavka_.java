package hr.ivor.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Stavka.class)
public abstract class Stavka_ {

	public static volatile SingularAttribute<Stavka, Integer> iDStavka;
	public static volatile SingularAttribute<Stavka, Kosarica> kosaricaID;
	public static volatile SingularAttribute<Stavka, Proizvod> proizvodID;
	public static volatile SingularAttribute<Stavka, Integer> brojPrimjeraka;

}

