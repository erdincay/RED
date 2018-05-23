/*
 * Copyright 2015 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.robotframework.ide.eclipse.main.plugin.project.build.validation.versiondependent.setting;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.rf.ide.core.testdata.model.RobotVersion;
import org.rf.ide.core.testdata.model.table.setting.DefaultTags;
import org.robotframework.ide.eclipse.main.plugin.model.RobotSettingsSection;
import org.robotframework.ide.eclipse.main.plugin.project.build.ValidationReportingStrategy;

import com.google.common.collect.Range;

public class DuplicatedDefaultTagsValidator extends ADuplicatedValidator<DefaultTags> {

    public DuplicatedDefaultTagsValidator(final IFile file, final RobotSettingsSection section,
            final ValidationReportingStrategy parameter) {
        super(file, section, parameter);
    }

    @Override
    protected Range<RobotVersion> getApplicableVersionRange() {
        return Range.atLeast(new RobotVersion(3, 0));
    }

    @Override
    protected List<DefaultTags> getElements() {
        return section.getLinkedElement().getDefaultTags();
    }
}