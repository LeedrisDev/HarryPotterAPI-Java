package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.infrastructure.entities.WizardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWizardRepositoryJPA extends JpaRepository<WizardEntity, Long> {
}
