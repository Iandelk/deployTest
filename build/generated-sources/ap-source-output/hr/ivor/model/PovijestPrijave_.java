package hr.ivor.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PovijestPrijave.class)
public abstract class PovijestPrijave_ {

	public static volatile SingularAttribute<PovijestPrijave, Date> vrijeme;
	public static volatile SingularAttribute<PovijestPrijave, String> iPAdresa;
	public static volatile SingularAttribute<PovijestPrijave, Integer> iDPovijestPrijave;
	public static volatile SingularAttribute<PovijestPrijave, Osoba> osobaID;

}

