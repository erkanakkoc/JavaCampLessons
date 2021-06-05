package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{
	Product getByProductName(String productName);
	//getBy ı gördüğü anda tablodaki ilgili alana göre bir where koşulu oluşturuyor
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//select * from products where product_name = abc
	
	//select * from products where product_name = abc and category_id = 1
	
	//select * from products where product_name = abc or category_id = 1
	
	//select * from products where category_id in(1,2,3,4)
	
	//JPQL, Linq gibi bir sistem
	
	
	//JPQL (Java Persistence Query Language)
	@Query("From Product where productName=:productName and category.categoryId=:categoryId") //Entity ye göre yaz DB'ye göre değil
	List<Product> getByNameAndCategory(String productName, int categoryId); // : kullanarak sorguda bu parametre kullanılır.
	
	//select * from products where product_name =bisey and category_id=bisey
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	// select p.productId,p.productName, c.categoryName from Category c inner join Product p 
	// on c.categoryId = p.categoryId
	
}
