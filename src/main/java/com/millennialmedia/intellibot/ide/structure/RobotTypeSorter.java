package com.millennialmedia.intellibot.ide.structure;

import com.intellij.icons.AllIcons;
import com.intellij.ide.util.treeView.smartTree.ActionPresentation;
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.millennialmedia.intellibot.RobotBundle;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * @author mrubino
 * @since 2015-12-15
 */
public class RobotTypeSorter implements Sorter {

    private static final RobotTypeSorter INSTANCE = new RobotTypeSorter();

    public static Sorter getInstance() {
        return INSTANCE;
    }

    @Override
    public Comparator<RobotStructureViewElement> getComparator() {
        return (o1, o2) -> {
            if (o1 != null && o2 != null) {
                return Integer.compare(
                        o1.getType().ordinal(),
                        o2.getType().ordinal()
                );

            }
            return 0;
        };
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @NotNull
    @Override
    public ActionPresentation getPresentation() {
        return new ActionPresentationData(RobotBundle.message("action.structureView.sort.type"),
                null, AllIcons.ObjectBrowser.SortByType);
    }

    @NotNull
    @Override
    public String getName() {
        return "ROBOT_TYPE_COMPARATOR";
    }
}
