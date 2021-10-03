package ru.netology.cloudstorage.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.cloudstorage.entity.FileEntity;
import ru.netology.cloudstorage.entity.UserEntity;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

    List<FileEntity> findAllByFileOwner(String username, Sort sort);

    void removeFileByFilenameAndFileOwner(String fileName, String fileOwner);

    FileEntity findByFilenameAndFileOwner(String fileName, String fileOwner);
}
