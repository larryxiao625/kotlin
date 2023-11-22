/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostic.compiler.based

import org.jetbrains.kotlin.analysis.low.level.api.fir.LLFirOnlyNonReversedTestSuppressor
import org.jetbrains.kotlin.analysis.low.level.api.fir.diagnostic.compiler.based.facades.LLFirAnalyzerFacadeFactoryWithoutPreresolve
import org.jetbrains.kotlin.test.builders.TestConfigurationBuilder
import org.jetbrains.kotlin.utils.bind

abstract class AbstractLLFirBlackBoxCodegenBasedTest : AbstractLLFirBlackBoxCodegenBasedTestBase() {
    override fun TestConfigurationBuilder.configureTest() {
        facadeStep(::LowLevelFirFrontendFacade.bind(LLFirAnalyzerFacadeFactoryWithoutPreresolve))
        baseConfiguration()
        useAfterAnalysisCheckers(::LLFirOnlyNonReversedTestSuppressor)
    }
}
