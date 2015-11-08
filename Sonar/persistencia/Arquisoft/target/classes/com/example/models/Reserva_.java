package com.example.models;

import com.example.models.Mobibus;
import com.example.models.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static final SingularAttribute<Reserva, Long> id;
    public static final ListAttribute<Reserva, Usuario> listaEspera;
    public static final SingularAttribute<Reserva, Date> fecha;
    public static final SingularAttribute<Reserva, Usuario> usuario;
    public static final SingularAttribute<Reserva, Mobibus> busAsociado;

}