import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsApiController {

    private final DataApiRepository dataApiRepository;

    @Autowired
    public JenkinsApiController(DataApiRepository dataApiRepository) {
        this.dataApiRepository = dataApiRepository;
    }

    @PostMapping("/jenkinsApi")
    public ResponseEntity<String> processJenkinsData(@RequestBody JenkinsModel jenkinsModel) {
        DataApi dataApi = new DataApi();
        dataApi.setIcto(jenkinsModel.getIcto());
        dataApi.setApiType(jenkinsModel.getName());
        dataApi.setCreatedAt(LocalDateTime.now());

        dataApiRepository.save(dataApi);

        return ResponseEntity.ok("Data saved successfully");
    }
}
