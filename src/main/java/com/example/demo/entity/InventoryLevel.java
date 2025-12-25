@Entity
@Getter @Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"store_id", "product_id"})
})
public class InventoryLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer quantity;

    private LocalDateTime lastUpdated;

    @PrePersist
    @PreUpdate
    public void touch() {
        lastUpdated = LocalDateTime.now();
    }
}