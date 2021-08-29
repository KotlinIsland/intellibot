package com.millennialmedia.intellibot.ide.config;

import com.intellij.notification.*;
import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author mrubino
 * @since 2014-06-26
 */
@State(
        name = "RobotOptionsProvider",
        storages = {
                @Storage(file = StoragePathMacros.WORKSPACE_FILE)
        }
)
public class RobotOptionsProvider implements PersistentStateComponent<RobotOptionsProvider.State> {
    static {
        NotificationsConfiguration.getNotificationsConfiguration().register(
                "intellibot.debug", NotificationDisplayType.NONE);
    }

    public static class State {
        public boolean globalVariables = true;
        public boolean debug = false;
        public boolean capitalizeKeywords = false;
        public boolean inlineVariableSearch = false;
        public boolean stripVariableInLibraryPath = false;
        public boolean searchChildKeywords = true;
        public boolean loadProjectDefaultVariable = false;
        public int maxTransitiveDepth = 99;
        public boolean expandSuperSpaces = true;
        public String predefinedVariables = "";
    }

    private State state = new State();

    public static RobotOptionsProvider getInstance(Project project) {
        return ServiceManager.getService(project, RobotOptionsProvider.class);
    }

    @Nullable
    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void loadState(State state) {
        this.state.debug = state.debug;
        this.state.globalVariables = state.globalVariables;
        this.state.capitalizeKeywords = state.capitalizeKeywords;
        this.state.inlineVariableSearch = state.inlineVariableSearch;
        this.state.stripVariableInLibraryPath = state.stripVariableInLibraryPath;
        this.state.searchChildKeywords = state.searchChildKeywords;
        this.state.loadProjectDefaultVariable = state.loadProjectDefaultVariable;
        this.state.maxTransitiveDepth = state.maxTransitiveDepth;
        this.state.expandSuperSpaces = state.expandSuperSpaces;
        this.state.predefinedVariables = state.predefinedVariables;
        setPredefinedVaraibleTable();
    }

    private final Hashtable<String, String> predefinedVaraibleTable = new Hashtable<String, String>();

    public boolean isDebug() {
        return this.state.debug;
    }

    public void setDebug(boolean debug) {
        this.state.debug = debug;
    }

    public boolean allowGlobalVariables() {
        return this.state.globalVariables;
    }

    public void setGlobalVariables(boolean globalVariables) {
        this.state.globalVariables = globalVariables;
    }

    public boolean capitalizeKeywords() {
        return this.state.capitalizeKeywords;
    }

    public void setCapitalizeKeywords(boolean capitalizeKeywords) {
        this.state.capitalizeKeywords = capitalizeKeywords;
    }

    public boolean inlineVariableSearch() {
        return this.state.inlineVariableSearch;
    }

    public void setInlineVariableSearch(boolean inlineVariableSearch) {
        this.state.inlineVariableSearch = inlineVariableSearch;
    }

    public boolean stripVariableInLibraryPath() {
        return this.state.stripVariableInLibraryPath;
    }

    public void setStripVariableInLibraryPath(boolean stripVariableInLibraryPath) {
        this.state.stripVariableInLibraryPath = stripVariableInLibraryPath;
    }

    public boolean searchChildKeywords() {
        return this.state.searchChildKeywords;
    }

    public void setSearchChildKeywords(boolean searchChildKeywords) {
        this.state.searchChildKeywords = searchChildKeywords;
    }

    public boolean loadProjectDefaultVariable() {
        return this.state.loadProjectDefaultVariable;
    }

    public void setLoadProjectDefaultVariable(boolean loadProjectDefaultVariable) {
        this.state.loadProjectDefaultVariable = loadProjectDefaultVariable;
    }

    public int maxTransitiveDepth() {
        return this.state.maxTransitiveDepth;
    }

    public void setMaxTransitiveDepth(int maxTransitiveDepth) {
        this.state.maxTransitiveDepth = maxTransitiveDepth;
    }

    public boolean expandSuperSpaces() {
        return this.state.expandSuperSpaces;
    }

    public void setExpandSuperSpaces(boolean expandSuperSpaces) {
        this.state.expandSuperSpaces = expandSuperSpaces;
    }

    public String predefinedVariables() { return this.state.predefinedVariables; }

    public synchronized void setPredefinedVariables(String predefinedVariables) {
        this.state.predefinedVariables = predefinedVariables;
        setPredefinedVaraibleTable();
    }

    //private static final com.intellij.openapi.diagnostic.Logger LOGGER = com.intellij.openapi.diagnostic.Logger.getInstance(RobotOptionsProvider.class);
    //private static final com.intellij.openapi.diagnostic.Logger LOGGER = com.intellij.openapi.diagnostic.Logger.getInstance("#intellibot.RobotOptionsProvider");

    private synchronized void setPredefinedVaraibleTable() {
        predefinedVaraibleTable.clear();
        String[] lines = this.state.predefinedVariables.split("\n", 0);
        for (String line: lines) {
            if (line.isEmpty()) {
                continue;
            }
            String[] words = line.split("=", 2);
            if (words.length != 2) {
                continue;
            }
            predefinedVaraibleTable.put(words[0].trim(), words[1].trim());
        }
        if (isDebug()) {
            String message = "[RobotOptionsProvider] Variables:\n";
            for (Map.Entry<String, String> entry : getPredefinedVaraibleTable().entrySet()) {
                message += entry.getKey() + ": " + entry.getValue() + "\n";

            }
            Notifications.Bus.notify(new Notification("intellibot.debug", "Debug", message, NotificationType.INFORMATION));
        }
    }

    public Hashtable<String, String> getPredefinedVaraibleTable() {
        return this.predefinedVaraibleTable;
    }
}
