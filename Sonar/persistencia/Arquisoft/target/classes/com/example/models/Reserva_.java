package com.example.models;

import com.example.models.Mobibus;
import com.example.models.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-23T22:28:39")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Long> id;
    public static volatile ListAttribute<Reserva, Usuario> listaEspera;
    public static volatile SingularAttribute<Reserva, Date> fecha;
    public static volatile SingularAttribute<Reserva, Usuario> usuario;
    public static volatile SingularAttribute<Reserva, Mobibus> busAsociado;

}