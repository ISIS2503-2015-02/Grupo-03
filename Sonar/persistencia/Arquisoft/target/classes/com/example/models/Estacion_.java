package com.example.models;

import com.example.models.Ubicacion;
import com.example.models.Vcub;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Estacion.class)
public class Estacion_ { 

    public static final SingularAttribute<Estacion, Integer> id;
    public static final ListAttribute<Estacion, Vcub> vcubs;
    public static final SingularAttribute<Estacion, Integer> capacidad;
    public static final SingularAttribute<Estacion, Ubicacion> ubicacion;

}