package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	    @Id  // Primary Key olduğunu
	    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id nin nasıl oluşacağını
	    @Column(name="product_id") // Hangi kolona karşılık geldiği
		private int id;
	    
	    //@Column(name="category_id")
		//private int categoryId;
	    
	    @Column(name="product_name")
		private String productName;
	    
	    @Column(name="unit_price")
		private double unitPrice;
	    
	    @Column(name="units_in_stock")
		private short unitsInStock;
	    
	    @Column(name="quantity_per_unit")
		private String quantityPerUnit;
	    
	    @ManyToOne()//İlişkili olduğu taban ile arasındaki durumu
	    @JoinColumn(name="category_id")//Category Tablosundaki category_id ile map ledi
	    private Category category;
	
}
