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
        sh 'mvn package -Dmaven.test.skip=true'

        sh 'apk add --update --no-cache openssh sshpass'
        withCredentials(bindings: [usernamePassword(credentialsId: 'server-118.178.131.105', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 rm -rf /root/service/iteastyle-api'
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 mkdir /root/service/iteastyle-api'
          sh 'sshpass -p $PASSWORD scp -v -o StrictHostKeyChecking=no Dockerfile $USERNAME@118.178.131.105:/root/service/iteastyle-api/Dockerfile'
          sh 'sshpass -p $PASSWORD scp -v -o StrictHostKeyChecking=no docker-compose.yml $USERNAME@118.178.131.105:/root/service/iteastyle-api/docker-compose.yml'
          sh 'sshpass -p $PASSWORD scp -v -o StrictHostKeyChecking=no -r ./iteastyle-war/target/* $USERNAME@118.178.131.105:/root/service/iteastyle-api/'

          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 docker-compose -f /root/service/iteastyle-api/docker-compose.yml down'
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 docker rmi -f iteastyle-api:latest'
          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 docker build -t iteastyle-api /root/service/iteastyle-api/.'

          sh 'sshpass -p $PASSWORD ssh -v -o StrictHostKeyChecking=no $USERNAME@118.178.131.105 docker-compose -f /root/service/iteastyle-api/docker-compose.yml up -d'
        }

      }
    }
  }
}