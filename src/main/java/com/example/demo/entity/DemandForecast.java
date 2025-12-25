@Entity
@Getter @Setter
public class DemandForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer forecastedDemand;
    private LocalDate forecastDate;
}