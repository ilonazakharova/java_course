package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {

    Github github = new RtGithub("8dca015290364ccc7fed30f0f5fa90e442aa50dc");
    RepoCommits commits = github.repos()
            .get(new Coordinates.Simple("ilonazakharova", "java_course")).commits();

    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
