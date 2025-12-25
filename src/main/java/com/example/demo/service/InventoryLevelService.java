@Service
@RequiredArgsConstructor
public class InventoryLevelService {

    private final InventoryLevelRepository repo;

    public InventoryLevel createOrUpdateInventory(InventoryLevel inv) {
        if (inv.getQuantity() < 0)
            throw new BadRequestException("Negative inventory");

        List<InventoryLevel> existing =
                repo.findByStore_Id(inv.getStore().getId()).stream()
                        .filter(i -> i.getProduct().getId().equals(inv.getProduct().getId()))
                        .toList();

        if (!existing.isEmpty()) {
            InventoryLevel e = existing.get(0);
            e.setQuantity(inv.getQuantity());
            return repo.save(e);
        }
        return repo.save(inv);
    }

    public List<InventoryLevel> getInventoryForStore(Long storeId) {
        return repo.findByStore_Id(storeId);
    }

    public List<InventoryLevel> getInventoryForProduct(Long productId) {
        return repo.findByProduct_Id(productId);
    }
}