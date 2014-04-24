package com.welovecoding.repository;

import static com.welovecoding.config.Packages.PERSISTENCE_UNIT_NAME;
import com.welovecoding.entities.Author;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuthorRepository extends AbstractRepository<Author> {

  @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
  EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public AuthorRepository() {
    super(Author.class);
  }

}