/*
 * Copyright 2015 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.rf.ide.core.testdata.model.table.keywords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.rf.ide.core.testdata.model.AModelElement;
import org.rf.ide.core.testdata.model.FilePosition;
import org.rf.ide.core.testdata.model.ModelType;
import org.rf.ide.core.testdata.model.table.RobotExecutableRow;
import org.rf.ide.core.testdata.text.read.recognizer.RobotToken;
import org.rf.ide.core.testdata.text.read.recognizer.RobotTokenType;

public class KeywordReturn extends AModelElement<UserKeyword> {

    private final RobotToken declaration;

    private final List<RobotToken> values = new ArrayList<>();

    private final List<RobotToken> comment = new ArrayList<>();

    public KeywordReturn(final RobotToken declaration) {
        this.declaration = declaration;
    }

    @Override
    public boolean isPresent() {
        return (declaration != null);
    }

    @Override
    public RobotToken getDeclaration() {
        return declaration;
    }

    public List<RobotToken> getReturnValues() {
        return Collections.unmodifiableList(values);
    }

    public void addReturnValue(final RobotToken returnValue) {
        fixForTheType(returnValue, RobotTokenType.KEYWORD_SETTING_RETURN_VALUE, true);
        values.add(returnValue);
    }

    public List<RobotToken> getComment() {
        return Collections.unmodifiableList(comment);
    }

    public void addCommentPart(final RobotToken rt) {
        fixComment(getComment(), rt);
        this.comment.add(rt);
    }

    @Override
    public ModelType getModelType() {
        return ModelType.USER_KEYWORD_RETURN;
    }

    @Override
    public FilePosition getBeginPosition() {
        return getDeclaration().getFilePosition();
    }

    @Override
    public List<RobotToken> getElementTokens() {
        final List<RobotToken> tokens = new ArrayList<>();
        if (isPresent()) {
            tokens.add(getDeclaration());
            tokens.addAll(getReturnValues());
            tokens.addAll(getComment());
        }

        return tokens;
    }

    public RobotExecutableRow<UserKeyword> asExecutableRow() {
        RobotExecutableRow<UserKeyword> execRow = new RobotExecutableRow<>();
        execRow.setParent(getParent());
        execRow.setAction(getDeclaration());
        for (final RobotToken returns : values) {
            execRow.addArgument(returns);
        }
        for (final RobotToken commentPart : comment) {
            execRow.addComment(commentPart);
        }

        return execRow;
    }
}
