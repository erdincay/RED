/*
 * Copyright 2017 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.rf.ide.core.execution.server.response;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.rf.ide.core.execution.server.response.ServerResponse.ResponseException;
import org.rf.ide.core.testdata.model.table.variables.AVariable.VariableScope;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChangeVariableTest {

    @Test
    public void properMessageIsConstructed_forVariableChangeMessage() {
        assertThat(new ChangeVariable("a", VariableScope.GLOBAL, 1, newArrayList("a")).toMessage())
                .isEqualTo("{\"change_variable\":{\"name\":\"a\",\"values\":[\"a\"],\"scope\":\"global\",\"level\":1}}");
        assertThat(new ChangeVariable("a", VariableScope.TEST_SUITE, 2, newArrayList("b")).toMessage()).isEqualTo(
                "{\"change_variable\":{\"name\":\"a\",\"values\":[\"b\"],\"scope\":\"test_suite\",\"level\":2}}");
        assertThat(new ChangeVariable("a", VariableScope.TEST_CASE, 3, newArrayList("c")).toMessage())
                .isEqualTo("{\"change_variable\":{\"name\":\"a\",\"values\":[\"c\"],\"scope\":\"test_case\",\"level\":3}}");
        assertThat(new ChangeVariable("a", VariableScope.LOCAL, 4, newArrayList("d")).toMessage())
                .isEqualTo("{\"change_variable\":{\"name\":\"a\",\"values\":[\"d\"],\"scope\":\"local\",\"level\":4}}");
    }

    @Test
    public void mapperJsonProcessingExceptionIsWrappedAsResponseException() throws Exception {
        final ObjectMapper mapper = mock(ObjectMapper.class);
        when(mapper.writeValueAsString(any(Object.class))).thenThrow(JsonProcessingException.class);

        final ChangeVariable response = new ChangeVariable(mapper, "a", VariableScope.GLOBAL, 1, newArrayList("a"),
                newArrayList("1"));

        assertThatExceptionOfType(ResponseException.class).isThrownBy(response::toMessage);
    }
}
