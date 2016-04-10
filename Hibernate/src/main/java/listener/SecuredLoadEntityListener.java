package listener;

import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;
import org.hibernate.persister.entity.EntityPersister;

/**
 * Created by Mark on 2016/3/22.
 */
public class SecuredLoadEntityListener extends DefaultLoadEventListener {
    @Override
    public void onLoad(
            final LoadEvent event,
            final LoadEventListener.LoadType loadType) throws HibernateException {

        System.out.println("cdmcdmcdmcdmcdmcdmcdmcmdmcdmcmdmcmdcmdmcmdcm");
    }
}
