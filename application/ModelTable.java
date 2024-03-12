package application;

public class ModelTable {

	int id, price, quantity, subtotal;
	String item;
	
	public ModelTable(int id, int price, int quantity, int subtotal, String item) {
		
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.item = item;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
