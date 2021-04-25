package com.millennialmedia.intellibot.ide;

import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import com.intellij.testFramework.fixtures.CodeInsightTestFixture;
import com.millennialmedia.intellibot.ResourceLoader;

/**
 * @author mrubino
 * @since 2016-06-01
 */
public abstract class AbstractRobotIdeTest extends BasePlatformTestCase {

    protected final String  getTestFile() {
        return String.format("%s%s.robot", getTestDataPath(), getTestName(true));
    }

    @Override
    protected abstract String getBasePath();

    @Override
    protected final String getTestDataPath() {
        return ResourceLoader.getResourcePath(getBasePath());
    }

    protected final CodeInsightTestFixture getFixture() {
        return this.myFixture;
    }
}
