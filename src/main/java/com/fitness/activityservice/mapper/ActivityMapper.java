package com.fitness.activityservice.mapper;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.entities.ActivityEntity;
import com.fitness.activityservice.enums.ActivityType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    ActivityEntity activityRequestToActivityEntity(ActivityRequest activityRequest);
    ActivityResponse activityEntityToActivityResponse(ActivityEntity activityEntity);

}
