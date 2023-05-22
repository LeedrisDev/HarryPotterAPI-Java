package com.epita.harrypotterapi.domain.repositories;

import com.epita.harrypotterapi.domain.models.wizard.Wizard;

public interface IWizardRepository {
    Wizard getWizardByUsername(String userName);
}
