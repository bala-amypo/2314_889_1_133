@Service
@RequiredArgsConstructor
public class DemandForecastService {

    private final DemandForecastRepository repo;

    public DemandForecast createForecast(DemandForecast f) {
        if (f.getForecastDate().isBefore(LocalDate.now()))
            throw new BadRequestException("Past date");

        return repo.save(f);
    }

    public List<DemandForecast> getForecastsForStore(Long storeId) {
        return repo.findByStore_Id(storeId);
    }
}