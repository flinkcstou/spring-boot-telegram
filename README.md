# greetgo.cash_management_service

#### Must be installed:
 - OpenJdk 8

####To run cash_management_service locally, you must perform the following steps:
1. Run *Application*. Debug server launched on localhost:8484.

####Prepare war to deploy
1. Run `gradle war`
war build directory: build/libs/

#### Docker
`./gradlew docker` - create docker image. 
  Properties:
   * imageTag - docker image tag (default 'latest')
   * repository - image repository
  
`./gralew dockerRun` - run container from image
 Properties:
   * container - container name
   * imageTag - docker image tag (default 'latest')
   * repository - image repository
   * runPort - host port (default '8080')
   * env.* - All parameters whose beginning coincides with this pattern will be exposed as container environment variables (without 'env.')
   
`./gralew dockerStop` - stop container from image
   * container - container name
