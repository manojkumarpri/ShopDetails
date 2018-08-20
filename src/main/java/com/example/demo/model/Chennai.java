package com.example.demo.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.test.annotation.Repeat;



@SuppressWarnings("deprecation")
@Entity
/*@NamedQueries({
    @NamedQuery(
        name = "findChennaiByName",
        query = " from chennai a where a.name = :name"
        ),
})*/

@EntityListeners(AuditingEntityListener.class)


public class Chennai {
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	/*private String shopname;
	
	
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*@Column
    //@ElementCollection(targetClass=Siva.class)
	@ManyToMany(mappedBy="chennai")
	private List<Siva> siva=new ArrayList<Siva>();
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="joint",
	joinColumns={@JoinColumn(name="id")},
			
inverseJoinColumns={@JoinColumn(name="sid")})
	public List<Siva> getSiva() {
		return siva;
	}
	public void setSiva(List<Siva> siva) {
		this.siva = siva;
	}*/
	@NotNull
	private String name;
	@NotNull
	private String img;
	@NotNull
	private String prodCategory;
	@NotNull
	private String shopCategory;
	
	@NotNull
	private Double rating;
	@NotNull
	private String shortDesc;
	@NotNull
	private String longDesc;
	@NotNull
	private int size;
	@NotNull
	private Double price;
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
		@NotNull
	private String sku ;
	@NotNull
	private String BrandName ;
	@NotNull
	private int discount;
	@NotNull
	private Short tax;
	
	@NotNull
	private String shopName;
   
	@NotNull
	private Long prodId;
	private String review;
	@NotNull
	private int total;
	@NotNull
	private int available;
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public String getShopCategory() {
		return shopCategory;
	}
	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}
	
	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
	/*public List<Siva> getSiva() {
		return siva;
	}
	public void setSiva(List<Siva> siva) {
		this.siva = siva;
	}*/
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getBrandName() {
		return BrandName;
	}
	public void setBrandName(String brandName) {
		BrandName = brandName;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Short getTax() {
		return tax;
	}
	public void setTax(Short tax) {
		this.tax = tax;
	}

	
	}
	

