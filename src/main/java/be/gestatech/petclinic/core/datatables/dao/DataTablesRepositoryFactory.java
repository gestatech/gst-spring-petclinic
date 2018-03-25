package be.gestatech.petclinic.core.datatables.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

public class DataTablesRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {

    public DataTablesRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        Class<?> repositoryInterface = metadata.getRepositoryInterface();
        if (DataTablesRepository.class.isAssignableFrom(repositoryInterface)) {
            return DefaultDataTablesRepository.class;
        } else {
            return super.getRepositoryBaseClass(metadata);
        }
    }
}
