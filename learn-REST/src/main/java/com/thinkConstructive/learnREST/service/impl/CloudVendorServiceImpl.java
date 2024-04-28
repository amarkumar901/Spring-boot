package com.thinkConstructive.learnREST.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinkConstructive.learnREST.exception.CloudVendorNotFoundException;
import com.thinkConstructive.learnREST.model.CloudVendor;
import com.thinkConstructive.learnREST.repository.CloudVendorRepository;
import com.thinkConstructive.learnREST.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{

    CloudVendorRepository cloudVendorRepository;

    
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success!";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        cloudVendorRepository.deleteById(vendorId);
        return "Success!";
    }

    @Override
    public CloudVendor getCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud vendor does not exist!");
        return cloudVendorRepository.findById(vendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
    
}
