# ebean-enhancer-issue-8

Sample project for https://github.com/ebean-orm-tools/ebean-idea-enhancer/issues/8

## Current behavior

Running the `sbt clean test:compile test` command runs the test successfully.

However, attempting to run it on IDEA using Ebean enhancer throws an error like the one seen in `error-sample.txt`

Tested versions are:
 - IDEA: 2022.2 (Community Edition)
 - Ebean enhancer plugin: 13.6.1
 - Ebean agent (via `~/.ebean` override):
   - 13.7.0
   - 13.6.1
   - 11.42.3
   - 11.27.1

## Desired behavior

Test can be run successfully in IDEA