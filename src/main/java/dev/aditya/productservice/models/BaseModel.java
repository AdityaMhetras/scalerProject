package dev.aditya.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
//    @GeneratedValue(generator = "uuidgenerator")
//    @GenericGenerator(name = "uuidgenerator", strategy = "uuid4")
//    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
//    @Id
//    private UUID uuid;

    @Id
    @GeneratedValue(generator = "uuidgenerator")
    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID uuid;
}
