package com.welovecoding.web.data;
import com.welovecoding.web.entities.Category;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "categoryService")
@SessionScoped
public class CategoryService implements Serializable {

  @EJB
  private CategoryRepository repository;

  public CategoryService() {
  }

  public List<Category> getCategories() {
    return repository.getCategories();
  }

  public List<Category> getCategoriesOrderedByTitle() {
    return repository.getCategoriesOrderedByTitle();
  }

//  public String getUrlSlug(Category category) {
//    return Slugify.slugify(category.getTitle());
//  }
}