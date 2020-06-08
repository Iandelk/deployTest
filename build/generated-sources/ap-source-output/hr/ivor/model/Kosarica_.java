package hr.ivor.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Kosarica.class)
public abstract class Kosarica_ {

	public static volatile SingularAttribute<Kosarica, Integer> iDKosarica;
	public static volatile SingularAttribute<Kosarica, Date> vrijeme;
	public static volatile ListAttribute<Kosarica, Stavka> stavkaList;
	public static volatile SingularAttribute<Kosarica, Long> ukupnaCijena;
	public static volatile SingularAttribute<Kosarica, Placanje> placanje;
	public static volatile SingularAttribute<Kosarica, Osoba> osobaID;

}

