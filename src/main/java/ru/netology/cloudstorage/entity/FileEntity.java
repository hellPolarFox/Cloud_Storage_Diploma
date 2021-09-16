package ru.netology.cloudstorage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "cs_files")
public class FileEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("filename")
    @Column(nullable = false)
    private String filename;

    @JsonIgnore
    @Column(nullable = false)
    private String type;

    @JsonIgnore
    @Lob
    private byte[] fileData;

    @JsonProperty("size")
    private Long size;

    @JsonIgnore
    @OneToOne
    private UserEntity userEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FileEntity that = (FileEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1387483851;
    }
}
