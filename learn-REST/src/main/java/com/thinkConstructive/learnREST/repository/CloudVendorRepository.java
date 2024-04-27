package com.thinkConstructive.learnREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkConstructive.learnREST.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
    
}
