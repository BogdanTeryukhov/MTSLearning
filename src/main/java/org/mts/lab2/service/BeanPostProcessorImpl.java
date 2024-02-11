package org.mts.lab2.service;

import org.mts.lab2.service.impl.CreateAnimalServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CreateAnimalServiceImpl) {
            CreateAnimalServiceImpl animalService = (CreateAnimalServiceImpl) bean;
            animalService.setAnimalType(animalService.defineTypeOfAnimal());
        }
        return bean;
    }
}