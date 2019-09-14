# SortInterview

# Examples for anagram and topological sort(graph)
Please check the code and tested.

# Anagram
Write a function boolean isAnagram(String lhs, String rhs). An anagram is direct word switch or word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase, using all the original letters exactly once; for example, the word ‘anagram' can be rearranged into ‘nagaram’.

# Topological Sort
Let's say I have a database of scripts. Each script has an arbitrary number of dependencies. The dependencies are expressed as a list of scriptIds that need to be executed before a given script. There are no circular dependencies. I want to come up with an execution plan so that I can run all of the scripts in a sane order. Below is the script representation.

### Example
```java
package com.sixt.platform.interview;

import java.util.List;

public class VulnerabilityScript {

   private final int scriptId;
   private final List<Integer> dependencies;

   public VulnerabilityScript(int scriptId, List<Integer> dependencies) {
       this.scriptId = scriptId;
       this.dependencies = dependencies;
   }

   public int getScriptId() {
       return scriptId;
   }

   public List<Integer> getDependencies() {
       return dependencies;
   }

}
 ```
