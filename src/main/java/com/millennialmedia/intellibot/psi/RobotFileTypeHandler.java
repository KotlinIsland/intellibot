package com.millennialmedia.intellibot.psi;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import com.millennialmedia.intellibot.ide.icons.RobotIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author mrubino
 */
public class RobotFileTypeHandler implements FileType {

    @Override
    public @NonNls @NotNull String getName() {
        return "RobotFramework";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Feature file for robot framework language";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "robot";
    }

    @Override
    public @Nullable Icon getIcon() {
        return RobotIcons.FILE;
    }

    @Override
    public boolean isBinary() {
        return false;
    }
}
