pipeline {
  agent any
  stages {
    stage('build') {
      agent {
        docker {
          image 'maven:3.5.3-jdk-8-alpine'
          args '-v /root/.m2:/root/.m2'
        }

      }
      steps {
        echo 'Starting build the app.....'
        sh 'mkdir /root/.m2'
        sh "echo '
        <?xml version="1.0" encoding="utf-8"?>

          <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
            <mirrors>
                <mirror>
                    <id>alimaven</id>
                    <name>aliyun maven</name>
                    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
                    <mirrorOf>central</mirrorOf>
                </mirror>
            </mirrors>
           </settings>' > settings.xml"
        sh 'mvn clean install -Dmaven.test.skip=true'

        sh 'apk add --update --no-cache openssh sshpass'
        withCredentials(bindings: [usernamePassword(credentialsId: 'server-118.178.131.105', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 rm -rf /root/service/iteastyle-api'
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 mkdir /root/service/iteastyle-api'
          sh 'sshpass -p $PASSWORD scp -v -o StrictHostKeyChecking=no docker-compose.yml $USERNAME@118.178.131.105:/root/service/iteastyle-web/docker-compose.yml'
          sh 'sshpass -p $PASSWORD scp -v -o StrictHostKeyChecking=no -r target/* $USERNAME@118.178.131.105:/root/service/iteastyle-api/'
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 docker-compose -f /root/service/iteastyle-api/docker-compose.yml stop '
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 docker-compose -f /root/service/iteastyle-api/docker-compose.yml rm -f '
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 docker-compose -f /root/service/iteastyle-api/docker-compose.yml up -d'
        }

      }
    }
  }
}