package com.mysema.query.jpa.impl;

import javax.persistence.Query;

import org.hibernate.ejb.HibernateQuery;
import org.hibernate.transform.ResultTransformer;

import com.mysema.query.jpa.hibernate.FactoryExpressionTransformer;
import com.mysema.query.types.FactoryExpression;

/**
 * @author tiwe
 *
 */
public class HibernateQueryTransformation {
    
    public HibernateQueryTransformation(Query query, FactoryExpression<?> projection) {
        if (query instanceof HibernateQuery) {
            ResultTransformer transformer = new FactoryExpressionTransformer(projection); 
            ((HibernateQuery)query).getHibernateQuery().setResultTransformer(transformer);                    
        }
    }

}
