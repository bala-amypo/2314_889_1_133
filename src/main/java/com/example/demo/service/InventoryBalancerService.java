@Service
@RequiredArgsConstructor
public class InventoryBalancerService {

    private final ProductRepository productRepo;
    private final InventoryLevelRepository inventoryRepo;
    private final DemandForecastRepository forecastRepo;
    private final TransferSuggestionRepository suggestionRepo;

    public List<TransferSuggestion> generateSuggestions(Long productId) {

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product"));

        if (!product.isActive())
            throw new BadRequestException("Inactive product");

        List<InventoryLevel> inv = inventoryRepo.findByProduct_Id(productId);
        List<DemandForecast> fc = forecastRepo.findByProduct_Id(productId);

        if (inv.size() < 2 || fc.size() < 2)
            return List.of();

        InventoryLevel over = inv.stream().max(Comparator.comparingInt(InventoryLevel::getQuantity)).get();
        InventoryLevel under = inv.stream().min(Comparator.comparingInt(InventoryLevel::getQuantity)).get();

        TransferSuggestion ts = new TransferSuggestion();
        ts.setProduct(product);
        ts.setSourceStore(over.getStore());
        ts.setTargetStore(under.getStore());
        ts.setSuggestedQuantity(10);
        ts.setReason("Auto balancing");

        suggestionRepo.save(ts);
        return List.of(ts);
    }

    public TransferSuggestion getSuggestionById(Long id) {
        return suggestionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion"));
    }
}