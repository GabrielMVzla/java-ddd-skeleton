package tv.codely.mooc.courses.infrastructure.persistence.hibernate;

import org.hibernate.SessionFactory;
import tv.codely.shared.domain.Identifier;

import javax.transaction.Transactional;
import java.util.Optional;

//TODO este debería quedar en la carpeta shared - pero me daba problemas, no se actualizaba y no me reconocía el archivo .java

@Transactional
public abstract class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T>       aggregateClass;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    protected Optional<T> byId(Identifier id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id.getValue()));
    }
}
