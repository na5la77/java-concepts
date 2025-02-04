package org.example.jobportal.mappers;

import org.example.jobportal.entities.Job;
import org.example.jobportal.models.JobDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobMapper {

    @Mapping(source = "jobTitle", target = "title")
//            ,qualifiedByName = "mapTitle", nullValueCheckStrategy=NullValueCheckStrategy.ALWAYS)
    @Mapping(source = "companyName", target = "company")
    @Mapping(source = "jobDescription", target = "description")
    Job jobDtoToJob(JobDto jobDto);

    @Mapping(source = "title", target = "jobTitle")
    @Mapping(source = "company", target = "companyName")
    @Mapping(source = "description", target = "jobDescription")
    JobDto jobToJobDto(Job job);
//    @Named("mapTitle")
//    default String mapTitle(String jobTitle){
//        return "alo" + jobTitle;
//    }
}

