public interface TransferSuggestionRepository extends JpaRepository<TransferSuggestion, Long> {
    List<TransferSuggestion> findByProduct_Id(Long productId);
}