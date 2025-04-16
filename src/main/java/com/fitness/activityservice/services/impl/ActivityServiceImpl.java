package com.fitness.activityservice.services.impl;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.entities.ActivityEntity;
import com.fitness.activityservice.mapper.ActivityMapper;
import com.fitness.activityservice.repositories.ActivityRepository;
import com.fitness.activityservice.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper activityMapper;

    @Override
    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        ActivityEntity activityEntity = activityMapper.activityRequestToActivityEntity(activityRequest);
        ActivityEntity savedActivity = activityRepository.save(activityEntity);
        return activityMapper.activityEntityToActivityResponse(savedActivity);
    }

    @Override
    public List<ActivityResponse> getUserActivities(String userId) {
        List<ActivityEntity> activityEntities = activityRepository.findByUserId(userId);
        if (!CollectionUtils.isEmpty(activityEntities)) {
            return activityEntities.stream()
                    .map(activityMapper::activityEntityToActivityResponse)
                    .toList();
        }
        return List.of();
    }

    @Override
    public ActivityResponse getActivityById(String activityId) {
        return activityRepository.findById(activityId)
                .map(activityMapper::activityEntityToActivityResponse)
                .orElseThrow(() -> new RuntimeException("Activity not found with id: " + activityId));
    }
}
