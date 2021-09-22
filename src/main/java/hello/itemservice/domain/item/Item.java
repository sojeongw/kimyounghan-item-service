package hello.itemservice.domain.item;

import lombok.Data;

// 실무에서는 도메인에 @Data를 쓰면 위험하다.
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
