/*
 * Copyright 2016 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.rf.ide.core.testdata.text.write;

import java.util.List;

import org.rf.ide.core.testdata.model.AModelElement;
import org.rf.ide.core.testdata.model.RobotFile;
import org.rf.ide.core.testdata.text.read.IRobotLineElement;
import org.rf.ide.core.testdata.text.read.RobotLine;
import org.rf.ide.core.testdata.text.read.recognizer.RobotToken;
import org.rf.ide.core.testdata.text.read.recognizer.RobotTokenType;

import com.google.common.base.Optional;

/**
 * @author wypych
 */
public class NotModelRelatedHashCommentedLineDumper {

    private final DumperHelper generalHelper;

    public NotModelRelatedHashCommentedLineDumper(final DumperHelper generalHelper) {
        this.generalHelper = generalHelper;
    }

    public <T> void dumpHashCommentsIfTheyExists(final AModelElement<T> previousElementDumped,
            final AModelElement<?> nextElementToBeDumped, final RobotFile model, final List<RobotLine> lines) {
        if (nextElementToBeDumped == null || previousElementDumped.getEndPosition().getLine()
                + 1 != nextElementToBeDumped.getBeginPosition().getLine()) {
            if (previousElementDumped.getBeginPosition().isNotSet()) {
                return;
            }
            final Optional<RobotToken> maxPosition = tokenWithMaxLineNumber(previousElementDumped);
            if (maxPosition.isPresent()) {
                final int startLine = maxPosition.get().getLineNumber();
                final List<RobotLine> oldContent = model.getFileContent();
                final Pair<Integer> boundaries = findLastHashLine(oldContent, startLine);
                if (boundaries.getLowerPoint() > -1) {
                    dumpCommentHashes(model, lines, boundaries.getLowerPoint(), oldContent, boundaries.getUpperPoint());
                }
            }
        }
    }

    private void dumpCommentHashes(final RobotFile model, final List<RobotLine> lines, final int startLine,
            final List<RobotLine> oldContent, final int lastLineToDump) {
        for (int lineIndex = startLine; lineIndex <= lastLineToDump; lineIndex++) {
            final RobotLine robotLine = oldContent.get(lineIndex);
            dumpHashLine(model, lines, robotLine);
        }
    }

    private void dumpHashLine(final RobotFile model, final List<RobotLine> lines, final RobotLine robotLine) {
        for (IRobotLineElement e : robotLine.getLineElements()) {
            generalHelper.getDumpLineUpdater().updateLine(model, lines, e);
        }

        if (!robotLine.getEndOfLine().getFilePosition().isNotSet()) {
            generalHelper.getDumpLineUpdater().updateLine(model, lines, robotLine.getEndOfLine());
        }
    }

    private <T> Optional<RobotToken> tokenWithMaxLineNumber(final AModelElement<T> elem) {
        Optional<RobotToken> max = Optional.absent();
        for (RobotToken t : elem.getElementTokens()) {
            if (max.isPresent()) {
                if (max.get().getFilePosition().getLine() < t.getLineNumber()) {
                    max = Optional.of(t);
                }
            } else {
                max = Optional.of(t);
            }
        }

        return max;
    }

    private Pair<Integer> findLastHashLine(final List<RobotLine> lines, final int startLine) {
        Pair<Integer> hashBoundaries = new Pair<>(-1, -1);

        int lineSize = lines.size();
        for (int lineIndex = startLine; lineIndex < lineSize; lineIndex++) {
            final RobotLine line = lines.get(lineIndex);
            for (final IRobotLineElement rle : line.getLineElements()) {
                if (rle instanceof RobotToken) {
                    if (rle.getTypes().contains(RobotTokenType.START_HASH_COMMENT)
                            || rle.getTypes().contains(RobotTokenType.COMMENT_CONTINUE)) {
                        if (hashBoundaries.getLowerPoint() == -1) {
                            hashBoundaries = new Pair<>(line.getLineNumber() - 1, line.getLineNumber() - 1);
                        } else {
                            hashBoundaries = new Pair<>(hashBoundaries.getLowerPoint(), line.getLineNumber() - 1);
                        }
                    } else {
                        return hashBoundaries;
                    }
                }
            }
        }

        return hashBoundaries;
    }

    private static class Pair<T> {

        private final T lowerPoint;

        private final T upperPoint;

        public Pair(final T lowerPoint, final T upperPoint) {
            this.lowerPoint = lowerPoint;
            this.upperPoint = upperPoint;
        }

        public T getLowerPoint() {
            return lowerPoint;
        }

        public T getUpperPoint() {
            return upperPoint;
        }

    }
}
