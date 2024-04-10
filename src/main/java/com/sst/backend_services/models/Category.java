package  com.sst.backend_services.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category{
    @Id
    private long id;
    private String title;
    private String description;
}