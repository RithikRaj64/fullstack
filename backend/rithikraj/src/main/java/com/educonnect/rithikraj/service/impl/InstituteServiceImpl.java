package com.educonnect.rithikraj.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.educonnect.rithikraj.dto.request.InstituteRequest;
import com.educonnect.rithikraj.dto.response.InstituteResponse;
import com.educonnect.rithikraj.dto.response.MessageResponse;
import com.educonnect.rithikraj.exception.NotFoundException;
import com.educonnect.rithikraj.model.Institute;
import com.educonnect.rithikraj.repository.InstituteRepository;
import com.educonnect.rithikraj.service.InstituteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class InstituteServiceImpl implements InstituteService {
    
    private final InstituteRepository instituteRepository;

    @Override
    public List<InstituteResponse> getAll() {
        List<Institute> institutes = instituteRepository.findAll();

        return institutes.stream()  
                            .map(institute -> InstituteResponse.builder()
                                .id(institute.getId())
                                .completed(institute.isCompleted())
                                .instituteName(institute.getInstituteName())
                                .location(institute.getLocation())
                                .email(institute.getEmail())
                                .mobile(institute.getMobile())
                                .website(institute.getWebsite())
                                .about(institute.getAbout())
                                .build())
                                .collect(Collectors.toList());
    }

    @Override
    public InstituteResponse getById(String id) throws NotFoundException {
        Optional<Institute> isInstitute = instituteRepository.findById(id);

        if(isInstitute.isEmpty()) {
            throw new NotFoundException("Institute not found with the id : " + id);
        }

        return InstituteResponse.builder()
                    .id(isInstitute.get().getId())
                    .completed(isInstitute.get().isCompleted())
                    .instituteName(isInstitute.get().getInstituteName())
                    .location(isInstitute.get().getLocation())
                    .email(isInstitute.get().getEmail())
                    .mobile(isInstitute.get().getMobile())
                    .website(isInstitute.get().getWebsite())
                    .about(isInstitute.get().getAbout())
                    .build();
    }

    @Override
    public MessageResponse deleteById(String id) {
        Optional<Institute> isInstitute = instituteRepository.findById(id);

        if(isInstitute.isEmpty()) {
            return MessageResponse.builder()
                                    .message("Institute not found with the id : " + id)
                                    .build();
        }

        instituteRepository.deleteById(id);

        return MessageResponse.builder()
                                .message("Institute deleted successfully")
                                .build();
    }

    @Override
    public MessageResponse updateDetails(String id, InstituteRequest request) {
        Institute institute = instituteRepository.findById(id).orElse(null);

        institute = setInstituteDetails(institute, request);        
        if(done(institute)) institute.setCompleted(true);

        instituteRepository.save(institute);

        return MessageResponse.builder().message("Details updated successfully").build();
    }

    private Institute setInstituteDetails(Institute institute, InstituteRequest request) {
        if(institute.getInstituteName() == null) institute.setInstituteName(request.getInstituteName());
        if(institute.getLocation() == null) institute.setLocation(request.getLocation());
        if(institute.getEmail() == null) institute.setEmail(request.getEmail());
        if(institute.getMobile() == null) institute.setMobile(request.getMobile());
        if(institute.getWebsite() == null) institute.setWebsite(request.getWebsite());
        if(institute.getAbout() == null) institute.setAbout(request.getAbout());

        return institute;
    }
    
    private boolean done(Institute institute) {
        Field[] fields = institute.getClass().getDeclaredFields();
        
        for(Field field : fields) {
            field.setAccessible(true);
            try {
                if(field.get(institute) == null) return false;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

}
