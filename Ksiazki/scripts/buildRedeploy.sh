#!/bin/sh

echo "************ UNDEPLOYING *******************"
/home/student/glassfish3/bin/asadmin undeploy book
echo "************ BUILDING **********************"
mvn package
echo "************ DEPLOYING *********************"
/home/student/glassfish3/bin/asadmin deploy target/book.war
