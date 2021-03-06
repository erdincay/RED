/*
* Copyright 2018 Nokia Solutions and Networks
* Licensed under the Apache License, Version 2.0,
* see license.txt file for details.
*/
package org.robotframework.ide.eclipse.main.plugin.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.robotframework.ide.eclipse.main.plugin.RedPlugin;

public class RedPreferencesPropertyTester extends PropertyTester {

    @Override
    public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
        if (expectedValue instanceof Boolean) {
            return testProperty(property, ((Boolean) expectedValue).booleanValue());
        }
        return false;
    }

    private static boolean testProperty(final String property, final boolean expected) {
        if ("isValidationTurnedOff".equals(property)) {
            return RedPlugin.getDefault().getPreferences().isValidationTurnedOff() == expected;
        }
        return false;
    }
}
