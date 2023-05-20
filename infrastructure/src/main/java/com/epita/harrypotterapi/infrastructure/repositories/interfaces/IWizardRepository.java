package com.epita.harrypotterapi.infrastructure.repositories.interfaces;

import com.epita.harrypotterapi.infrastructure.entities.WizardEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IWizardRepository extends PagingAndSortingRepository<WizardEntity, Long> {
}
