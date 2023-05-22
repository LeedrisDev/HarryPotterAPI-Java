package com.epita.harrypotterapi.infrastructure.repositories;

import com.epita.harrypotterapi.domain.models.wizard.Wizard;
import com.epita.harrypotterapi.domain.repositories.IWizardRepository;
import com.epita.harrypotterapi.infrastructure.mappers.WizardsMapper;
import com.epita.harrypotterapi.infrastructure.repositories.jpa.IWizardRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WizardRepository implements IWizardRepository {
    private final IWizardRepositoryJPA wizardRepository;
    private final WizardsMapper mapper;

    @Autowired
    public WizardRepository(IWizardRepositoryJPA wizardRepository, WizardsMapper wizardsMapper) {
        this.wizardRepository = wizardRepository;
        this.mapper = wizardsMapper;
    }

    public Wizard getWizardByUsername(String username) {
        var wizardEntity = wizardRepository.getWizardEntityByUsername(username);
        return mapper.mapToDomain(wizardEntity);
    }
}
