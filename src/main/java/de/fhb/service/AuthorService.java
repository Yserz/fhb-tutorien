package de.fhb.service;

import de.fhb.entities.Author;
import de.fhb.repository.AuthorRepository;
import de.yser.ownsimplecache.OwnCacheServerService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AuthorService extends BaseService<Author, AuthorRepository> {

  private static final Logger LOG = Logger.getLogger(AuthorService.class.getName());

  @EJB
  private AuthorRepository repository;
  @EJB
  private OwnCacheServerService cacheService;

  public AuthorService() {
    super(Author.class);
  }

  @PostConstruct
  public void init() {

  }

  @Override
  protected AuthorRepository getRepository() {
    return repository;
  }

  @Override
  protected OwnCacheServerService getCache() {
    return cacheService;
  }

}
