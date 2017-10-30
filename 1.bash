#! /bin/bash
java -javaagent:/ebay/repositories/btrace/build/btrace-agent.jar com.ebay.btrace.Main

# JAVA SecurityException might happen. It's possibly that caused by btrace-boot.jar not copied. Make sure you have btrace-boot.jar in classpath.
# 
