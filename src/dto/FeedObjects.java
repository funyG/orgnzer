package dto;

import java.math.BigDecimal;

public class FeedObjects {

    private String firstname;

    private String hours;
    private String proffesion;
    private String group_id;

    //funkcije spodaj so VOID -> ne pričakuje nazaj nič, nevem če je OK.
    private Integer AbcenceId;

    private Integer id;
    private String product_name;
    private String description;
    private BigDecimal price;
    private String allergens;

    private Integer category_id;
    private String category_name;
    private Integer sub_category_id;
    private Integer orderId;
    private Integer product;
    private Integer quantity;



    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public void setSub_category_id(Integer sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public Integer getSub_category_id() {
        return sub_category_id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return firstname;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public Integer getAbcenceId() {
        return  AbcenceId;
    }



    public void setDescription(String description) {
        this.description= description;

    }

    public String getDescription() {
        return description;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getAllergens() {
        return allergens;
    }

    public String getProduct_name() {
        return product_name;
    }


    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getHours() {
        return hours;
    }

    /**
     * @param hours the url to set
     */
    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getProffesion() {
        return proffesion;
    }

    public void setProffesion(String proffesion) {
        this.proffesion = proffesion;
    }


    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
}

