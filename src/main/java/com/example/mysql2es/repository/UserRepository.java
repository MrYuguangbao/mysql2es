package com.example.mysql2es.repository;

import com.example.mysql2es.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: admin
 * @Description: UserRepository
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.repository
 * @CreateTime: 2020-11-08 16:06
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
