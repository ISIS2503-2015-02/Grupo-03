package com.example.models;

import com.example.models.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Reporte.class)
public class Reporte_ { 

    public static final SingularAttribute<Reporte, Integer> id;
    public static final SingularAttribute<Reporte, Date> fecha;
    public static final SingularAttribute<Reporte, Vehiculo> vehiculo;

}