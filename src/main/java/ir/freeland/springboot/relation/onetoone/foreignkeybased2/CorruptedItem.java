package ir.freeland.springboot.relation.onetoone.foreignkeybased2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "corruptedItem")
public class CorruptedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @OneToOne(mappedBy = "corruptedItem")
    private Item item;

    @Column(name = "reason")
    private String reason;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    

	@Override
	public String toString() {
		return "CorruptedItem [id=" + id + ", item=" + item + ", reason=" + reason + "]";
	}
	
	
	    
    
}
