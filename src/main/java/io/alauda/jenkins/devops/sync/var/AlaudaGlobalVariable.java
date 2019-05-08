package io.alauda.jenkins.devops.sync.var;

import hudson.model.Job;
import hudson.model.Run;
import io.alauda.jenkins.devops.sync.AlaudaJobProperty;
import io.alauda.jenkins.devops.sync.WorkflowJobProperty;
import org.jenkinsci.plugins.workflow.cps.CpsScript;
import org.jenkinsci.plugins.workflow.cps.GlobalVariable;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;

import javax.annotation.Nonnull;
import java.util.Map;

public class AlaudaGlobalVariable extends GlobalVariable {
    @Nonnull
    @Override
    public String getName() {
        return "alaudaContext";
    }

    @Nonnull
    @Override
    public Object getValue(@Nonnull CpsScript script) throws Exception {
        Run<?,?> build = script.$build();

        AlaudaContext context = null;
        Job<?, ?> parent = build.getParent();
        if(parent instanceof WorkflowJob){
            WorkflowJobProperty property = parent.getProperty(WorkflowJobProperty.class);

            String ns = property.getNamespace();
            Map<String, String> data = property.getData();

            context = new AlaudaContext(true);
        }

        return new AlaudaContext();
    }
}
