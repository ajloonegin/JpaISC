package ir.freeland.springboot.relation.onetoone.foreignkeybased2;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;
    
    @Column(name = "price")
    private String price;
    
    
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "corruptedItem_id", referencedColumnName = "id")
    private CorruptedItem corruptedItem;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public CorruptedItem getCorruptedItem() {
		return corruptedItem;
	}


	public void setCorruptedItem(CorruptedItem corruptedItem) {
		this.corruptedItem = corruptedItem;
	}
    
    
    
    


    
}
