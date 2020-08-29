package com.jerrejerre.prueba;

import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findById(long id);
}
