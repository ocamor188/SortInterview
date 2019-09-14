package com.platform.sixt.functions;

import com.platform.sixt.model.VulnerabilityScript;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class GraphTest {
    Graph graph = new Graph(7);

    @Test
    public void topologicalSort_showExecution() {
        VulnerabilityScript script1 = new VulnerabilityScript(1, Collections.singletonList(6));
        VulnerabilityScript script2 = new VulnerabilityScript(2, Collections.singletonList(1));
        VulnerabilityScript script3 = new VulnerabilityScript(3, Arrays.asList(1, 5));
        VulnerabilityScript script4 = new VulnerabilityScript(4, Arrays.asList(1, 2));
        VulnerabilityScript script5 = new VulnerabilityScript(5, Arrays.asList(2, 4));
        VulnerabilityScript script6 = new VulnerabilityScript(6, new ArrayList<>());
        List<VulnerabilityScript> vulnerabilityScripts = Stream.of(script1,script2,script3,script4,script5,script6)
                                                        .collect(Collectors.toList());

        for (VulnerabilityScript vulnerabilityScript : vulnerabilityScripts) {
            for (Integer dependency : vulnerabilityScript.getDependencies()) {
                graph.addEdge(vulnerabilityScript.getScriptId(), dependency);
            }
        }
        if (graph.isCyclic()) {
            throw new RuntimeException("Graph is cyclic");
        } else {
            graph.topologicalSort();
        }
    }

    @Test
    public void topologicalSort_throwsCyclicException()throws RuntimeException {
        graph = new Graph(7);
        VulnerabilityScript script1 = new VulnerabilityScript(1, Collections.singletonList(6));
        VulnerabilityScript script2 = new VulnerabilityScript(2, Collections.singletonList(1));
        VulnerabilityScript script3 = new VulnerabilityScript(3, Arrays.asList(1, 4));
        VulnerabilityScript script4 = new VulnerabilityScript(4, Arrays.asList(1, 3));
        VulnerabilityScript script5 = new VulnerabilityScript(5, Arrays.asList(2, 4));
        VulnerabilityScript script6 = new VulnerabilityScript(6, new ArrayList<>());
        List<VulnerabilityScript> vulnerabilityScripts = Stream.of(script1,script2,script3,script4,script5,script6)
                .collect(Collectors.toList());

        for (VulnerabilityScript vulnerabilityScript : vulnerabilityScripts) {
            for (Integer dependency : vulnerabilityScript.getDependencies()) {
                graph.addEdge(vulnerabilityScript.getScriptId(), dependency);
            }
        }
        Assert.assertFalse(!graph.isCyclic());
        Assert.assertTrue(graph.isCyclic());

    }

    @Test
    public void topologicalSort_happyPath(){
        graph = new Graph(5);
        VulnerabilityScript script1 = new VulnerabilityScript(1, Collections.singletonList(2));
        VulnerabilityScript script2 = new VulnerabilityScript(2, new ArrayList<>());
        VulnerabilityScript script3 = new VulnerabilityScript(3, Collections.singletonList(1));
        VulnerabilityScript script4 = new VulnerabilityScript(4, Collections.singletonList(2));
        List<VulnerabilityScript> vulnerabilityScripts = Stream.of(script1,script2,script3,script4)
                .collect(Collectors.toList());

        for (VulnerabilityScript vulnerabilityScript : vulnerabilityScripts) {
            for (Integer dependency : vulnerabilityScript.getDependencies()) {
                graph.addEdge(vulnerabilityScript.getScriptId(), dependency);
            }
        }
        Assert.assertFalse(graph.isCyclic());
        Assert.assertTrue(!graph.isCyclic());
    }
}