package interceptor;

import org.hibernate.*;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.type.Type;
import org.jboss.logging.Logger;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Mark on 2016/3/22.
 */
public class LoggingInterceptor extends EmptyInterceptor {
    private static Logger logger = LoggerFactory.logger(LoggingInterceptor.class);

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
        logger.debugv( "Entity {0}#{1} changed from {2} to {3}",
                entity.getClass().getSimpleName(),
                id,
                Arrays.toString( previousState ),
                Arrays.toString( currentState )
        );
        return super.onFlushDirty(entity,id,currentState,previousState,propertyNames,types);
    }
}
