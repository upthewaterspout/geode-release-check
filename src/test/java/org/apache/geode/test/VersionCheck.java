package org.apache.geode.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import com.gemstone.gemfire.internal.GemFireVersion;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.junit.Test;

public class VersionCheck {

  @Test
  public void verifyRevision() throws IOException {
    String binaryRevision = GemFireVersion.getSourceRevision();

    //TODO - use jgit to find the revision of the source checkout, verify
    //that it matches. Also, verify
    FileRepositoryBuilder builder = new FileRepositoryBuilder();
    final String sourceCheckout = System.getProperty("SOURCE_CHECKOUT");
    Repository repository = builder.setGitDir(new File(sourceCheckout + "/.git"))
      .readEnvironment() // scan environment GIT_* variables
      .findGitDir() // scan up the file system tree
      .build();
    String sourceVersion = repository.resolve("HEAD").getName();

    assertEquals(binaryRevision, sourceVersion);
  }

}
