package org.grocery.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@Table(name="grocery_item")
@NoArgsConstructor
@AllArgsConstructor
public class GroceryItem {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
}
