package com.springboot.workspace;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TaskRepositoryTests.class, NoteRepositoryTests.class, CommentRepositoryTests.class, EventRepositoryTests.class, PostRepositoryTests.class, UserRepositoryTests.class})
public class RepositoryTestSuites {

}
