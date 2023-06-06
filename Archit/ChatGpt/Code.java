import javax.persistence.*;

@Entity
@Table(name = "data_api")
public class DataApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sr_no")
    private Long srNo;

    @Column(name = "icto", nullable = false)
    private String icto;

    @Column(name = "api_type", nullable = false)
    private String apiType;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructors, getters, and setters
}

// -------------------------------
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataApiRepository extends JpaRepository<DataApi, Long> {
}

// ------------------------------

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YourService {

    private final DataApiRepository dataApiRepository;

    @Autowired
    public YourService(DataApiRepository dataApiRepository) {
        this.dataApiRepository = dataApiRepository;
    }

    public void saveDataToTable(String icto, String apiType) {
        DataApi dataApi = new DataApi();
        dataApi.setIcto(icto);
        dataApi.setApiType(apiType);
        dataApi.setCreatedAt(LocalDateTime.now());

        dataApiRepository.save(dataApi);
    }
}



