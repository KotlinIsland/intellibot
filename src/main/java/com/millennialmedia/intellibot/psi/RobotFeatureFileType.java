package com.millennialmedia.intellibot.psi;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.millennialmedia.intellibot.ide.icons.RobotIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mrubino
 */
public class RobotFeatureFileType extends LanguageFileType {

    private static final RobotFeatureFileType INSTANCE = new RobotFeatureFileType();
    public static final String ROBOT_EXTENSION = "robot";
    static final String RESOURCE_EXTENSION = "resource";

    private RobotFeatureFileType() {
        super(RobotLanguage.INSTANCE);
    }

    public static RobotFeatureFileType getInstance() {
        return INSTANCE;
    }

    @NotNull
    public String getName() {
        return "Robot Feature";
    }

    @NotNull
    public String getDescription() {
        return "Robot Framework Test Data";
    }

    @NotNull
    public String getDefaultExtension() {
        return ROBOT_EXTENSION;
    }

    @Nullable
    public Icon getIcon() {
        return RobotIcons.FILE;
    }
}
