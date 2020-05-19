package com.example.demo2.documents;

import java.io.Serializable;
import java.util.Properties;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

/**
 * as
 */
public class StringGenerator implements IdentifierGenerator, Configurable {

    private String prefix;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = String.format("select %s from %s",
                session.getEntityPersister(obj.getClass().getName(), obj).getIdentifierPropertyName(),
                obj.getClass().getSimpleName());

        @SuppressWarnings("unchecked")
        Stream<String> ids = session.createQuery(query).stream();

        Long max = ids.map(o -> o.replace(prefix + "-", "")).mapToLong(Long::parseLong).max().orElse(0L);
        switch (obj.getClass().getSimpleName()) {
            case "GraficaPlan":
                Variables.GRAFICAPLANIDGLOBAL.label = prefix + "-" + (max + 1);
                break;
            case "Ejes":
                Variables.EJESGRAFICAIDGLOBAL.label = prefix + "-" + (max + 1);
                break;
            case "DataEjeY":
                Variables.DATAEJEYIDGLOBAL.label = prefix + "-" + (max + 1);
                break;
            default:
                Variables.GLOBAL.label = prefix + "-" + (max + 1);
                break;
        }
        return prefix + "-" + (max + 1);
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        prefix = params.getProperty("prefix");
    }

}