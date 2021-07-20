package cl.walmart.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "01-products")
@JsonPropertyOrder({"id", "brand", "description", "image", "price"})
public class ProductDO {

	@Id
	private String _id;

	private int id;
	
	private String brand;
	
	private String description;

	private String image;
	
	private int price;

	private DiscountDO discount;
	
	public ProductDO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public DiscountDO getDiscount() {
		return discount;
	}

	public void setDiscount(DiscountDO discount) {
		this.discount = discount;
	}
}
