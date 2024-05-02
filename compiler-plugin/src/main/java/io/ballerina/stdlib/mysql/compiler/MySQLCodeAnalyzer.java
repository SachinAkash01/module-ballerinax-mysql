/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.mysql.compiler;

import io.ballerina.compiler.syntax.tree.SyntaxKind;
import io.ballerina.projects.plugins.CodeAnalysisContext;
import io.ballerina.projects.plugins.CodeAnalyzer;
import io.ballerina.stdlib.mysql.compiler.analyzer.InitializerParamAnalyzer;
import io.ballerina.stdlib.mysql.compiler.analyzer.RecordAnalyzer;

import java.util.List;

/**
 * MySQL Code Analyzer.
 */
public class MySQLCodeAnalyzer extends CodeAnalyzer {

    @Override
    public void init(CodeAnalysisContext ctx) {
        ctx.addSyntaxNodeAnalysisTask(new InitializerParamAnalyzer(),
                List.of(SyntaxKind.IMPLICIT_NEW_EXPRESSION, SyntaxKind.EXPLICIT_NEW_EXPRESSION));
        ctx.addSyntaxNodeAnalysisTask(new RecordAnalyzer(),
                List.of(SyntaxKind.LOCAL_VAR_DECL, SyntaxKind.MODULE_VAR_DECL));
    }
}
