package com.bobcat.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bobcat.execution.Execution;

@RunWith(Suite.class)
@SuiteClasses({Execution.class})
public class Runner {

}
