/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package protop.gradle.plugin;

import org.gradle.api.Project;
import org.gradle.api.Plugin;
import org.gradle.api.tasks.Exec;

import java.util.List;

public class ProtopGradlePlugin implements Plugin<Project> {
    public void apply(Project project) {
        ProtopExtension extension = project.getExtensions().create(
                "protop", ProtopExtension.class);

        project.getTasks().register("protopSync", Exec.class, task -> {
            List<String> args = List.of("protop", "sync");

            if (extension.refreshGitSources) args.add("--git-refresh");
            if (extension.useLinks) args.add("--use-links");

            task.commandLine(args);

            task.doLast(s -> System.out.println("Protop sync succeeded"));
        });
    }
}