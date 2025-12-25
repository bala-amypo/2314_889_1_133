public interface DemandForecastRepository extends JpaRepository<DemandForecast, Long> {
    List<DemandForecast> findByStore_Id(Long storeId);
    List<DemandForecast> findByProduct_Id(Long productId);
}